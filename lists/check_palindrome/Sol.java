import java.util.*;

public class Sol{

	public static boolean checkPalindrome(LinkedList<Character> l){
		boolean result = true;
		int[] freqArray = new int[26];
		LinkedList<Character> reversedList = new LinkedList<>();

		//optimization : if you have 2 or more letters that have an odd frequency then
		//				 you can't form a palindrome => don't do unnecesary work
		int oddFreq = 0;

	
		int size = l.size();
		Iterator<Character> iter = l.iterator();	

			//a lowercase or uppercase letter is considered to be equivalent
			while (iter.hasNext()){
				char c = Character.toUpperCase( (char) iter.next());
				
				int index = (int) c - 65;
				//Ascii encoding
				freqArray[index]++;

				if (freqArray[index] % 2 == 1) oddFreq++;
				else oddFreq--;

				reversedList.addFirst(c);
			}

			
			
			if (oddFreq >= 2){ //can't be a palindrome if true
					System.out.println("2 or more letters with odd character frequency");
				return false;
			}

		Iterator<Character> original = l.iterator();
		Iterator<Character> reversed = reversedList.iterator();


		int upperLimit = size / 2;
		
			for (int j = 0; j < upperLimit; j++){
				Character c_orig =  Character.toUpperCase((char)original.next());
				Character c_rev = reversed.next();

				if (!c_orig.equals(c_rev)){
					result = false;
					break;
				}
			}	

		return result;
	}

	public static void main(String[] args){
		//LinkedList<Character> l1 = new LinkedList<>(Arrays.asList('a', 'n', 'a', 'n', 'a'));
		// LinkedList<Character> l2 = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'c', 'b', 'a'));
		//  LinkedList<Character> l3 = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'c', 'c', 'a'));
		  LinkedList<Character> l4 = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));

		System.out.println(checkPalindrome(l4));
	}

}

