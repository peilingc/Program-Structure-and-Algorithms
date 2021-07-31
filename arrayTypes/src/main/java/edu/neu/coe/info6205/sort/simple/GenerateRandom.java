package edu.neu.coe.info6205.sort.simple;

import java.util.Random;
import java.util.Arrays;


public class GenerateRandom {
	int array_size;
	
	public GenerateRandom(int n) {
		// store n for the object
        array_size = n;
    }
	
	public Integer[] get() {
		// generate and return new array
		Random rand = new Random();
		int upperbound = 2000;
		Integer[] ranArr = new Integer [array_size];
		for (int j = 0; j < array_size; j++) {
			ranArr[j] = rand.nextInt(upperbound);
		}
		return ranArr;
	}	
	
	/**
	public static void main(String args[]) {
		GenerateRandom test_obj = new GenerateRandom(5);
		System.out.println(Arrays.toString(test_obj.get()));
    } 
    **/
}

