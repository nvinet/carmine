<div style="padding: 20px">
	<div class="clearfix" style="margin-bottom:30px">
		<h3 class="left"><g:message code="box.subTitle" args="[box.name]"/></h3>
		<div class="right">
			<g:if test="${box.id == latestBox.id}">
				<vh:localisedLink mapping="works" fragment="subscription" class="left newButton red"><g:if test="${vh.boxHasStock(id:box.id)}"><g:message code="brand.subscription.link"/></g:if><g:else><g:message code="brand.subscription.link.noStock"/></g:else></vh:localisedLink>
			</g:if>
			<g:if test="${vh.boxHasStock(box)}">
                <g:link controller="checkout" action="orderGift" params="[boxId:box.id]" class="left newButton green" style="margin-left:15px;"><g:message code="brand.gift.link"/></g:link>
			</g:if>
            <g:if test="${box.reviewLink}"><a class="left newButton red" href="${box.reviewLink}" style="margin-left:15px;"><g:message code="account.boxes.review"/></a></g:if>
		</div>
	</div>
	<table>
		<tbody>
			<g:each in="${box.products}" var="product">
				<tr>
					<td><vh:localisedLink mapping="product" params="[normalisedProductName:product.indexedName]"><img src="${vh.getMediaServer()}/web/products/thumb/S/${product.indexedName}.jpg"/></vh:localisedLink></td>
					<td>
						<p><strong>${product.name}</strong></p>
						<p>${product.description}</p>
						<p><vh:localisedLink mapping="product" params="[normalisedProductName:product.indexedName]"><g:message code="box.description.link" /></vh:localisedLink></p>
					</td>
					<td>
						<vh:isUKSite>
							<vh:localisedLink mapping="brand" params="[normalisedBrandName:product.brand.indexedName]">
								<img src="${vh.getMediaServer()}/web/brand/logo/M/${product.brand.indexedName}.png"/>
							</vh:localisedLink>
						</vh:isUKSite>
						<vh:isFrenchSite>
							<vh:localisedLink mapping="product" params="[normalisedProductName:product.indexedName]">
								<img src="${vh.getMediaServer()}/web/brand/logo/M/${product.brand.indexedName}.png"/>
							</vh:localisedLink>
						</vh:isFrenchSite>
					</td>
				</tr>
			</g:each>
		</tbody>
	</table>
</div>