import java.util.ArrayList;

 public class Sol{
	 private int operationsCount;

	 private ArrayList<String> getPermutations(String word){
		int textLength = word.length();

		if (textLength == 0) return new ArrayList<String>(); //it should get in this situation only when the word passed initially is empty
		else if (textLength == 1){
			ArrayList<String> oneLetter = new ArrayList<String>();
			oneLetter.add(word);
			return oneLetter;
		}

		ArrayList<String> permutations = getPermutations(word.substring(1,textLength));
		char pivot = word.charAt(0);

		
		ArrayList<String> newPerm = new ArrayList<String>();
		for (String p : permutations){
			
			for (int i = 0; i <= p.length(); i++){
			  String s = p.substring(0, i) + pivot + p.substring(i);
			  operationsCount++;
			  // if (!newPerm.contains(s)){
			  	newPerm.add(s);
			  // }

			}

		}

		return newPerm;
	 }

	 public ArrayList<String> findPermutations(String word){
			operationsCount = 0;
			return getPermutations(word);
	 }

	 public static void main(String[] args){
		 Sol s = new Sol();
		 // String word = "abc";
		 String word = "aaaaaaaaaaaaaaa";

		 ArrayList<String> perm = s.findPermutations(word);

		 System.out.println("Operations count: " + s.operationsCount);
		 System.out.println("Permutations of : " + word);
		
		for (String x : perm){
			System.out.print(x + " ");
		}
	 }
 } 

