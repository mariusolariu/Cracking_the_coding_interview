// --- BLOOMBERG PHONE INTERVIEW ---
//write an program that prints all the permutations of a given string
// the alphabet has the following charaters: "1", "0"
//the string can contain wildcards, e.g: "1?1
import java.util.*;

public class Main{

	public static void permutations(String s, int index){
		int len = s.length();

		if (index == len){
			return;
		}

		char c = s.charAt(index);
		StringBuffer rest = new StringBuffer(s);
		
		rest.deleteCharAt(index);

		for (int i=0; i < len - 1; i++){
			rest.insert(i, c);


			System.out.println(rest);


			//remove the just inserted character in order to create another permutation

			rest.deleteCharAt(index);
		} 

       permutations(s, index + 1);
	}
	
	
	public static void main(String[] args){
		String test="abc";

		Main.permutations(test, 0);
	}	

}
