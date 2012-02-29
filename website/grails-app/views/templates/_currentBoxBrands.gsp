<g:if test="${vh.currentBox().products}">
<section class="boxBrands clearfix">
    <vh:localisedLink mapping="brands"><r:img uri="${vh.getMediaServer()}/web/box/brands_${vh.currentBox().normalisedName}.jpg" /></vh:localisedLink>
</section>
</g:if>