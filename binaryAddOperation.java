package com.alg1;

public class binaryAddOperation {

	//Solution1
	public String binaryAdd(String str1, String str2, int carry) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		
//		char[] A = str1.toCharArray();
//		char[] B = str2.toCharArray();
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

	//Solution2 My self
    public String addBinary(String a, String b) {
    	if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
        //add the number from the end to start
        int i = a.length() - 1;
        int j = b.length() - 1;
        //use carry to store the sum of two string
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            res.insert(0, carry % 2);
            carry = carry / 2;
        }
        if (carry == 1) {
            res.insert(0, "1");
        }
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stua
		binaryAddOperation test = new binaryAddOperation();
		String str1 = "2";
		String str2 = "10001";
		String res = test.binaryAdd(str1, str2, 10);
		System.out.println(res);
	}

}
