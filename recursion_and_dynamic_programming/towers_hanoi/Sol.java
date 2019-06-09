import java.util.Stack;
import java.util.Arrays;

public class Sol{
	private int movesCount;

	private void moveTop(Stack<Integer> source, Stack<Integer> destination){
		Integer element = source.pop();
		destination.push(element);
		movesCount++;
	}
	
	public void moveDisks(int n, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination){
		if (n == 0) return;

			//move the first n-1 elements to buffer
			moveDisks(n-1, source, destination, buffer);

			moveTop(source, destination);

			//move the n-1 elements from buffer to destination
			moveDisks(n - 1, buffer, source, destination); 
	}

	public static void main(String[] args){
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();

		source.push(Integer.valueOf(6));
		source.push(Integer.valueOf(5));
		source.push(Integer.valueOf(4));
		source.push(Integer.valueOf(3));
		source.push(Integer.valueOf(2));
		source.push(Integer.valueOf(1));
		
		System.out.println(source + "\n");
		Sol s = new Sol();
		s.moveDisks(6, source, buffer, destination);

		System.out.println("Moves count: " + s.movesCount);
		System.out.println("Output: \n" +source);
		System.out.println(destination);
	}

}

