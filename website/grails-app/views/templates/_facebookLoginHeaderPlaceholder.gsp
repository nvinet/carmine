<div class="facebookButton ${size} ${position}" id="${containerId}"></div>

<r:script>
    $(function(){
        <g:if test="${!flash.newDiscountVoucherStatus}">
            $('body').on('facebook_auth_start', carmine.showSpinner)
            $('body').on('facebook_auth_end', carmine.hideSpinner)
        </g:if>
        facebook.initFacebookAuth($('#${containerId}'), '${g.message(code:loginMsg)}', '${g.message(code:logoutMsg)}')
    })
</r:script>