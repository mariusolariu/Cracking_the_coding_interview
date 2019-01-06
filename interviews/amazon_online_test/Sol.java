package com.example.macbookpro.cracking_the_coding.amazon_task2;

import com.example.macbookpro.cracking_the_coding.amazon_task2.Position;
import java.util.*;

public class Sol{
	private int[][] mat;
	private Position endPosition;
	private Set<Integer> minElevations;
	
	private void printRoute(ArrayList<Position> route){
		for (Position p : route){
			System.out.print(p + "- " + mat[p.i][p.j] + " ");
		}

		System.out.println();
	}
	//it might not work because objects are allocated on the heap and when you go into recursion they are not saved on the stack
	private void findMaxOfMin(Position currentPos, int min, ArrayList<Position> route){
		route.add(currentPos);		

		if ((currentPos.i == endPosition.i ) && (currentPos.j == endPosition.j)){
			printRoute(route);
			minElevations.add(min);
			
			return;
		}	
			
		//don't take the elevation of startPos is into account
		if ((currentPos.i == 0) && (currentPos.j == 0)){
		}else{
      int currentElevation = mat[currentPos.i][currentPos.j];
      min = (currentElevation < min) ? currentElevation : min;
    }
		
		//try go right
		if (currentPos.j + 1 <= endPosition.j){
			findMaxOfMin(new Position(currentPos.i, currentPos.j + 1), min, new ArrayList<Position>(route));
		}

		//try go down
		if (currentPos.i + 1 <= endPosition.i){
			findMaxOfMin(new Position(currentPos.i + 1, currentPos.j), min, new ArrayList<Position>(route));
		}

		return;
	}

	public int maxOfMinElevations(int[][] mat,int rowCount, int columnCount){
		this.mat = mat;
		minElevations = new HashSet<>();
		Position startPos = new Position(0, 0);
		endPosition = new Position(rowCount - 1, columnCount - 1);
		ArrayList<Position> route = new ArrayList<>();


		findMaxOfMin(startPos, Integer.MAX_VALUE, route);

		Integer maxOfMin = Integer.MIN_VALUE;

		for (Integer i : minElevations){
			maxOfMin = (i > maxOfMin) ? i : maxOfMin;
		}

		return maxOfMin;
	}

	public static void main(String[] args){
//		int[][] mat = new int[][]{
//									{1,2},
//									{3,4}
//								 };


    int[][] mat = new int[][]{
        {1,5, 5},
        {3,4, 5},
        {2,15, 10}
    };
    Sol s = new Sol();

		System.out.println("Max of minimum elevations = " + s.maxOfMinElevations(mat, 3, 3));
	}

}

