package subscription

/**
 * useful for copying command object properties onto domain classes
 */
class ObjectPropertyBindingService {

	static transactional = false

	def bindProperties(def source, def target) {
		target.metaClass.properties.each {
			if (it.getSetter() && it.name != 'metaClass' && it.name != 'class' && source.metaClass.hasProperty(source, it.name)) {
				it.setProperty(target, source.metaClass.getProperty(source, it.name))
			}
		}
		return target
	}
}
