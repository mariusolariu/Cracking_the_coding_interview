import java.util.*;

/*print first n fibonacci numbers using recursion*/
public class Sol{
	int[] fibSeq;

	private int seq(int n){
	
		if (n - 1 == 0){
			fibSeq[0] = 0;
			return 0;
		}

		if (n - 1 == 1){
			fibSeq[1] = 1;
			return 1;
		}

		int currInd = n - 1;
		int prevInd = currInd - 1;
		int prevPrevInd = currInd - 2;

		fibSeq[currInd] = seq(prevInd) + seq(prevPrevInd);

		return fibSeq[n - 1];

	}

	public void fibonacci(int n){
		fibSeq = new int[n];

		for (int i=0; i < n; i++){
			fibSeq[i] = -1;
		}

		seq(n);

		System.out.print("The first " + n + " fibonacci numbers: ");
		for (int i=0; i < n; i++){
			System.out.print(fibSeq[i] + ", ");
		}

	}

	public static void main(String[] args){
		Sol s = new Sol();

		s.fibonacci(3);
		s.fibonacci(4);
	//	s.fibonacci(10);
	}

}

