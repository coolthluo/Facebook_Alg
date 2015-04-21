package com.alg1;

public class LongestPalindrome {
//	public String longestPalindrome(String s) {
//        String res = "";
//        if (s == null || s.length() == 0) {
//            return res;
//        }
//        int maxLen = 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            for (int j = s.length() - 1; j > i; j--) {
//                int left = i;
//                int right = j;
//                if (s.charAt(left) != s.charAt(right)) {
//                    continue;
//                }
//                while (left < right && s.charAt(left) == s.charAt(right)) {
//                    if (left + 1 == right) {
//                        if (j - i + 1 > maxLen) {
//                        	maxLen = j - 1 + 1;
//                            res = s.substring(i, j + 1);
//                        }
////                        break;
//                    }           
//                    left++;
//                    right--;
//                    if (left > s.length() - 1 || right < 0) {
//                    	break;
//                    }
//                }
//            }
//        }
//        return res;
//    }
	public String longestPalindrome(String s) {
        int maxLen = 0;
        String res = null;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int curLen = j - i;
                String cur = s.substring(i, j + 1);
                if (isPalindromic(cur)){
                	if (curLen > maxLen) {
                		maxLen = Math.max(maxLen, curLen);
                        res = cur;
                	}
                }
            }
        }
        return res;
    }
	
	public boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome test = new LongestPalindrome();
		String str = "abbaaaaabbaaaacc";
		System.out.println(test.longestPalindrome(str));
	}

}
