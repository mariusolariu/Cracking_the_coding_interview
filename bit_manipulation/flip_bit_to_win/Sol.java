import java.util.*;

public class Sol{

	 //I've built a state machine to solve this problem, see photo from this folder
  public static long getLongestOnesSeq(long num){
    
    if (num == -1) return 64;

    long maxSeqLength = 0;

    int state = 0;

    int bitCount1 = 0;
    int bitCount2 = 0;
    int possibleZeroBitPos = 0;
    int zeroBitPos = 0;
    int i = 0;


    while (i < 64){

      switch (state){
        case 0:
          //useful for when getting to state 0 from state 4 (e.g. bitCount1 won't be 0 )
          bitCount1 = 0;
          bitCount2 = 0;

          //select next state
          if (BitManager.getBit(num, 0)){
            state = 1;
            bitCount1++;
          }else{
            state = 0;
			
			//if the num has only a sequence of 1s
			maxSeqLength = Math.max(maxSeqLength, bitCount1);
          }

      break;
      case 1:

        if (BitManager.getBit(num, 0)){
          state = 1;
          bitCount1++;
        }else{
          state = 2;
        }

        break;

      case 2:

        if (BitManager.getBit(num, 0)){
          state = 3;
          bitCount2++;

          possibleZeroBitPos = i - 1;
        }else{
          state = 0;
        }

        break;

      case 3:

        if (BitManager.getBit(num, 0)){
          state = 3;
          bitCount2++;
        }else{
          state = 4;

          //check if current seq (1s 0 1s) is bigger than the previous one
          if (bitCount1 + bitCount2 + 1> maxSeqLength){
            maxSeqLength = bitCount1 + bitCount2 + 1;
            zeroBitPos = possibleZeroBitPos;
          }


          //continue the processing maybe seq2 of 1s with coming ones can form a longer seq
          bitCount1 = bitCount2;
          bitCount2 = 0;
          possibleZeroBitPos = i;
        }

        break;

      case 4:

        if (BitManager.getBit(num, 0)){
          state = 3;
          bitCount2++;
        }else{
          state = 0;
        }

        break;
    }


    num = num >>> 1;
    i++;
  }


		return maxSeqLength;
}

	public static void main(String[] args){
		long num = 1775;

		System.out.println("Longest 1 seq by fliping 1 bit is: " + getLongestOnesSeq(num)); 	

		num = 16311;
		
		BitManager.printBitRep(16311);
		System.out.println("Longest 1 seq by fliping 1 bit is: " + getLongestOnesSeq(num)); 	
	}

}

