package edu.neu.coe.info6205.sort.simple;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateReverse {
	int array_size;
	
	public GenerateReverse(int n) {
		// store n for the object
        array_size = n;
    }
	
	public Integer[] get() {
		Integer[] allArr = IntStream.range(1,array_size+1).boxed().toArray(Integer[]::new);
		Integer[] revArr = new Integer[array_size];
		for (int j = 0; j < revArr.length; j++) {
			revArr[j] = allArr[array_size-j-1];
		}
		return revArr;
	}
	
	
/**
	public static void main(String args[]) {
		GenerateReverse test_obj = new GenerateReverse(21);
		System.out.println(Arrays.toString(test_obj.get()));
		
    } 
**/
}


