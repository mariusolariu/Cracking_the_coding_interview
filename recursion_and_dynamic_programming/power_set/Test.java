import java.util.*;

public class Test{

	public static void main(String[] args){
		HashSet<HashSet<Character>> setOfSets = new HashSet<HashSet<Character>>();

		HashSet<Character> set = new HashSet<Character>(Arrays.asList('a','b'));
		HashSet<Character> set2 = new HashSet<Character>(Arrays.asList('a','b'));

		setOfSets.add(set);
		setOfSets.add(set);
		setOfSets.add(set2);

		for (HashSet<Character> s : setOfSets){
			for (Character c : s){
				System.out.print(c + " ");
			}

			System.out.println();
		}
	}

}

