import java.util.*;

public class Sol{

	private int multiply(int a, int b, int operations){
		if ((a == 0) ||
			(b ==0)){
			System.out.println("Operations performed = " + operations);
			return 0;
		}

		//there are less additions if a is the smaller value
		if (b < a){
			int temp = a;
			a = b;
			b = temp;
		}

		return multiply(a-1, b, operations + 1) + b;
	}

	public int multiply(int a, int b){
		return multiply(a, b, 0);
	}

	public int multiply2(int a, int b){
		int initialB = b;
		int powerRank = 0;
		int result = 0;

		while (a != 0){
			if ((a & 1) != 0){
				result += (b << powerRank);
			}

			a = a >> 1;
			powerRank++;
		}

		return result;
	}

	private int multiplyRecursive(int a, int b, int result, int powerRank){
		if ((a == 0) || (b == 0)){
			return result;
		}

		int newResult = result;

		if ((a & 1) !=0){
			newResult += (b << powerRank);
		}

		return  multiplyRecursive(a >> 1, b, newResult , powerRank + 1);
	}

	public static void main(String[] args){
		Sol s = new Sol();

		// int result = s.multiply(5, 3, 0);
		// int result = s.multiply2(5, 3);
		// int result = s.multiply2(7, 3);
		int result = s.multiply2(137, 215);
		System.out.println("Result = " + result);
	}

}

