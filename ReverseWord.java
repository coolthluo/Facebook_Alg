package com.alg1;

public class ReverseWord {
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		// i is the every single word start position
		// when j meet ' ', means a single word already found ,so need to
		// reverse i to j,
		// and j + 1 is the next single word's position, so assign to i
		for (int i = 0, j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
			if (j == s.length - 1) {
				reverse(s, i, j);
			}
		}
	}

	public void reverse(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
	}

	// private void reverse(char [] s, int begin, int end) {
	// for (int i=0; i<(end-begin)/2; i++) {
	// char temp = s[begin+i];
	// s[begin+i] = s[end-i-1];
	// s[end-i-1] = temp;
	// }
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWord test = new ReverseWord();
		String s = "I am a student";
		char[] sArr = s.toCharArray();
		test.reverseWords(sArr);
		String res = new String(sArr);
		System.out.println(res);
	}

}
