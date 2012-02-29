package payment

class AdyenSignedParameterExtractorService {

	static transactional = true

	String extractValuesToSign(command, namesOfParamsUsedInSigning) {
		String valuesToSign = ''
		namesOfParamsUsedInSigning.each { param ->
			if(command.metaClass.hasProperty(command, param)) {
				def property = command.metaClass.getProperty(command, param)
				valuesToSign = "${valuesToSign}${property?:''}"
			}
		}
		return valuesToSign
	}
}
