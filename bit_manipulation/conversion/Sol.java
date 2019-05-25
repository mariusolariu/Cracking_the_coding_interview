import java.util.*;

public class Sol{

	public static int countBitsToFlip(int a, int b){
		int count = 0;
		
			while ((a != 0) || (b != 0)){
				byte aBit = (byte) ((BitManager.getBit(a, 0)) ? 1 : 0);
				byte bBit = (byte) ((BitManager.getBit(b, 0)) ? 1 : 0);

					if (aBit != bBit) count++;

				a >>>= 1;
				b >>>= 1;
			}

		return count;
	}

	public static void main(String[] args){
		int a = 29;
		int b = 0;

		System.out.println("Number of bits needed to be flipped: " + countBitsToFlip(a, b)); 
	}

}

