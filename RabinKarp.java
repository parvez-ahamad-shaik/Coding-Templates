/*
  Author: Parvez Ahamad Shaik
*/
public class Solution {

	public int solve(String pattern, String text) {
		int count = 0;
		int modulo = (int) 1e9 + 7;
		int n = pattern.length();
		int patternHash = hashValue(pattern);
		int textHash = hashValue(text);

		if (patternHash == textHash)
			count++;
		int maxPow = 1;

		for (int i = 1; i < n; i++) {
			maxPow = (maxPow<< 1) % modulo;
		}
    
    //cyclic permutations
		String concat = text + text.substring(0, n - 1);

		for (int i = 1; i < n; i++) {
			int element = concat.charAt(i - 1) - '0';
			int diff = (element * maxPow) % modulo;
			int newElement = concat.charAt(i + n - 1) - '0';
			textHash = (textHash - diff + modulo) % modulo;
			textHash = (textHash<< 1) % modulo;
			textHash = (textHash + newElement) % modulo;

			if (textHash == patternHash) {
				count++;
			}
		}

		return count;
	}

	private int hashValue(String text) {
		int len = text.length();
		int pow = 1;
		int modulo = (int) 1e9 + 7;
		int hashValue = 0;

		for (int i = len - 1; i >= 0; i--) {
			int element = text.charAt(i) - '0';
			hashValue = (hashValue + (element * pow) % modulo) % modulo;
			pow = (pow * 2) % modulo;
		}

		return hashValue;
	}

}
