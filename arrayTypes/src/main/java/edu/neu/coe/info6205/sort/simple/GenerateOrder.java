package edu.neu.coe.info6205.sort.simple;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateOrder {
	int array_size;
	
	public GenerateOrder(int n) {
		// store n for the object
        array_size = n;
    }
	
	public Integer[] get() {
		Integer[] allArr = IntStream.range(1, array_size+1).boxed().toArray( Integer[]::new );
		return allArr;
	}
	
/**	
	public static void main(String args[]) {
		GenerateOrder test_obj = new GenerateOrder(5);
		System.out.println(Arrays.toString(test_obj.get()));
		
    } 
**/	
}



