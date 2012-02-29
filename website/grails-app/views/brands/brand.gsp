<!DOCTYPE html>
<html lang="en">
    <head>
        <g:if test="${brand.content}">
		<title>${brand.content?.metaTitle}</title>
		<meta name="description" content="${brand.content?.metaDescription}">
		</g:if>
		<meta name="layout" content="2ColsEquals" />

    </head>
    <body class="brand">
        <content tag="leftCol">
			<r:script>
				$(function(){
					var tweetsID = ['${brand.content?.tweet1}','${brand.content?.tweet2}']
					for(var i in tweetsID){
						widget.getTweet(tweetsID[i], function(data){
							$( "#tweetTemplate" ).tmpl( data ).appendTo( "#tweets" );
						})
					}
				})
			</r:script>

			<h1><img src="${vh.getMediaServer()}/web/brand/logo/L/${brand.indexedName}.png"/><span>${brand.name}</span></h1>
			${brand.content?.intro}
			<div class="clearfix">
				<g:if test="${brand.brandWebsite}"><div class="left" style="width:70%"><a href="${brand.brandWebsite}" class="newButton red">Shop</a></div></g:if>
				<div class="right" style="width:30%">
					<g:if test="${brand.facebookLink}"><div class="left" style="margin-right:10px"><a href="${brand.facebookLink}"><r:img uri="/images/icons/facebook_medium.png" /></a></div></g:if>
					<g:if test="${brand.twitterLink}"><div class="left" style="margin-right:10px"><a href="${brand.twitterLink}"><r:img uri="/images/icons/twitter_medium.png" /></a></div></g:if>
					<div class="g-plusone" data-href="#" data-size="medium" data-count="false"></div>
				</div>
			</div>
			<br/>
			<div class="clearfix">

				<g:render template="/templates/tweet"/>

			</div>
			<br /><br />
			${brand.content?.caption}
		</content>

		<content tag="rightCol">
			<br/><vh:localisedLink mapping="works" fragment="subscribe" class="newButton red"><g:message code="brand.box.subscribe.link"/></vh:localisedLink><br/><br/><br/>
			${brand.content?.image}
			<br/><br/>
			${brand.content?.history}

        </content>
    </body>
</html>