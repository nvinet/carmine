modules = {

	plugins {
		defaultBundle 'plugins'
		
		resource url: 'js/jquery/jquery.jcarousel.min.js'
		resource url: 'js/jquery/jquery.placeholder.js'
		resource url: 'js/jquery/jquery.cycle.js'
		resource url: 'js/jquery/fancybox/jquery.fancybox-1.3.4.min.js'
		resource url: 'css/jquery.fancybox-1.3.4.css'
		resource url: 'js/jquery/jquery-1.7.1.min.js', disposition:'head'
		resource url: 'js/jquery/jquery.tmpl.min.js'
	}

	modernizr {
		defaultBundle 'plugins'

		resource url: 'js/modernizr/modernizr-2.5.0.min.js', disposition:'head'
	}

	core {
		dependsOn 'plugins'
		defaultBundle 'script'

		resource url: 'js/core.js'

	}

	widgets {
		dependsOn 'core'
		defaultBundle 'script'

		resource url: 'js/widget.js'
		resource url: 'js/hashBang.js'
		resource url: 'js/popup.js'
		resource url: 'js/googleAnalytics.js', disposition:'head'

	}

	facebook {
		dependsOn 'core'
		defaultBundle 'script'

		resource url: 'js/facebook/auth.js'
		resource url: 'js/facebook/widgets.js'
	}

	screen {
		defaultBundle 'screen'
		resource url: 'css/reset.css', attrs:[media:'screen, projector, print'], bundle:'screen'
		resource url: 'css/queries.css', attrs:[media:'screen, projector, print'], bundle:'screen'
		resource url: 'css/var.less', attrs:[rel: "stylesheet/less", type:'css', media:'screen, projector, print'], bundle:'screen'
		resource url: 'css/resetOverride.less', attrs:[rel: "stylesheet/less", type:'css', media:'screen, projector, print'], bundle:'screen'
		resource url: 'css/base.less', attrs:[rel: "stylesheet/less", type:'css', media:'screen, projector, print'], bundle:'screen'
		resource url: 'css/carmine.less', attrs:[rel: "stylesheet/less", type:'css', media:'screen, projector, print'], bundle:'screen'
	}

	frOverride {
		dependsOn 'screen'
		defaultBundle 'frOverride'
		resource url: 'css/frOverride.less', attrs:[rel: "stylesheet/less", type:'css', media:'screen, projector, print'], bundle:'frOverride'
	}
}