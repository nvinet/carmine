package encryption

class HmacService {

	static transactional = false

	String getBase64EncodedSignature(String secret, String signingData) {
		HMACTools.getBase64EncodedSignature(secret, signingData)
	}

	boolean verifyBase64EncodedSignature(String secret, String sig, String signedData) {
		HMACTools.verifyBase64EncodedSignature(secret, sig, signedData)
	}
}
