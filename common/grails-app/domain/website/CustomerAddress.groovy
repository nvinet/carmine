package website

import auth.Customer
import common.AddressCommand

class CustomerAddress implements Serializable {

	private static final long serialVersionUID = 1;

	String firstName
	String lastName
	String houseNumberOrName
	String street
	String city
	String county
	String postcode
	Country country
	String phoneNumber
	boolean defaultBilling = false
	boolean defaultShipping = false

	static belongsTo = [owner:Customer]

	static mapping = {
		version false
	}

	static constraints = {
		firstName(blank:false)
		lastName(blank:false)
		houseNumberOrName(blank:false)
		street(blank:false)
		city(blank:false)
		county nullable:true
		postcode nullable:true
		phoneNumber(blank:true, nullable:true)
		defaultBilling(nullable:false)
		defaultShipping(nullable:false)
		owner nullable: true
	}

	static transients = ['countryCode', 'fullName']

	String getCountryCode() {
		return this.country?.isoCode
	}

	void setCountryCode(String code) {
		this.country = Country.findByIsoCode(code)
	}

	String getFullName() {
		"$firstName $lastName"
	}

    String toString() {
        "$houseNumberOrName $street"
    }

	def beforeInsert = {
		cleanAddress()
	}

	def beforeUpdate = {
		cleanAddress()
	}

	void cleanAddress() {
		cleanPostcode()
		capitalizeName()
		capitalizeAddress()
	}

	void capitalizeAddress() {
		houseNumberOrName = capitalizeFully(houseNumberOrName)
		street = capitalizeFully(street)
		city = capitalizeFully(city)
		county = capitalizeFully(county)
	}

	void capitalizeName() {
		firstName = capitalizeFully(firstName)
		lastName = capitalizeFully(lastName)
	}

	private String capitalizeFully(String input) {
		input?.split(/\s/)*.capitalize()?.join(' ')
	}

	void cleanPostcode() {
		if(postcode && postcode.toUpperCase() ==~ AddressCommand.UK_POSTCODE_REGEX) {
			postcode = postcode?.replaceAll(' ', '')?.toUpperCase()?.trim()
			postcode = "${postcode[0..-4]} ${postcode[-3..-1]}"
		}
	}
}
