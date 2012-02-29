package util

class Base62EncodeService implements Serializable {

	private static final long serialVersionUID = 1

	static transactional = false

	static CHARSET = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
	static int MAX_DIGIT = 62

	def encodeFromLong(long unEncodedLong) {
		StringBuilder output = new StringBuilder()
		while (unEncodedLong != 0) {
			def digit = unEncodedLong % MAX_DIGIT as Integer
			unEncodedLong = unEncodedLong / MAX_DIGIT
			output << CHARSET[digit]
		}
		output.reverse() as String
	}

	def decodeToLong(String encodedLong) {
		Long value = 0
		encodedLong.each { character ->
			value *= MAX_DIGIT
			value += CHARSET.indexOf(character)
		}
		return value
	}
}
