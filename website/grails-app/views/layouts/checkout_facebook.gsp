<%@ page import="org.springframework.web.servlet.support.RequestContextUtils; website.CheckoutStep" %>

<%@ page import="org.springframework.web.servlet.support.RequestContextUtils; website.FeatureName" %>
<!DOCTYPE html>
<!-- ${RequestContextUtils.getLocale(request)} -->
<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!-- Consider adding a manifest.appcache: h5bp.com/d/Offline -->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
    <!-- QBit -->
    <script src="${vh.getConfigItem(name: 'qbit.script.url')}" async defer></script>

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <!-- Mobile viewport optimized: j.mp/bplateviewport -->
    <meta name="viewport" content="width=device-width">

    <title><g:layoutTitle default="Carmine" /></title>

    <link rel="shortcut icon" href="${resource(file:'favicon.ico')}" type="image/x-icon" />

    <g:layoutHead/>
    <r:require module="plugins" />
    <r:require module="modernizr" />
    <r:require module="core" />
    <r:require module="widgets" />
    <r:require module="screen" />
    <vh:isFrenchSite>
        <r:require module="frOverride" />
    </vh:isFrenchSite>
    <r:layoutResources />
</head>
<body class="${pageProperty(name:'body.class')}">

<section class="container" id="${pageName}" style="width:505px;">

    <section class="main clearfix" role="main">
        <section class="content">
            <section id="checkoutAddress" class="checkout">
                <g:layoutBody />
                ${pageProperty(name:'page.content')}
            </section>
        </section>
    </section>

</section>

<facebook:resources />

<r:layoutResources />

<g:render template="/templates/googleAnalytics" model="[ecommerceTracking:flash.ecommerceTracking, customVariables:analyticsCustomVariables]"/>
<g:render template="/templates/newDiscountVoucher" />

<pop:popupPlaceholder/>

<div style="display:none">
    <div id="spinner" class="spinner"><r:img uri="${g.resource(dir:'images/icons', file:'spinner.gif')}"/></div>
</div>
<a href="#spinner" id="spinnerLink" style="display:none"></a>



<script type="text/javascript">
    window.___gcfg = {
        lang: 'en-US'
    };

    (function() {
        var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
        po.src = 'https://apis.google.com/js/plusone.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
    })();
</script>
<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</body>
</html>