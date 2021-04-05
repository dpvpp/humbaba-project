package humbaba.ciper;

public interface HumabaCipher {
	
	public char[] encrypt(char[] text);
	public char[] encrypt(String text);
	
	public char[] decrypt(char[] text);
	public char[] decrypt(String text);
	
}
