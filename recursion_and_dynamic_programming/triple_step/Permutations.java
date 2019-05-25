package com.example.macbookpro.cracking_the_coding.triple_step;

import java.util.*;


public class Permutations{

	private static void permutations(ArrayList<Integer> prefix, ArrayList<Integer> suffix){
		int lengthSuffix = suffix.size();

		if (lengthSuffix == 0){
			//print prefix
				System.out.println(prefix);
		}else{
			for (int i = 0; i < lengthSuffix; i++){
				ArrayList<Integer> currentPrefix = new ArrayList<>(prefix);
        currentPrefix.add(suffix.get(i));
	
				//remove current element which was added to the prefix
				ArrayList<Integer> newSuffix = new ArrayList<Integer>();

				for (int j = 0; j < lengthSuffix; j++){
					if (i == j) continue;

					newSuffix.add(suffix.get(j));	
				}

				permutations(new ArrayList<Integer>(currentPrefix), newSuffix);
			}
		}
		
	}

	public static void permutations(int[] arr){
		//Arrays.asList doesnt work with an array of primitives because it doesn't handle boxing
		
		ArrayList<Integer> suffix = new ArrayList<>();

		for (int i : arr){
			suffix.add(Integer.valueOf(i));
		}

		permutations(new ArrayList<Integer>(), suffix);

	}

	public static void main(String[] args){
		int myArr[] = new int[]{3, 2};

		 permutations(myArr);



	}

}
