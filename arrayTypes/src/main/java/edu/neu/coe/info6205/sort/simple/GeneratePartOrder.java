package edu.neu.coe.info6205.sort.simple;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;



public class GeneratePartOrder {
	int array_size;
	
	public GeneratePartOrder(int n) {
		// store n for the object
        array_size = n;
    }
	
	public Integer[] get() {
		Integer partArr[] = new Integer[array_size];
		if (array_size % 2 == 0) {
			//ordered
			Integer[] orderArr = IntStream.range(1, (array_size/2)+1).boxed().toArray( Integer[]::new );
			for(int i=0; i<partArr.length/2; i++) {
				partArr[i] = orderArr[i];
			}
			//random
			Random random = new Random();
			int upperbound = 2000;
			for (int j = partArr.length/2; j < partArr.length; j++) {
				partArr[j] = random.nextInt(upperbound);
			}
		}
		
		else {
			//ordered
			Integer[] orderArr = IntStream.range(1, (array_size+1)/2).boxed().toArray( Integer[]::new );
			for (int i = 0; i < ((partArr.length-1)/2); i++) {
				partArr[i] = orderArr[i];
			}
			//random
			Random random = new Random();
			int upperbound = 2000;
			for (int j = (partArr.length-1)/2; j < partArr.length; j++) {
				partArr[j] = random.nextInt(upperbound);
			}
		}
		
		return partArr;
	}



/**
	public static void main(String args[]) {
		GeneratePartOrder test_obj = new GeneratePartOrder(10);
		System.out.println(Arrays.toString(test_obj.get()));
		
    } 
**/
}