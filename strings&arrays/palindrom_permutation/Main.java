import java.util.*;

public class Main{


	public static boolean isPalindromePermutation(String s){
		StringBuilder temp = new StringBuilder("");

		int len = s.length();
	
		//remove whitespaces
		for (int i=0; i<len; i++){
			if (s.charAt(i) == ' ') continue;

			temp.append(s.charAt(i));
		}

		String temp1 = temp.toString().toUpperCase();
        int[]  char_freq = new int[26];

		len = temp1.length();

		//char frequency array
		int[] f_arr = new int[26];

		//if the count of characters that are odd is even then we can't form a palindrom
		//e.g 3e 1t 2a
		int sum_odd_chars = 0;

		//assumption that we are working with ASCII chars
		for (int i=0; i<len; i++){
			f_arr[temp1.charAt(i) - 65]++;
		}

		for (int i=0; i<26; i++){
			if (f_arr[i] % 2 == 1) sum_odd_chars++;
		}

		//if two or more distinct chars have an odd frequency of appearances then we can't form a palindrome
		if (sum_odd_chars >= 2) return false;


		return true;		
	}

	public static void main(String[] args){
		String test = "tttru";
		String test1 = "Tact Coa";

		System.out.println(isPalindromePermutation(test1));

	}

}
