package com.example.macbookpro.ocadotest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Marius: marius.lucian.olariu@gmail.com
 */
public class Task1 {

  public Set<Integer> slices;

  public  int solution(int[] array) {
    // write your code in Java SE 8
    slices = new TreeSet<>();
    int maxSum = -1;
    boolean allNegatives = true;

    for (Integer i : array) {
      if (i >= 0) {
        allNegatives = false;
        break;
      }
    }

    if (allNegatives){
      return maxSum;
    }

    int arrLen = array.length;

    int i, j;
    for (i = 0; i < arrLen; i++) {
      if (array[i] <= 0){
        continue;
      }

      slices.add(array[i]);

      for (j = i; j < arrLen; j++) {
        if (array[j] < 0){
          break;
        }
      }

      if (j > i){
        int currentSum = 0;

        for (int k = i; k < j; k++) {
          currentSum += array[k];
        }

        slices.add(currentSum);
      }

    }

    for (Integer l: slices
    ) {
      if (l > maxSum) maxSum = l;
    }

    return maxSum;
  }

  public static void main(String[] args) {

    int[] arr = new int[]{-1, 1, 1, -1};

    Task1 task1 = new Task1();

    System.out.println("Sol =" + task1.solution(arr));
  }

}
