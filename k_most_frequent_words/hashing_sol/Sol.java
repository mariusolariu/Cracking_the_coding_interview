import java.util.HashMap;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Map;
import java.util.Arrays;
// import Pair;

public class Sol{

	private static class FrequencyComparator implements Comparator<Pair>{
			@Override
			public int compare(Pair first, Pair second){
				//ascending order
				return first.frequency - second.frequency;
			}	

	}
	public static void printTopKFreqWords(String text, int k){
		String words[] = text.split(" ");
		HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
		FrequencyComparator frequencyComparator = new FrequencyComparator();	
		PriorityQueue<Pair> pq = new PriorityQueue<>(k,	frequencyComparator); 

		//fill in pq with dummy data;
		for (int i=0; i<k; i++){
			pq.add(new Pair("", 0));
		}

		Integer val;
		for (String w : words){
			if ( (val = freqMap.get(w)) != null){
				freqMap.put(w, Integer.valueOf(val + 1));
			}else{
				freqMap.put(w, new Integer(1));
			}
		}

		for (Map.Entry<String, Integer> e : freqMap.entrySet()){
			Pair head = pq.peek();

			if (head.frequency < e.getValue()){
				pq.poll();
				pq.add(new Pair(e.getKey(), e.getValue()));
			}
		}

		System.out.println("Top " + k + " most frequent words are:");

		for (Pair p : pq){
			System.out.println( p.word + " " + p.frequency);
		}


		System.out.println("\nTop " + k + " most frequent words in ascending order are:");

		// toArray(T[] a) returns an array of type T
		// toArray() returns an array of Objects[] which cannot be downgraded to array of Pair
		Pair[] arr =  pq.toArray(new Pair[5]);

		//the following thing is possible but not the other way arround (from Object to Pair)
		// Object[] arr2 = (Object[]) arr;

		Arrays.sort(arr, frequencyComparator); 

		for (Object p : arr){
			System.out.println(p);
		}

	}

	public static String readText(String fileName){
		StringBuilder textB = new StringBuilder("");

			try{
				FileReader fileReader = new FileReader(fileName);
				BufferedReader reader = new BufferedReader(fileReader);

				String line;

				while ((line = reader.readLine()) != null){
					textB.append(line);
				}
			
			reader.close();
			fileReader.close();
			}catch (IOException e){
				System.out.println(e.getMessage());
			}

		return textB.toString();
	}

	public static void main(String[] args){
		String bookText = readText("./aBook.txt");
		printTopKFreqWords(bookText, 5);
	}

}
