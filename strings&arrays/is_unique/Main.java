import java.util.*;

public class Main{

/*
public static boolean checkUniqChars(String s){
	HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
	boolean result = true;

	int length = s.length();
	for (int i=0; i<length; i++){
		Character c = Character.valueOf(s.charAt(i));	

		if (alphabet.get(c) == null){
			alphabet.put(c,1);
		}else {
			result = false;
			break;
		}

	}

	return result;
}
*/

public static boolean checkUniqChars(String s){
	boolean result = true;
	int i;
	int length = s.length();

	//optimization
	//you can't have a string of unique chars bigger than the available chars in encoding
	if (length > 256){
		result false;
	}else{
		for (i=0; i<length-1; i++){
			for (int j=i+1; j<length; j++){
				if (s.charAt(i) == s.charAt(j)){
					result = false;
					break;
				}
			}
		
			if (result == false){
				break;
			}
	}

	}

	System.out.println("i="+ i);

	return result;
}

public static void main(String[] args){
		String test="abcdef";
		String test1="abbdef";
		
    	System.out.println(checkUniqChars(test1));
	}

}
