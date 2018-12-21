package com.example.macbookpro.ocadotest;

/**
 * Created by Marius: marius.lucian.olariu@gmail.com
 */
public class Task2 {
  int[] visited;

  public int solution(int[] arr) {
    // write your code in Java SE 8
    int len = arr.length;

    if (len == 0){
      return 0;
    }


    visited = new int[len];
    for (int i = 0; i < len; i++) {
      visited[i] = 0;
    }

    int maxBeadsL = 0;
    for (int i = 0; i < len ; i++) {

      //My optimization: try to reduce the number of recursive calls
      if (visited[i] == 0){
        int currentBeadsDepth = rec(arr, arr[i], i, 1);
        if (maxBeadsL < currentBeadsDepth){
          maxBeadsL = currentBeadsDepth;
        }
      }
    }

    return maxBeadsL; //for now
  }

  private int rec(int[] arr, int nextIndex, int originalIndex, int depth) {
    int nextNodeToVisit = arr[nextIndex];
    visited[nextNodeToVisit] = 1;

    if (arr[nextIndex] == arr[originalIndex]){
      return depth;
    }

    return rec(arr, arr[nextIndex], originalIndex, depth + 1);
  }

  public static void main(String[] args) {

  }
}
