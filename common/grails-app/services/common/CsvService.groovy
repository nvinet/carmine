package common

import website.CustomerAddress
import subscription.BoxOrder

class CsvService {

	static transactional = false
	def loyaltyService

	def asCsv(ShipmentBatch shipmentBatch) {
		String csv = 'id,batch created,name,address1,address2,city,county,postcode,country,box,loyalty points,email\n'
		shipmentBatch.boxOrders.sort{it.dateCreated}.each { BoxOrder order ->
			CustomerAddress address = order.address
			def addressLines = getFirstAddressLines(address)
			Integer loyaltyPoints = loyaltyService.allTimePointsValueForCustomer(order.customer)
			csv += """"${shipmentBatch.id}-${order.id}","${shipmentBatch.dateCreated}","${sanitise(address.fullName)}","${sanitise(addressLines.line1)}","${sanitise(addressLines.line2)}","${sanitise(address.city)}","${sanitise(address.county)}","${getPostcode(address)}","$address.country.name","${order.country.isoCodeAlpha2}-${order.box.name}","$loyaltyPoints",$order.customer.email\n"""
		}
		return csv
	}
	
	def sanitise(String input) {
		input?.replaceAll('"',"'")
	}

	def getPostcode(CustomerAddress address) {
		return address?.country?.isoCode != 'irl' ? address.postcode : ''
	}

	def getFirstAddressLines(CustomerAddress address) {
		List<String> lines = splitOnWordBreaks("$address.houseNumberOrName $address.street", 40)
		[
			line1:lines ? lines.remove(0) : '',
			line2:lines ? lines.join(' ') : ''
		]
	}

	List<String>  splitOnWordBreaks(String input, int maxCharacters) {
		def lines = [:]
		int currentLine = 1
		input.split(/[ \t\r\n]/).each { word ->
		    if("${lines.get(currentLine, '')} $word".trim().size() > maxCharacters) {
		        currentLine ++
		    }
		    String line = lines.get(currentLine, '')
		    lines[currentLine] = "$line $word".trim()
		}
		return lines.values().findAll {it}
	}
}
