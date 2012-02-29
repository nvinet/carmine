<section id="newAddressInputFields">
	<div class="formRow clearfix">
        <div class="formCol">
            <span class="field-with-placeholder">
                <label for="addressFirstName" id="addressFirstName_placeholder" class="placeholder"><span><g:message code="subscription.label.firstname"/></span></label>
				<vh:textField id="addressFirstName" name="firstName" command="${address}"/>
            </span>
        </div>
        <div class="formCol">
            <span class="field-with-placeholder">
                <label for="addressLastName" id="addressLastName_placeholder" class="placeholder"><span><g:message code="subscription.label.lastname"/></span></label>
				<vh:textField id="addressLastName" name="lastName" command="${address}"/>
            </span>
        </div>
    </div>
    <div class="formRow clearfix">
        <div class="formCol">
            <span class="field-with-placeholder">
                <label for="houseNumberOrName" id="houseNumberOrName_placeholder" class="placeholder"><span><g:message code="subscription.label.number"/></span></label>
				<vh:textField name="houseNumberOrName" command="${address}"/>
            </span>
        </div>
        <div class="formCol">
	        <span class="field-with-placeholder">
                <label for="street" id="street_placeholder" class="placeholder"><span><g:message code="subscription.label.street"/></span></label>
				<vh:textField name="street" command="${address}"/>
            </span>
        </div>
    </div>
    <div class="formRow clearfix">
        <div class="formCol">
	        <span class="field-with-placeholder">
                <label for="addressCity" id="addressCity_placeholder" class="placeholder"><span><g:message code="subscription.label.city"/></span></label>
				<vh:textField id="addressCity" name="city" command="${address}"/>
            </span>
        </div>
		<div class="formCol">
	        <span class="field-with-placeholder">
                <label for="addressCounty" id="addressCounty_placeholder" class="placeholder"><span><g:message code="subscription.label.county"/></span></label>
				<vh:textField id="addressCounty" name="county" command="${address}"/>
            </span>
        </div>
    </div>
    <div class="formRow clearfix">
        <div class="formCol">
	        <span class="field-with-placeholder">
                <label for="addressPostcode" id="addressPostcode_placeholder" class="placeholder"><span><g:message code="subscription.label.postcode"/></span></label>
				<vh:textField id="addressPostcode" name="postcode" command="${address}"/>
            </span>
        </div>
		<div class="formCol">
            <span class="field-with-placeholder">
                <label for="addressPhone" id="addressPhone_placeholder" class="placeholder"><span><g:message code="subscription.label.phone"/></span></label>
				<vh:textField id="addressPhone" name="phoneNumber" command="${address}"/>
            </span>
        </div>
	</div>
	<div class="formRow clearfix">
		<div class="formCol">
			<vh:shippingCountrySelect id="addressCountryCode" name="countryCode" command="${address}" />
        </div>
	</div>
</section>