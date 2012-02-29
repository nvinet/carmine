
quartz {
	autoStartup = false
	jdbcStore = false
	waitForJobsToCompleteOnShutdown = true
}

environments {
	production {
		quartz {
			autoStartup = true
		}
	}
}
