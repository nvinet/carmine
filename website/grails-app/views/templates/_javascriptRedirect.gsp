<% def url = redirectUrl ?: g.createLink(controller:controller, action:action, params:queryParams) %>
<script>
	carmine.showSpinner()
	window.location = '${url}'
</script>