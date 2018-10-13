// --- BLOOMBERG PHONE INTERVIEW ---
//write an program that prints all the permutations of a given string
// the alphabet has the following charaters: "1", "0"
//the string can contain wildcards, e.g: "1?1
import java.util.*;

public class Main{
	private static HashSet<String> permSet = new HashSet<>();
	private static char[] alphabet = new char[]{'0','1'};

	private static void helper(StringBuffer[] permArr,char c){

		int currentPermLen = permArr[0].length();

		for (int i = 0; i < permArr.length; i++){
			
		
			for (int j = 0; j <= currentPermLen; j++){
				permArr[i].insert(j, c);
                String t = new String( permArr[i].toString() );
				permSet.add(t);

				//bring to initial form so we can insert in all places 'c'

				permArr[i].deleteCharAt(j);
			}
		}
		

	}


	public static void permutations(String s, int index){
		int len = s.length();

		if (index == len){
			return;
		}

		if (index == 0){
			permSet.add(String.valueOf(s.charAt(index)));
			permutations(s, index + 1);
			
			//when comes back from recursion there are still some instructions
			//to be executed
			return;
		}

		Object[] buffer = permSet.toArray();
		StringBuffer[] permArr = new StringBuffer[buffer.length];
		char c = s.charAt(index);

		//create an array of StringBuffers
		for (int i=0; i < buffer.length; i++){
			permArr[i] = new StringBuffer( (String) buffer[i]);
		}

		permSet.clear();

		if (c == '?'){
			for (int i = 0; i < alphabet.length; i++){
				helper(permArr, alphabet[i]);
			}
		}else{
			helper(permArr, c);
		}

		permutations(s, index + 1);
		
	}

/*
	public static void permutations(String s, int index){
		int len = s.length();

		if (index == len){
			return;
		}

		char c = s.charAt(index);
		StringBuffer rest = new StringBuffer(s);
		
		rest.deleteCharAt(index);

		for (int i=0; i < len ; i++){
			rest.insert(i, c);


//			System.out.println(rest);
			permSet.add(rest.toString());


			//remove the just inserted character in order to create another permutation

			rest.deleteCharAt(i);
		} 

       permutations(s, index + 1);
	}
*/	
	
	public static void main(String[] args){
		String test="1234";
		String test1="1?1";

		Main.permutations(test1, 0);
		
		for (String s : permSet){
			System.out.println(s);
		}
	
	}	

}
