package round2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class strstrPermutation {
	/*
		input "hello"  ell true, lle true, llo wrong
	*/
	// nklogk, k is the length of P, n is the length of S
	public boolean findPermutation (String S, String P) {
		if (S.length() < P.length() || S == null) {
			return false;
		}
		if (P == null){
			return true;
		}
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < S.length() - P.length() + 1; i++) {
			char[] charArr = S.substring(i, i + P.length()).toCharArray();
			Arrays.sort(charArr);
			String sortedStr = new String(charArr);
			if (!set.contains(sortedStr)) {
				set.add(sortedStr);
			}
		}
		
		char[] tempArr = P.toCharArray();
		Arrays.sort(tempArr);
		String p = new String(tempArr);
		if (set.contains(p)) {
			System.out.println("found the str, which is :" + p);
			return true;
		} else {
			System.out.print("can't find the str!");
			return false;
		}
	}
	
	//
	public boolean findPermutation2 (String S, String P) {
		if (S == null || S.length() < P.length()) {
			return false;
		}
		//use hashmap to store all the characte's amount of String P
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < P.length(); i++) {
			if (!dict.containsKey(P.charAt(i))) {
				dict.put(P.charAt(i), 1);
			} else {
				dict.put(P.charAt(i), dict.get(P.charAt(i)) + 1);
			}
		}
		int count = 0; 
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>(dict);
		for (int i = 0; i < S.length(); i++) {
			if (hm.containsKey(S.charAt(i))) {
				hm.put(S.charAt(i), hm.get(S.charAt(i)) - 1);
				if (hm.get(S.charAt(i)) >= 0) {
					count++;
				}
				if (count == P.length()) {
					System.out.println("find the number!");
					return true;
				}
			} else {
				count = 0;
				hm = new HashMap<Character, Integer>(dict);
			}
		}
		System.out.println("Can't find!");
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strstrPermutation test = new strstrPermutation();
		String S = "hello";
		String P = "oll";
		test.findPermutation2(S, P);
	}

}
