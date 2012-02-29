<%@ page import="website.FeatureName;" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title><g:message code="meta.title.default"/></title>
     	<meta name="layout" content="1Col" />
        <meta name="description" content="${g.message(code:'meta.description.default')}">
        <meta property="og:title" content="Carmine UK" />
        <meta property="og:url" content="${vh.createAbsoluteLink(mapping:'/')}" />
        <meta property="og:image" content="" />
        <vh:isUKSite>
			<link rel=”canonical” href=”http://www.carmine.co.uk/” />
		</vh:isUKSite>
		<vh:isFrenchSite>
			<link rel=”canonical” href=”http://www.carminebeaute.com/” />
		</vh:isFrenchSite>
    </head>
    <body class="homeBody">
        <content tag="content">
			<section id="homepage">
				<h1 class="outOfBounds"><g:message code="home.title"/></h1>
				<div class="home_carousel">
					<a href="#" class="carouselButton" id="home_carousel">
						<div id="caroussel">
							<r:img uri="/images/home/carousel_${vh.getCountryCode()}_1.jpg" id="carousel_1" />
							<r:img uri="/images/home/carousel_${vh.getCountryCode()}_2.jpg" id="carousel_2" style="display:none;" />
							<r:img uri="/images/home/carousel_${vh.getCountryCode()}_3.jpg" id="carousel_3" style="display:none;" />
						</div>
					</a>
					<div id="home_carousel_nav" class="home_carousel_nav"></div>
				</div>
			</section>

			<g:render template="/templates/currentBoxBrands" model="[size:'m', showBoxLink:true]"/>

			<g:render template="/templates/merchandising" model="[ads:ads]"/>

			<section id="testimonials" class="testimonial home">
				<vh:isUKSite>
					<p><span class="quote">“ </span>On the whole, this was an excellent box and each product is something I can use regularly.<span class="quote"> ”</span></p>
					<p class="quoter"><vh:localisedLink mapping="testimonial">Stacey, Ace Stace Beauty</vh:localisedLink></p>
				</vh:isUKSite>
			</section>

			<r:script>
				$(function() {
					widget.bindHomeCarousel($('#caroussel'), '#home_carousel_nav');
					<vh:isFrenchSite>
					$('#home_carousel').on('click', function(){
						window.location = '${g.createLink(controller:'subscription', action:'order')}';
					})
					</vh:isFrenchSite>
					<vh:isUKSite>
					$('#carousel_1').on('click', function(){
						window.location = '${g.createLink(controller:'subscription', action:'order')}';
					})
					$('#carousel_2').on('click', function(){
						window.location = '${vh.localisedUrl(mapping:'gifts')}';
					})
					$('#carousel_3').on('click', function(){
						window.location = '${vh.localisedUrl(mapping:'works')}';
					})
					</vh:isUKSite>
                    <g:if test="${!flash.newDiscountVoucherStatus}">
                        $('body').on('facebook_auth_success', function(){
                            carmine.redirect("${facebookRedirectUrl}")
                        })
                    </g:if>
				});
			</r:script>
			<g:render template="/templates/footerNote"/>
        </content>
    </body>
</html>