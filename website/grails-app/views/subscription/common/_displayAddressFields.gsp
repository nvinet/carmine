<div>
    <span class="fullName">${address.firstName.encodeAsHTML()} ${address.lastName.encodeAsHTML()}</span><br />
    ${address.houseNumberOrName.encodeAsHTML()} ${address.street.encodeAsHTML()}<br />
    ${address.city.encodeAsHTML()}<br />
    ${address.postcode.encodeAsHTML()}<br />
    <g:message code="country.name.${address.countryCode}"/><br />
    ${address.phoneNumber.encodeAsHTML()}<br />
</div>
