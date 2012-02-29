<%@ page import="website.ReferralType" %>
<div class="innerPopup">
    <h1><g:message code="account.points.share.mail.title" args="[sec.loggedInCustomerField(field:'firstName')]"/></h1>
    <div id="shareMailPopup" class="content clearfix">
        <p><g:message code="account.points.share.mail.description"/></p>
        <blockquote>
            <g:message code="account.points.share.mail.content"/>
            <vh:createReferLink referralTypePrefix="${ReferralType.email.urlCode}" referCode="${customer.referralCode}"/>?promo=<vh:isUKSite>Ref4589</vh:isUKSite><vh:isFrenchSite>Ref3389</vh:isFrenchSite>
        </blockquote>
    </div>
</div>