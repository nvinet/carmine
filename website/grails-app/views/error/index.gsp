<!DOCTYPE html>
<html lang="en">
    <head>
    </head>
    <g:applyLayout name="1Col">
    <body>
        <content tag="content">
            <div id="error">
                <h1><g:message code="error.title"/></h1>
                <p><g:message code="error.text1"/></p>
                <p><g:message code="error.text2"/></p>
				<p><a href="#" id="contactLink"><g:message code="error.link" /></a></p>
            </div>
			<script type="text/javascript">
				$(function(){
					$('#contactLink').click(function(){
						UserVoice.showPopupWidget(uvOptions);
						return false;
					})
				})
			</script>
        </content>
    </body>
    </g:applyLayout>
</html>