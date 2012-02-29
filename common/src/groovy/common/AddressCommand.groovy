package common

import website.CustomerAddress
import org.codehaus.groovy.grails.validation.Validateable

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 11/11/11
 * Time: 09:05
 * To change this template use File | Settings | File Templates.
 */

@Validateable
class AddressCommand implements Serializable {
	public static UK_POSTCODE_REGEX = /^[A-Z]{1,2}[0-9R][0-9A-Z]? ?[0-9][A-Z]{2}$/
	private static final long serialVersionUID = 1;

	String firstName
	String lastName
	String houseNumberOrName
	String street
	String city
	String county
	String postcode
	String countryCode
	String phoneNumber
	String useExistingId = 'no'
    boolean useAsBilling

	static constraints = {
		firstName(blank:false)
		lastName(blank:false)
		houseNumberOrName(blank:false)
		street(blank:false)
		city(blank:false)
		county nullable:true, validator: { val, obj ->
			if(obj.countryCode == 'irl'){
				val != null && val != ''
			}
		}
		postcode(blank:false)
		countryCode(blank:false)
		useExistingId(nullable:false)
		postcode(nullable: true, validator: { val, obj ->
			if (obj.countryCode == 'fra'){
				val ==~ /^[0-9]{5}$/
			}
			else {
				if(obj.countryCode != 'irl'){
					val && val.toUpperCase() ==~ UK_POSTCODE_REGEX
				}
			}
		})
	}

	boolean isUsingExistingCustomerAddress() {
		try {
			return useExistingId as Long
		} catch (Exception e) {
			return false
		}
	}

	CustomerAddress getExistingCustomerAddress() {
		return CustomerAddress.read(useExistingId as Long)
	}

	def getActualAddressFields() {
		return this.usingExistingCustomerAddress ? this.existingCustomerAddress : this
	}
}
