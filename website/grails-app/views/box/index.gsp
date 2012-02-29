<%@ page import="subscription.Box; groovy.time.TimeCategory; website.FeatureName" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Carmine Beauty Box - Treat Yourself With A Box Full Of Beauty Samples</title>
		<meta name="description" content="Carmine October Box - Find out all the great beauty products that are in the Carmine October box.">
		<meta name="layout" content="1Col" />
    </head>
    <body class="boxePage">
        <content tag="content">
            <h1><g:message code="box.title"/></h1>
			<%
            	def navItem = []
				use (TimeCategory){
					def startDate = new GregorianCalendar(2011, Calendar.OCTOBER, 28).getTime()

					(0..11).each{
						def date = startDate + it.month
						def previousDate = date - 1.month
						def box = Box.boxPublicForThisMonth(country, previousDate, date).list()
						if(box){
							navItem << [date:date, box: box[0]]
						}
						else {
							navItem << [date:date, box: null]
						}
					}
				}

			%>
			<nav id="boxNav" class="boxNav">
				<ul class="clearfix">
					<g:each in="${navItem}" var="item">
						<g:if test="${item.box}">
							<li class="hasBox<g:if test="${item.box.id == latestBox.id}"> selected</g:if>"><a href="#${item.box.id}"><g:formatDate date="${item.date}" format="MMM"/></a></li>
						</g:if>
						<g:else>
							<li><g:formatDate date="${item.date}" format="MMM"/></li>
						</g:else>
					</g:each>
				</ul>
            </nav>
			<section id="displayBox">
				<g:render template="boxDetails" model="[box:latestBox, latestBox:latestBox]"/>
			</section>
        </content>

		<r:script>
			$(function(){
				var cache = {}

				$(window).on('hashchange', function(e){
					var hash = window.location.hash
					if(!hash){
						hash = '#${latestBox.id}'
						cache[${latestBox.id}] = $('#displayBox').html()
					}
					var boxId = hash.replace('#','')

					if(cache[boxId]){
						$('#displayBox').html(cache[boxId])
					}
					else {
						$.ajax({
							type:'POST',
							data:{'id': boxId},
							url:'${g.createLink(action:'boxContent')}',
							context: document.body,
							success: function(data,textStatus){
								$('#displayBox').html(data)
								cache[boxId] = data
							},
							error: function(data,textStatus){
								alert('error')
							}
						})
					}
					$('#boxNav li').removeClass('selected')
					hash && $('#boxNav li a[href="' + hash + '"]').parent().addClass('selected')
				})
				$(window).trigger('hashchange');
			})
		</r:script>

    </body>
</html>