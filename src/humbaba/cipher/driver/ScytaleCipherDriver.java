package humbaba.cipher.driver;

import humbaba.cipher.HumbabaCipher;
import humbaba.cipher.ScytaleCipher;

public class ScytaleCipherDriver {
	
	public static void main(String[] args) {
		
		HumbabaCipher cipher = new ScytaleCipher();
		
		char[] cipherText = cipher.encrypt("Make sure your message is not too short");
		System.out.println(cipherText);
		char[] plainText = cipher.decrypt(cipherText);
		System.out.println(plainText);
		
	}
	
}
