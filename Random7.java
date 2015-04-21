/*
	Random5 to Random7
*/

public class Solution {
	//Soultion1
	public int Random7() {
		int i ;
		do {
			i = 5 * (Random5() - 1) + Random5(); 
		}
		return i % 7 + 1;
	}

	public int Random5() {

	}
	//Solution2
	public int Random7() {
		int[][] val = {
	        { 1, 2, 3, 4, 5 },
	        { 6, 7, 1, 2, 3 },
	        { 4, 5, 6, 7, 1 },
	        { 2, 3, 4, 5, 6 },
	        { 7, 0, 0, 0, 0 }
    	};

    	int result = 0;
    	while (result == 0) {
    		int i = Random5();
    		int j = Random5();
    		result = vals[i - 1][j - 1];
    	}
    	return result;
	}
	//Solution3
	public int rand7() {
        while (true) {
        	int rand = 5 * (rand5() -1) ;
            rand = rand + rand5() -1;
            if (rand < 22 && ran > 0) {
            	return rand%7 + 1 ;
            }
         }
	}
}