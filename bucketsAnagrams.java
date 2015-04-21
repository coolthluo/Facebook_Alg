package com.alg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class bucketsAnagrams {
	public static ArrayList<ArrayList<String>> anagrams(String[] strs){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String tempStr = new String(temp);
			
			if (hm.containsKey(tempStr)) {
				if (hm.get(tempStr).size() == 1) {
					hm.get(tempStr).add(s);
				}
			} else {
				ArrayList<String> tempList = new ArrayList<String>();
				tempList.add(s);
				hm.put(tempStr, tempList);
			}
		}	
		res.addAll(hm.values());
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bucketsAnagrams test = new bucketsAnagrams();
		String[] s = {"abc", "bca", "bac", "aaa", "abcd","dcba","cba","a"};
		ArrayList<ArrayList<String>> res = test.anagrams(s);
		for (ArrayList<String> list : res) {
			for (String str : list) {
				System.out.print(" " + str + " ");
			}
			System.out.println("");
		}
	}

}

