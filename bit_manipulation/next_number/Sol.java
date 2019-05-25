package com.example.macbookpro.cracking_the_coding;

import java.util.*;

public class Sol {

  /* num is a positive integer
   * 	  @return result[0] - previous number
   * 			  result[1] - next number;
   * 			  -1 is returned if there is no valid option for next/previous number
   */
  public static long[] getNextPrevious(long num) {
    long[] result = new long[]{-1, -1};
    byte[] bits = new byte[64];

    //read bit rep. of number
    for (int i = 63; i >= 0; i--) {
      if (BitManager.getBit(num, 0)) {
        bits[i] = 1;
      } else {
        bits[i] = 0;
      }

      num >>>= 1;
    }

    byte[] nextNumberBits = new byte[bits.length];
    System.arraycopy(bits, 0, nextNumberBits, 0, bits.length);
    boolean increase = true; // increase the number to get the next number
    result[1] = switchBits(nextNumberBits, increase);

    byte[] previousNumberBits = new byte[bits.length];
    System.arraycopy(bits, 0 , previousNumberBits, 0 , bits.length);
    increase = false;     //decrease
    result[0] = switchBits(previousNumberBits, increase);

    return result;
  }

  private static long switchBits(byte[] bitsArr, boolean increase) {
    boolean conditionMet = false;
    long result = -1;
    byte firstBit, secondBit; // from left to right of the bit rep of a number

    if (increase){
        firstBit = 0;
        secondBit = 1;
    }else{
      firstBit = 1;
      secondBit = 0;
    }

    for (int i = 63; i > 0; i--) {

      if ((bitsArr[i - 1] == firstBit) && (bitsArr[i] == secondBit)) {
        conditionMet = true;
        bitsArr[i - 1] = secondBit;
        bitsArr[i] = firstBit;
        break;
      }

    }

    if (conditionMet) {
      result = getNumber(bitsArr);
    }

    return result;
  }

  private static long getNumber(byte[] bits) {
    long result = 0;

    for (int i = 63, j = 0; i >= 0; i--, j++) {

      if (bits[i] == 1) {
        result = BitManager.updateBit(result, j, true);
      } else {
        result = BitManager.updateBit(result, j, false);
      }

    }

    return result;
  }


  public static void main(String[] args) {
		/*
				byte one = 1;
				BitManager.printBitRep(one);

				byte minusOne = -1;
				BitManager.printBitRep(minusOne);
		
		*/

    long middle = 8;
    long[] result = getNextPrevious(middle);
    System.out.println("Result: " + result[0] + " " + middle + " " + result[1]);

    middle = 112;
    result = getNextPrevious(middle);
    System.out.println("Result: " + result[0] + " " + middle + " " + result[1]);

    middle = 21;
    result = getNextPrevious(middle);
    System.out.println("Result: " + result[0] + " " + middle + " " + result[1]);

    middle = 76;
    result = getNextPrevious(middle);
    System.out.println("Result: " + result[0] + " " + middle + " " + result[1]);
  }

}

