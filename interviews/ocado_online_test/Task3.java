package com.example.macbookpro.ocadotest;

/**
 * Created by Marius: marius.lucian.olariu@gmail.com
 */
public class Task3 {

//  public static int nrOfSteps(int number, int stepCount){
//    if (number == 0){
//      return stepCount;
//    }
//
//    number =  (number % 2 == 0) ? number / 2 : number - 1;
//
//    return nrOfSteps(number, stepCount + 1);
//  }
//
//  public static int solution(String s){
//    int value = Integer.valueOf(s, 2);
//
//    return nrOfSteps(value, 0);
//  }

  //Note: V is non-negative
  //Solution: odd numbers have least significant bit "1", even numbers have "0" => for each "1" (but the first) there are 2 steps involved
  public static int solution(String s) {
    int steps = 0;

    if (s.length() == 0) {
      return 0;
    }

    int value = Integer.valueOf(s, 2);

    while (value != 0) {
      int leastSignificantBit = (value & 1) == 1 ? 1 : 0;

      if ((leastSignificantBit == 1) && (value != 1)){ //odd number; when the last value is 1 there is just one more step to perform not two
        steps += 2;
      }else{
        steps += 1;
      }

      value =  value >> 1;
    }

    return steps;
  }

  public static void main(String[] args) {
    //System.out.println("Steps = " + solution("011100")); // 28
    //System.out.println("Steps = " + solution("010100")); // 20
    System.out.println("Steps = " + solution("010101")); // 21
  }

}
