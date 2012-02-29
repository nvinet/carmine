var Ajax;
if (Ajax && (Ajax != null)) {
	Ajax.Responders.register({
	  onCreate: function() {
        if($('spinner') && Ajax.activeRequestCount>0)
          Effect.Appear('spinner',{duration:0.5,queue:'end'});
	  },
	  onComplete: function() {
        if($('spinner') && Ajax.activeRequestCount==0)
          Effect.Fade('spinner',{duration:0.5,queue:'end'});
	  }
	});
}

$(function() {
	$('.are-you-sure').click(function() {
		var confirmed = confirm('are you sure?')
		if(confirmed == true) {
			return true
		} else {
			return false
		}
	})
})

