import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int queriesNumber = s.nextInt();
		int value, operation;

		for (int i = 0; i < queriesNumber; i++){
			operation = s.nextInt();

			switch (operation){
				case 1:
					//insert
					value = s.nextInt();
					//insertion - O(log n)
					pq.add(Integer.valueOf(value));
				 break;

				case 2:
					value = s.nextInt();
					//deletion - O(log n)
					pq.remove(Integer.valueOf(value));
				 break;

				 case 3:
				 	System.out.println(pq.poll());
				 break;

				 default:
				 	System.out.println("Unidentified operation");
			}
		}


		s.close();
    }
}


