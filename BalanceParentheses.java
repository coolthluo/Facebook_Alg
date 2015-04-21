

public class BalanceParentheses {

	
	public String balance(String s) {
		//use stack to store the position information of parentheses
		//at last , if the stack is not empty, 
		//that's mean these parentheses need to delete from tht orginial string
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(s);
		
		for (int i=0; i< s.length(); i++) {
			int c = s.charAt(i);
			//when the stack is empty and c equals '(', stack push the index of String
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalanceParentheses test = new BalanceParentheses();
		String str = "()()((())";
//		System.out.println(test.balanceParentheses(str));
		System.out.println(test.balance(str));
	}

}
