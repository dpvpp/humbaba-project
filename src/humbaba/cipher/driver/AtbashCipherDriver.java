package humbaba.cipher.driver;

import humbaba.cipher.AtbashCipher;
import humbaba.cipher.HumbabaCipher;

public class AtbashCipherDriver {
	
	public static void main(String[] args) {
		
		HumbabaCipher cipher = new AtbashCipher();
		
		char[] cipherText = cipher.encrypt("Secret message");
		System.out.println(cipherText);
		char[] plainText = cipher.decrypt(cipherText);
		System.out.println(plainText);
		
		for(char i = 0; i < Character.MAX_VALUE; i++) {
			System.out.print(i);
		}
	}

}
