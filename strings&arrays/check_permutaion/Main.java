import java.util.*;

public class Main{
	
	public static boolean checkPermutation(String a, String b){
		boolean ok = true;
		int a_len = a.length();
		int b_len = b.length();
	
			if (a_len != b_len){
				return false;
			}
		
			for (int i=0; i < a_len; i++){
				if (!b.contains(String.valueOf(a.charAt(i))) &&
					!a.contains(String.valueOf(b.charAt(i))) 
					){
					ok = false;
					break;	
				}
			}

		return ok;		
	}

	public static void main(String[] args){
		String a = "abcdefg";
		String d = "abcdqfg";
		String b = "gfabcde";
		String c = "abcdefgrrre";

	
		System.out.println(Main.checkPermutation(a,c));
		System.out.println(Main.checkPermutation(a,d));
	}

}
