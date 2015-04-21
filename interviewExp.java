FB intern 4.1
	1.Find shortest snippet，比如给一个Document是A,X,X,B,A,X,B，Query是A,B，要求返回shortestSnippet
		第一问：		 如果Query有序（即A一定要在B前面），那么要返回A,X,B
		Follow up1： 如果Query无序（即B在A前面也可以），那么要返回B,A
		Follow up2： 如果Document非常大，如何再优化？

		问题解释：
			比如输入是 this is one of the best forum best one!
			query  "one"  "best" => one of the best
			如果不是care order  输出 => best one?

		Tags: HashTable, Two pointers
		Similarity: Longest Substring Without Repeating Characters,
					Substring with Concatenation of All Words，
					Minimum Window Substring,

	//1.Brute force O(n*n*m)
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
			// j mean the end position of substring(i, j)
			j = i;
			// k mean the position we are comparing of the query
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

	//2. Binary add operation 
	public class binaryAddOperation {
	public String binaryAdd(String str1, String str2, int carry) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		int i = str1.length() - 1;
		int j = str2.length() - 1;
		
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				flag += str1.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				flag += str2.charAt(j) - '0';
				j--;
			}
			sb.insert(0, flag % carry);
			flag = flag / carry;
			
		}
		String sum = sb.toString();
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stua
		binaryAddOperation test = new binaryAddOperation();
		String str1 = "111";
		String str2 = "10001";
		String res = test.binaryAdd(str1, str2, 2);
		System.out.println(res);
	}

	//3 String with Balanced Parentheses
	public String balance(String s) {
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(s);
		
		for (int i=0; i< s.length(); i++) {
			int c = s.charAt(i);
			if (stack.isEmpty() || c == '(') {
				stack.push(i);
			} else {
				int top = stack.peek();
				if (s.charAt(top) == ')') {
					stack.push(i);
				} else {
					stack.pop();
				}
			}
		}
		
		while (!stack.isEmpty()) {
			sb.deleteCharAt(stack.pop());
		}
		
		return sb.toString();
	}

}



