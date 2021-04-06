package humbaba.cipher.driver;

import humbaba.cipher.CaesarCipher;
import humbaba.cipher.HumbabaCipher;

public class CaesarCipherDriver {
	
	public static void main(String[] args) {
		
		HumbabaCipher cipher = new CaesarCipher();
		
		char[] cipherText = cipher.encrypt("Secret message");
		System.out.println(cipherText);
		char[] plainText = cipher.decrypt(cipherText);
		System.out.println(plainText);
		
		cipher = new CaesarCipher(94, false);
		cipherText = cipher.encrypt("Secret message");
		System.out.println(cipherText);
		plainText = cipher.decrypt(cipherText);
		System.out.println(plainText);
		
//		for(char i = 50000; i < 57000; i++) {
//			System.out.println((int)i + ". " + i);
//		}
		
	}
	
}
