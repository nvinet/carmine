package payment

class AdyenBillingAddressCommand implements Serializable {

	private static final long serialVersionUID = 1

	String street
	String houseNumberOrName
	String city
	String postalCode
	String country //ISO 3166-1 alpha-2
	String billingAddressSig
    String stateOrProvince
}
