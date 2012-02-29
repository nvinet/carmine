package common

class BackgroundTask {

	BackgroundTaskName name
	boolean locked = false

	static constraints = {}

	static mapping = {
		version false
	}

	def lock() {
		locked = true
		this.save(flush:true)
	}

	def unlock() {
		locked = false
		this.save(flush:true)
	}

}
