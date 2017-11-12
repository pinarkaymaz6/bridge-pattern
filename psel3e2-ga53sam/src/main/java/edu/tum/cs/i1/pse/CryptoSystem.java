package edu.tum.cs.i1.pse;

public class CryptoSystem {

	// TODO: Introduce a new class Encryption that allows you to add encryption
	// TODO: Hint: create a Cipher delegate in your Encryption class and name it "imp"
	// algorithms independently of the application domain
	// TODO: Create subclasses of Encryption for personal and enterprise
	// TODO: In the subclasses implement the "encrypt" and "decrypt" functions according to the information in the slides
	// encryption
	// TODO: Replace the implementation of the Cipher algorithm with the new
	private Encryption impl;

	public CryptoSystem(String encryptionType) {

		if (encryptionType.equalsIgnoreCase("Enterprise"))
			impl = new EnterpriseEncryption();
		else if(encryptionType.equalsIgnoreCase("Personal"))
			impl = new PersonalEncryption();
		else
			impl = new MilitaryEncryption();
	}

	public String encryptDoc(String plain, Object key) {
		return impl.encrypt(plain, key);
	}

	public String decryptDoc(String secret, Object key) {
		return impl.decrypt(secret, key);
	}

}
