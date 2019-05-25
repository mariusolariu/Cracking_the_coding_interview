import java.util.*;

public class BitManager{
	
	/*
	 * @return true == 1,
	 * 		   false == 0;	 
	 *	
 	 *  */
	public static boolean getBit(int num, int i){
		return (num & (1 << i)) != 0;
	}

	public static boolean getBit(byte num, int i){
		return (num & (1 << i)) != 0;
	}

	public static boolean getBit(long num, long i){
		return (num & (1 << i)) != 0;
	}

	public static int setBit(int num, int i){
		return num | (1 << i);
	}

	public static int clearBit(int num, int i){
		int mask = ~(1 << i);

		return mask & num;
	}

	public static long clearBit(long num, long i){
		long mask = ~(1l << i);

		return mask & num;
	}

	public static int updateBit(int num, int i, boolean bitIs1){
		int value = bitIs1? 1 : 0;
			
		return clearBit(num, i) | (value << i);
	}

	public static long updateBit(long num, long i, boolean bitIs1){
		long value = bitIs1? 1 : 0;
			
		return clearBit(num, i) | (value << i);
	}

	public static void printBitRep(int value){
		StringBuilder bits = new StringBuilder("");	

		int originalVal = value;
		int i = 0;

		while (value != 0){
		
			if (i % 4 == 0) bits.append(" ");

			if (getBit(value, 0)){
				bits.append("1");
			}else{
				bits.append("0");
			}


			value = value >>> 1;
			i++;
		}

		//fill the missing 0s for a positive value
		int len = bits.toString().replaceAll(" ","").length();
		if (len < 32){
			int dif = 32 - len;

			while (dif != 0) {
				if (i % 4 == 0) bits.append(" ");

				bits.append("0");
				dif--;
				i++;
			}
		}

		System.out.println("\n Bit rep of " + originalVal + " is: " + bits.reverse());

	}

	public static void printBitRep(long value){
		StringBuilder bits = new StringBuilder("");	

		long originalVal = value;
		int i = 0;

		while (value != 0){
		
			if (i % 4 == 0) bits.append(" ");

			if (getBit(value, 0)){
				bits.append("1");
			}else{
				bits.append("0");
			}


			value = value >>> 1;
			i++;
		}

		//fill the missing 0s for a positive value
		int len = bits.toString().replaceAll(" ","").length();
		if (len < 64){
			int dif = 64 - len;

			while (dif != 0) {
				if (i % 4 == 0) bits.append(" ");

				bits.append("0");
				dif--;
				i++;
			}
		}

		System.out.println("\n Bit rep of " + originalVal + " is: " + bits.reverse());

	}

	
	public static void printBitRep(byte value){
		StringBuilder bits = new StringBuilder("");

    byte originalVal = value;
    int i = 0;

		while (value != 0){
		
			if (i % 4 == 0) bits.append(" ");

			if (getBit(value, 0)){
				bits.append("1");
			}else{
				bits.append("0");
			}


			value =(byte) (value >>> 1);
			i++;
		}

		//fill the missing 0s for a positive value
		int len = bits.toString().replaceAll(" ","").length();
		if (len < 8){
			int dif = 8 - len;

			while (dif != 0) {
				if (i % 4 == 0) bits.append(" ");

				bits.append("0");
				dif--;
				i++;
			}
		}

		System.out.println("\n Bit rep of " + originalVal + " is: " + bits.reverse());

	}
}

