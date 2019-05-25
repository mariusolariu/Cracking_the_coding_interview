import java.util.*;

public class Sol{

	public static int insert(int m, int n, int i, int j){
		StringBuilder mBits = new StringBuilder("");

		while (m != 0){
			if (BitManager.getBit(m, 0)){
					mBits.append("1");
			}else{
					mBits.append("0");
			}

			m = m >>> 1;
		}

		String mBitRep = mBits.reverse().toString();

		for (int k = 0; k < mBitRep.length(); k++){
			
			if (mBitRep.charAt(k) == '1'){
				n = BitManager.updateBit(n, j--, true);			
			}else{
				n = BitManager.updateBit(n, j--, false);			
			}
		}

		return n;
	}

	public static void main(String[] args){
		/*
				int val = -1;
				BitManager.printBitRep(val);

				val = -75;
				BitManager.printBitRep(val);

				val = 75;
				BitManager.printBitRep(val);

				val = 0;
				BitManager.printBitRep(val);

				val = 5; 
				BitManager.printBitRep(val);

				val = (int)Math.pow(2,31);  // 2^31 cannot be repesented on an int so the biggest value lower than it is returned (ending in 7) 
				BitManager.printBitRep(val);

		*/

//		int m = 1024;
//		int n = 19;

		int m = 948;
		int n = 0;
		int result = insert(n, m , 0, 11);

		BitManager.printBitRep(result);
	}

}

