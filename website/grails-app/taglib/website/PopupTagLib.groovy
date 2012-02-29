package website

class PopupTagLib {

	static namespace = 'pop'

	def popupRemoteLink = { attrs, body ->
		def onCloseCallback = attrs.elementId ? 'hashBang.removeFromLocation' : ''
		out << g.remoteLink(
				elementId: attrs.elementId,
				'data-hashbang': attrs.elementId,
				class: attrs.class,
				style: attrs.style,
				asynchronous: 'false',
				controller: attrs.controller,
				action: attrs.action,
				onFailure: attrs.onFailure,
                params: attrs.params,
				update: 'popupPlaceholder',
				onSuccess: "popup.popupThePopupPlaceholder(${onCloseCallback});"){body()}
	}

	def popupOnLoad = { attrs, body ->
		out << """
			<section id="hiddenPopupOnLoadContainer" style="display: none;">
				<section id="popupOnLoadContent" class="popup">${body()}</section>
				<a href="#popupOnLoadContent" id="popupOnLoadContentTrigger"></a>
			</section>
			<script>
				jQuery(function() {
					popup.popupThePopupOnLoadContainer(${attrs.blocking ? 'true' : 'false'}, function(){ ${attrs.onCloseCallback} });
				})
			</script>
			"""
	}

	def popupPlaceholder = {
		out << """
			<section id="hiddenPopupContainer" style="display: none;">
				<section id="popupPlaceholder" class="popup"></section>
			</section>
			<a href="#popupPlaceholder" id="popupPlaceholderTrigger" style="display: none;"></a>
			"""
	}

}
