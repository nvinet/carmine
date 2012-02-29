<g:form controller="boxOrder" action="changeBoxOrdered">
	<select name="boxId">
		<g:each var="box" in="${boxOptions}">
			<option value="${box.id}">${box.name}</option>
		</g:each>
	</select>
	<g:hiddenField name="boxOrderId" value="${order.id}"/>
	<input type="submit" value="Change box" class="are-you-sure">
</g:form>