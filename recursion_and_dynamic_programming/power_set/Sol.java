import java.util.*;

public class Sol{

	public ArrayList<HashSet<Character>> getPowerSet2(Character[] elements){
		ArrayList<HashSet<Character>> result = new ArrayList<HashSet<Character>>();
		HashSet<Character> previousSet;

			HashSet<Character> emptySet = new HashSet<>();
			result.add(emptySet);

			HashSet<HashSet<Character>> previousSets = new HashSet<HashSet<Character>>();
			previousSets.add(emptySet);
			for (int setSize = 1; setSize <= elements.length; setSize++){
				HashSet<HashSet<Character>> newSets = new HashSet<HashSet<Character>>();

				for (HashSet<Character> s : previousSets) {
					for (int i = 0; i < elements.length; i++){
						HashSet<Character> copy = new HashSet<>(s);
						copy.add(elements[i]);
						if (copy.size() == setSize){
							newSets.add(copy);
						}
					}
				}

				//add the new formed sets
				for (HashSet<Character> s : newSets){
				   result.add(s);
				}
				
				previousSets = newSets;
			}

		return result;
	}

	public  ArrayList<HashSet<Character>> getPowerSet(Character[] elements){
		ArrayList<HashSet<Character>> result = new ArrayList<HashSet<Character>>();

		int totalNoSubsets = (int) Math.pow(2, elements.length);

		for (int i = 0; i < totalNoSubsets; i++){
			HashSet<Character> subset = new HashSet<>();

			int d = i;
			int pos = 0;
			// System.out.println( d  + " " );

				while (d != 0){
					if ((d & 1) != 0){
						subset.add(elements[pos]);
					}
				
					d = d >> 1;
					pos++;
				}

			result.add(subset);
		}

		return result;
	}

	public  void printPowerSet(ArrayList<HashSet<Character>> powerSet){
		int count = 0;

		for (HashSet<Character> set : powerSet){
			System.out.print("\n" + ++count + " {");
			for (Character e : set){
				System.out.print(e + ", ");
			}
			System.out.print("}");
		}

	}

	public static void main(String[] args){
		//the set elements stored in array for convenience
		Character[] elements = new Character[]{'x', 'y', 'z', 'a'};
		Sol s = new Sol();

		ArrayList<HashSet<Character>> result = s.getPowerSet2(elements);

		s.printPowerSet(result);
	}

}

