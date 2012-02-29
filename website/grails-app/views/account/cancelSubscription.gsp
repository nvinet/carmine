<div id="cancelPopupContent" class="innerPopup" style="background:url(/images/popup_bg_cancel.png) right top no-repeat; padding-right:180px; height:230px">
    <h1><g:message code="account.subscription.cancel.title"/></h1>
    <div class="content clearfix">
        <p style="margin:20px 0"><g:message code="account.subscription.cancel.notice"/></p>
        <p style="margin:40px 0"><a id="cancelBack" href="#" class="button grey"><span class="arrowLeft"><g:message code="account.subscription.cancel.button.back"/></span></a></p>
        <p style="margin:20px 0"><g:remoteLink elementId="cancelProceed" controller="account" action="cancelSubscription" update="cancelPopupContent" params="[id:subscription.id, agree:true]"><g:message code="account.subscription.cancel.button.proceed"/></g:remoteLink></p>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#cancelBack').on('click', function(e){
            popup.close()
            e.preventDefault()
        })
    })
</script>