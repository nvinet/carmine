<section id="merchandising" class="merchandising clearfix">
	<%
		Integer index = 1
	%>
	<g:each in="${ads}" var="ad">
		<a <g:if test="${index == ads.size}">class="last"</g:if> href="${ad.uri}"><img src="${ad.image}" alt="${ad.text}" /></a>
		<%
		    index++
		%>
	</g:each>
</section>