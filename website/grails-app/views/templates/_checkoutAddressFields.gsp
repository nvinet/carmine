<section class="checkoutContainer">
    <div class="checkoutBox">
        <g:hasErrors bean="${addressCommand}">
            <section class="messageError" id="addressErrorMessage">
                <g:message code="subscription.address.error" />
            </section>
            <br/>
        </g:hasErrors>
        <section id="addressFields">
            <p class="requiredMsg"><g:message code="checkout.delivery.address.fields.required"/></p>
            <h3><g:message code="checkout.delivery.address.title"/></h3>
            <section id="newAddressInputFields" class="clearfix">
                <div class="formCol">
                    <label for="addressFirstName" id="addressFirstName"><g:message code="subscription.label.firstname"/> <span class="required">*</span></label>
                    <vh:textField id="addressFirstName" name="firstName" command="${addressCommand}"/>
                    <br/>
                    <label for="addressLastName" id="addressLastName"><g:message code="subscription.label.lastname"/> <span class="required">*</span></label>
                    <vh:textField id="addressLastName" name="lastName" command="${addressCommand}"/>
                    <br/>
                    <label for="houseNumberOrName" id="houseNumberOrName"><g:message code="subscription.label.number"/> <span class="required">*</span></label>
                    <vh:textField name="houseNumberOrName" command="${addressCommand}"/>
                    <br/>
                    <label for="street" id="street"><g:message code="subscription.label.street"/> <span class="required">*</span></label>
                    <vh:textField name="street" command="${addressCommand}"/>
                </div>
                <div class="formCol">
                    <label for="addressCity" id="addressCity"><g:message code="subscription.label.city"/> <span class="required">*</span></label>
                    <vh:textField id="addressCity" name="city" command="${addressCommand}"/>
                    <br/>
                    <label for="addressCounty" id="addressCounty"><g:message code="subscription.label.county"/> <span id="countyRequired" class="required invisible">*</span></label>
                    <vh:textField id="addressCounty" name="county" command="${addressCommand}"/>
                    <br/>
                    <label for="addressPostcode" id="addressPostcode"><g:message code="subscription.label.postcode"/> <span id="postcodeRequired" class="required">*</span></label>
                    <vh:textField id="addressPostcode" name="postcode" command="${addressCommand}"/>
                    <br/>
                    <label for="addressCountryCode" id="addressCountry"><g:message code="subscription.label.country"/></label>
                    <span id="addressCountryCode"><vh:shippingCountryRadio name="countryCode" command="${addressCommand}" /></span>
                    <br/>
                    <label for="useAsBilling"><g:message code="checkout.delivery.address.fields.billing"/></label> <g:checkBox name="useAsBilling" checked="${addressCommand?.useAsBilling}"/>
                </div>
            </section>
        </section>
        <section class="clearfix">
            <div class="formColRight" style="width:26%; margin-right:0">
                <g:submitButton class="newButton red right" id="shippingAddressFormSubmit" name="next" value="${g.message(code:'checkout.delivery.button.next')}"/>
            </div>
            <div style="margin-top:10px"><g:message code="subscription.payment.terms.agreement"/> <vh:localisedLink mapping="terms"><g:message code="subscription.payment.terms.linktext"/></vh:localisedLink></div>
        </section>
    </div>
</section>
<g:if test="${displayBackButton}">
    <br/>
    <g:link controller="subscription" action="order" id="shippingAddressFormBack" class="newButton grey"><g:message code="checkout.delivery.button.back"/></g:link>
</g:if>

<script language="JavaScript" type="text/javascript">
    $(function(){
        $('#addressCountryCode input').on('click', function(event){
            if(this.value === 'gbr'){
                $('#countyRequired').css('visibility', 'hidden');
                $('#postcodeRequired').css('visibility', 'visible');
            }
            else {
                $('#countyRequired').css('visibility', 'visible');
                $('#postcodeRequired').css('visibility', 'hidden');
            }
        })
    })
</script>