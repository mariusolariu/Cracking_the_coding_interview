import java.util.*;

public class Sol{
	//Requirement: check if floating point number can be represented in fixed point using 32 bits
	public static String printBinary(double num){
		if (num >= 1 || num <= 0) return "Error";

		StringBuilder binary = new StringBuilder();
		binary.append(".");

		while(num > 0){
	
			if (binary.length() >= 32) return "Error";

			double r = num * 2;
			
			if (r >= 1){
				binary.append("1");
				num =  r - 1;
			}else{
				binary.append("0");
				num = r;
			}
		}

	
		return binary.toString();	
	}

	public static void main(String[] args){
	/*	long value = 1;
		BitManager.printBitRep(value);

		double vD = 0.78;
		BitManager.printBitRep(Double.doubleToRawLongBits(vD));

		double v1 = -0.78;
		BitManager.printBitRep(Double.doubleToRawLongBits(v1));

		double v2 = 0.1;
		BitManager.printBitRep(Double.doubleToRawLongBits(v2));

		double v3 = 0.99;
		BitManager.printBitRep(Double.doubleToRawLongBits(v3));
	*/
		double v = 0.72;
		System.out.println(v + " in fixed point is " + printBinary(v));
		

	}

}

