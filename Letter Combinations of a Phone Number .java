/*
	Letter Combinations of a Phone Number
	Given a digit string, return all possible letter combinations that the number could represent.
	A mapping of digit to letters (just like on the telephone buttons) is given below.

	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.

	Tags: Backtracking， String
*/


/*
    Time Complexity : assume we have n digits, and every digits can representative of k character
                      so is  k^n, k的n次方
*/
public class Solution {

    //Recursive Method
	public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> res = new ArrayList<String>();
    	if (digits == null)
    		return res;
    	String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	StringBuilder item = new StringBuilder();//record every single combination string
    	int index = 0;//record the positon of digits's character position
    	backtracking_helper(digits, index, item, keyboard, res);
    	return res;
    }

    private void backtracking_helper(String digits, int index, StringBuilder item, String[] keyboard, ArrayList<String> res) {
    	if (index == digits.length()) {
    		res.add(item.toString());
    		return ;
    	}

    	int num = digits.charAt(index) - '0';              //取出字符串里的第index位数字,正好数字对应该数字所表示的字符数组的下标，2 == board[2] (a, b, c)
    	for (int i = 0; i < keyboard[num].length(); i++) { //在keyboard字符串数组里，23 的2 就代表在keyboard[2]里的字符
    		item.append(keyboard[num].charAt(i));
    		backtracking_helper(digits, index + 1, item, keyboard, res);
    		item.deleteCharAt(item.length() - 1);
    	}
    }

    //Non-recursive
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits.length() == 0 || digits == null) {
            return res;
        }
        res.add("");
        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //digits.length is the length of every single  combination string
        for (int i = 0; i < digits.length(); i++) {
            //we get the keyboard's string value base on the digits's character
            String letters = keyboard[digits.charAt(i) - '0'];

            //use this newRes to stroe every iteration value;
            ArrayList<String> newRes = new ArrayList<String>();

            //read every string from the res
            for (int j = 0; j < res.size(); j++) {
                //and combine with the letters'e value 
                for (int k = 0; k < letters.length(); k++) {
                    newRes.add(res.get(j) + Character.toString(letters.charAt(k)));
                }
            }
            res = newRes;
        }
        return res;
    }


}







