<section id="enterShippingAddress">
    <g:form id="shippingAddressForm" name="shippingAddressForm" action="${formAction}" fragment="${fragment}" class="placeholderForm" autocomplete="off">
        <g:hasErrors bean="${shippingAddress}">
            <section class="messageError" id="registerError${headerPrefix}">
                <g:message code="subscription.address.error" />
            </section>
        </g:hasErrors>
        <div class="separatedContent clearfix">
			<section id="shippingAddress">
				<g:hiddenField name="useExistingId" value="newAddress"/>
				<g:render template="common/addressFieldInputs" model="[defaultAddressId:defaultShippingAddressId, address:shippingAddress, country:rd.getCountry()]"/>
				<g:if test="${showUseAsBillingCheckbox}">
						<div class="formRow clearfix">
							<div class="formCol">
								<g:checkBox name="useAsBilling" id="useAsBilling" checked="${shippingAddress?.useAsBilling}"/> <label for="useAsBilling"><g:message code="subscription.address.billing"/></label>
							</div>
						</div>
                    </g:if>
				<div style="width:400px">
					<g:submitButton class="newButton red right" id="shippingAddressFormSubmit" name="next" value="${g.message(code:'subscription.button.next')}"/>
					<g:submitButton class="newButton red left" id="shippingAddressFormCancel" name="cancel" value="${g.message(code:'subscription.button.cancel')}"/>
				</div>
			</section>
		</div>
    </g:form>
</section>