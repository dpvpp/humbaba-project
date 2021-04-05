package humbaba.cipher;

public class CaesarCipher implements HumbabaCipher {

	private int shift;
	private boolean lettersOnly;
	private boolean ignoreCase;
	
	//Original Caesar Cipher was shifted by 3
	public CaesarCipher() {
		this.shift = 3;
		this.lettersOnly = true;
		this.ignoreCase = true;
	}
	
	public CaesarCipher(long shift) {
		
		shift = limitShift(shift, 25);
		
		this.shift = (int)shift;
		this.lettersOnly = true;
		this.ignoreCase = true;
	}
	
	public CaesarCipher(long shift, boolean lettersOnly) {
		
		int max = Character.MAX_VALUE;
		
		if(lettersOnly) {
			max = 25;
		}
		
		shift = limitShift(shift, max);
		
		this.shift = (int)shift;
		this.lettersOnly = lettersOnly;
		this.ignoreCase = true;
	}
	
	private static long limitShift(long shift, int max) {
		
		if(shift < -max || shift > max) {
			shift %= (max + 1);
		} 
		
		if(shift < 0) {
			shift += (max + 1);
		}
		
		return shift;
		
	}
	
	private static char performShift(char c, int shift, char lowerLim, char upperLim) {
		
		c += shift;
		if(c > upperLim) {
			c -= (upperLim - lowerLim + 1);
		} else if (c < lowerLim) {
			c += (upperLim - lowerLim + 1);
		}
		
		return c;
		
	}
	
	private char[] performCaesar(char[] text, int adjustedShift) {
		
		for(int i = 0; i < text.length; i++) {
			
			if(this.lettersOnly) {
				
				if(text[i] >= 'a' && text[i] <= 'z') {
					
					text[i] = performShift(text[i], adjustedShift, 'a', 'z');
					
					if(this.ignoreCase) {
						text[i] -= 32;
					}
					
				} else if (text[i] >= 'A' && text[i] <= 'Z') {
					
					text[i] = performShift(text[i], adjustedShift, 'A', 'Z');
					
				} else if (text[i] != ' ') {
					
					throw new RuntimeException("Input is not letters only");
					
				}
				
			} else {
				
				text[i] = performShift(text[i], adjustedShift, Character.MIN_VALUE, Character.MAX_VALUE);
				
			}
			
		}

		return text;
	}
	
	@Override
	public char[] encrypt(char[] text) {
		int adjustedShift = this.shift;
		return performCaesar(text, adjustedShift);
	}

	@Override
	public char[] encrypt(String text) {
		char[] charText = text.toCharArray();
		return encrypt(charText);
	}

	@Override
	public char[] decrypt(char[] text) {
		int adjustedShift = this.shift * -1;
		return performCaesar(text, adjustedShift);
	}

	@Override
	public char[] decrypt(String text) {
		char[] charText = text.toCharArray();
		return decrypt(charText);
	}

}
