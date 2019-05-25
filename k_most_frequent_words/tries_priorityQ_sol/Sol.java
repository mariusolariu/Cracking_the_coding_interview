import java.util.*;
import tries.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Sol{

	public void printKMostFreqWords(String text, int k){
		String[] arr = text.split(" ");
		Trie trie = new Trie(); 
		
		//k == initial capacity
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){

		@Override
		public int compare(Pair first, Pair second){
			return first.frequency - second.frequency;
		}

		});

		for (int i = 0; i < k; i++){
			pq.add(new Pair("",0));
		}

		for (String word : arr){
			TrieNode finalNode = trie.addWord(word);	

			int wordFrequency = finalNode.getWordFrequency();
			// System.out.println(word + " : " + wordFrequency);
			// Pair head = pq.peek();
//
			// if (head.frequency < wordFrequency){
			// 	Pair p = new Pair(word, wordFrequency);
			// 	if (pq.contains(p)){
			// 		p.frequency++;
			// 	}else{
			// 		pq.poll();
			// 		pq.add(p);
			// 	}
			// }

		}

		//TODO: add the words to a priority queue and display them. Not really more efficient than the previous solution

		for (Pair p : pq){
			System.out.println(p);
		}


		trie.printGraph();
	}

	public static String readBook(String path){
		StringBuilder builder = new StringBuilder();
		
		try (FileReader fileR = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileR)){
			
			String line = null;

			while ((line = reader.readLine()) != null){
				builder.append(line).append("\n");
			}

		}catch (IOException e){
			e.printStackTrace();
		}

		return builder.toString();
	}

	public static void main(String[] args){
		// String aBook = readBook("./aBook.txt");
		
		Sol s = new Sol();
		// new Sol().printKMostFreqWords("a simple test simple simple",3);
		s.printKMostFreqWords("simple a simple test simple test",3);

		
	}

}

