<div id="tweets" class="tweet"></div>
<script id="tweetTemplate" type="text/x-jquery-tmpl">
	<div class="clearfix">
		<span>&nbsp;</span>
		<section class="left">
			<a href="https://twitter.com/#!/{{html user.screen_name }}/status/{{html id_str }}">
			<img src="{{html user.profile_image_url }}" />
			</a>
		</section>
		<section class="left" style="width:80%; margin-left:10px">
			<p><a href="http://twitter.com/#!/{{html user.screen_name }}">{{html '@' + user.screen_name }}</a></p>
			<p>"{{html widget.applyTweetTextReplacements(text) }}"</p>
		</section>
	</div>
</script>
