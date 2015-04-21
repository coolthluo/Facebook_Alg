package com.alg1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ShortestSnippet {
	Stack<String> stack = new Stack<String>();
	public String findShortestSnippet (String document, String query) {
		if (document == null || document.length() == 0) {
			return "false";
			
		}
		
		if (query == null || query.length() == 0 ||query.length() > document.length()) {
			return "false";
		}
		int minLen = Integer.MAX_VALUE;
		int index = 0;
		int j;
		int start = 0;
		String shortestStr = null;
		for (int i = 0; i < document.length() - query.length() + 1; i++) {
			j = i;
			for (int k = 0; k < query.length(); k++) {
				while (j < document.length()) {
					if (document.charAt(j) == query.charAt(k)) {
						j++;
						k++;
						if (k == query.length()) {
							if (j - i < minLen) {
								minLen = j - i;
								start = i;
							}
							break;
						}
					} else {
						j++;
					}
				}
				
			}
		}
		shortestStr = document.substring(start, start + minLen);
		return shortestStr;
	}
	
//	public String findShortestSnippetWithoutOrder(String document, String query) {
//		if (document == null || document.length() == 0) {
//			System.out.println("false");
//			return null;
//			
//		}
//		
//		if (query == null || query.length() == 0 ||query.length() > document.length()) {
//			System.out.println("false");
//			return null;
//		}
//		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
//		char[] queryArr = query.toCharArray();
//		for (char c : queryArr) {
//			if (!hs.containsKey(c)) {
//				hs.put(c,1);
//			} else {
//				hs.put(c, hs.get(c) + 1);
//			}
//		}
//		int minLen = Integer.MAX_VALUE;
//		for (int i = 0; i < document.length() - query.length() + 1; i++) {
//			
//		}
//	}
	public int lengthOfLongestSubstring(String s) {
        if ( s.length() == 0 || s == null) {
            return 0;
        }
        if (s.length() == 1) {
        	return 1;
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    if (j - i > maxLen) {
                        maxLen = j - i;
                    }
                } else {
                    break;
                }
            }
        }
        return maxLen + 1;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestSnippet test = new ShortestSnippet();
		String str1 = "ABCCCCCFFF";
//		String str2 = "B";
//		System.out.println(test.findShortestSnippet(str1, str2));
		System.out.println(test.lengthOfLongestSubstring(str1));
	}

}


