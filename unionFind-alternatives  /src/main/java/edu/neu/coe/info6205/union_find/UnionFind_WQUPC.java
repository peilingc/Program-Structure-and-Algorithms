package edu.neu.coe.info6205.union_find;
import java.util.Random;
/**
Using your implementation of UF_HWQUPC, 
develop a UF ("union-find") client that takes an integer value n from the command line 
to determine the number of "sites." 

Then generates random pairs of integers between 0 and n-1, 
calling connected() to determine if they are connected and union() if not. 
Loop until all sites are connected then print the number of connections generated. 

Package your program as a static method count() that 
takes n as the argument and returns the number of connections; 
and a main() that takes n from the command line, 
calls count() and prints the returned value. 

If you prefer, you can create a main program that doesn't require any input 
and runs the experiment for a fixed set of n values. 
Show evidence of your run(s).
**/

public class UnionFind_WQUPC {

	public static int count(int n) {
		
		int countConnections = 0;
		WQUPC wqupc = new WQUPC(n);
		while (wqupc.count() != 1) {
			int[] pairArr = generatePairs(n);
			if (!wqupc.connected(pairArr[0],pairArr[1])) {
				wqupc.union(pairArr[0], pairArr[1]);
			}
			countConnections++;
		}
		
		System.out.println("Number of sites n: " + n +
						   ", Number of pairs m: " + countConnections +
						   ", Depth: " + findMaxHeight(wqupc.showArr()));
		return countConnections;
	}
	
	
	private static int[] generatePairs(int i){
		
		Random generateRandom = new Random();
		int upperbound = i;
		int[] randomArr = new int[2];
		randomArr[0]= generateRandom.nextInt(upperbound);
		randomArr[1]= generateRandom.nextInt(upperbound);
		return randomArr;
	}
	
	public static int findMaxHeight(int[] arr) {
		int max_h = 1;
    	for (int n:arr) {
    		int h = 0;
    		int temp = n;
    		while(temp != arr[temp]) {
    			h+=1;
    			temp = arr[temp];
    		}
    		max_h = Math.max(h,max_h);
    	}
    	return max_h;
    }


}