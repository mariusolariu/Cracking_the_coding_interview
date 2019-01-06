package com.example.macbookpro.cracking_the_coding.amazon_task2;

import java.util.*;

public class Position{
	public int i;
	public int j;

	public Position(int i, int j){
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString(){
		return "(" + i + ", " + j + ")";
	}
}
