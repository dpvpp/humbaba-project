package humbaba.cipher;

public interface HumbabaCipher {
	
	public char[] encrypt(char[] text);
	public char[] encrypt(String text);
	
	public char[] decrypt(char[] text);
	public char[] decrypt(String text);
	
}
