package round2;

import java.util.ArrayList;
import java.util.HashSet;

public class FindCombinedPalindrome {
	
	public ArrayList<String> findCombinePalindrome (String[] words) {
		ArrayList<String> res = new ArrayList<String>();
		if (words.length == 0 || words == null) {
			return res;
		}
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < words.length - 1; i++) {
			StringBuilder words1 = new StringBuilder(words[i]);
			for (int j = i + 1; j < words.length; j++) {
				StringBuilder words2 = new StringBuilder(words[j]);
				String tempStr = words1.append(words2).toString();
				if (isPalindrome(tempStr)) {
					if (set.contains(tempStr)) {
						continue; 
					} else {
						res.add(words[i]);
						res.add(words[j]);
						set.add(tempStr);
					}
					
				}
			}
		}
		return res;
		
	}
	
	public boolean isPalindrome(String word) {
		int left = 0;
		int right = word.length() - 1;
		while (left < right) {
			if (word.charAt(left) != word.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindCombinedPalindrome test = new FindCombinedPalindrome();
		String[] strArr = {"cigar", "ragic", "none" ,"enon","abcd", "defg"};
		ArrayList<String> res = test.findCombinePalindrome(strArr);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
