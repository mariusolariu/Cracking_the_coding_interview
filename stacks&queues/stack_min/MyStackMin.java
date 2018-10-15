import java.util.*;

public class MyStackMin{
	private MyStackMinNode head;
	private MyStackMinNode min;
	
	private static class MyStackMinNode{
		private int data;
		private MyStackMinNode next;
		private MyStackMinNode theSNB; //the smallest node bigger than this one
										// Note: only the nodes that have became once a min node need to have a SNB ( so that when they are removed from queue, the queue can say which element is next min)
										// last min has as SNB the head of the list
		public MyStackMinNode(int data){
			this.data = data;
		}

		//Obs : You must override hashCode() in every class that overrides equals(). Failure to do so will result in a violation of the general contract for Object.hashCode(), which will prevent your class from functioning properly in conjunction with all hash-based collections, including HashMap, HashSet, and Hashtable. "Effective Java" Joshua Bloch
		@Override
		public int hashCode(){
			return Objects.hash(data, next);
		}

		@Override
		public boolean equals(Object o){
			if (!(o instanceof MyStackMinNode)) return false;

			if (this == o) return true;

			return ( (this.data == ((MyStackMinNode) o).data) &&  (this.next == ((MyStackMinNode) o).next) );
		}

	}

	private int size;

	public MyStackMin(){};

	public void push(int data){
		MyStackMinNode node = new MyStackMinNode(data);

		if (head == null){
			head = node;
			min  = node;
		}else{
			node.next = head;
			head = node;

			if (node.data < min.data){
				node.theSNB = min;
				min = node;
			}
		}

		size++;

	} 


	public int pop() throws MyStackEmpty{
 		if (head == null) throw new MyStackEmpty("The stack is empty!");

		int data = head.data;

		if (head.equals(min)){ //the min needs to get updated
			min = min.theSNB;
		}

		head = head.next;

		return data;

	}


	public int peek() throws MyStackEmpty{
 		if (head == null) throw new MyStackEmpty("The stack is empty!");

		return head.data;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public int min() throws MyStackEmpty{
 		if (head == null) throw new MyStackEmpty("The stack is empty!");

		return min.data;
	}

		
	public static void main(String[] args){
		MyStackMin stack = new MyStackMin();

		stack.push(5);
		stack.push(4);
		stack.push(6);
		stack.push(1);
		stack.push(10);
		stack.push(-1);
	
		Scanner s = new Scanner(System.in);
		System.out.println("opt = ");
		int opt = s.nextInt();

		do{

			switch (opt){
				case 1:
						try{
							stack.pop();
						}catch (MyStackEmpty e){
							System.out.println("Can't pop from an empty stack");
						}
					break;

				case 2:
					try{
						int min = stack.min();
						System.out.println("Current min = " + min);
					}catch(MyStackEmpty e){
						System.out.println("Can't get the min from an empty stack");
					}

					break;

				case -1:
					System.out.println("Exit");
					break;
				default:
					System.out.println("No valid option");
			}

			System.out.println("opt = ");
			opt = s.nextInt();
		

		}while (opt != -1);

	}


}

