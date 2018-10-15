import java.util.*;

public class SetOfStacks{
	private Stack<Integer> currentStack;
	private static final int THRESHOLD = 10;
	private static final int EMPTY = -1;
	private int top_position = EMPTY;              //no element in stack
	private LinkedList<Stack<Integer>> stacksList;

	//the stack_count takes into account the currentStack as well (which is not in the stacks list);
	private int stacks_count = EMPTY;
	private int elementsCount;

	public SetOfStacks(){
		stacksList = new LinkedList<Stack<Integer>>();
	}

	public void push(Integer data){
		
		//check if the current stakc is full
		if (top_position == THRESHOLD){
			 top_position = -1;
			 stacksList.add(currentStack);
		}


		if (top_position == -1){
			currentStack = new Stack<>();
			stacks_count++;
		}

		top_position++;
		elementsCount++;

		currentStack.push(data);

	}

	public Integer pop() throws MyStackEmpty{
		if (isEmpty()) throw new MyStackEmpty("The set of stacks is empty");

		//always at least 0 if there is at least one stack
		Integer data = currentStack.pop();
		top_position--;
		elementsCount--;

		if (top_position == -1){ 
			if (stacks_count >= 1){
				currentStack = stacksList.get(stacks_count - 1);
				stacksList.remove(stacks_count - 1);
				top_position = THRESHOLD - 1;
			}

			stacks_count--;
		}

		return data; 
	}

	public Integer peek() throws MyStackEmpty {
		if (isEmpty()) throw new MyStackEmpty("The set of stacks is empty");

		return currentStack.peek();	
	}

	public boolean isEmpty(){
		return stacks_count == EMPTY;
	}

	public Integer popAt(int index) throws MyStackEmpty{
		if (isEmpty()) throw new MyStackEmpty("The set of stacks is empty");
		
		int size = stacksList.size();

		if (index > size) {
			System.err.println("The requested stack doesn't exist");
			System.exit(0);
		}

		Integer value = null;
		if (size == index) value = pop();
		else{
			Stack<Integer> requestedStack = stacksList.get(index);
			
			if (requestedStack.size() == 0) throw new MyStackEmpty(" The requested stack : <" + index + "> is empty");

			value = requestedStack.pop();
		}

		return value;
	}


	public static void main(String[] args){

	}

}

