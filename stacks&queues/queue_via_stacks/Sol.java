import java.util.*;

public class Sol{
	private Stack<Integer> s1;  //from this stack the pop will happen
	private Stack<Integer> buffer;  	//adjacent stack to help in ordering the elements in s1 so that we can emulate an queue

	public Sol(){
		s1 = new Stack<>();
		buffer = new Stack<>();
	}

	public void add(Integer el){
		popAllElements(s1, buffer);
		buffer.push(el);
		popAllElements(buffer, s1);
	}

	private void popAllElements(Stack<Integer> source, Stack<Integer> destination){
		int size = source.size();

		for (int i=0; i < size; i++){
			Integer el = source.pop();
			destination.push(el);
		}
	}

	public Integer remove() throws MyQueueEmpty{
		if (isEmpty()) throw new MyQueueEmpty("This queue is empty");

		return s1.pop();
	}

	public Integer peek() throws MyQueueEmpty{
		if (isEmpty()) throw new MyQueueEmpty("This queue is empty");

		return s1.peek();
	}


	public boolean isEmpty(){
		return s1.size() == 0;
	}

	public static void main(String[] args){
		Sol s = new Sol();

		s.add(1);
		s.add(2);
		s.add(3);

		try{
			System.out.println(s.remove());
			System.out.println(s.peek());
		}catch(MyQueueEmpty e){}
	}

}

