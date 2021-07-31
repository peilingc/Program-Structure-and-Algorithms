package edu.neu.coe.info6205.union_find;

import java.util.Random;
import edu.neu.coe.info6205.union_find.UF_HWQUPC;
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

public class UnionFind {
	
	public static void main(String[] args) {
		//n represents the number of sites
		//m represents the number of pairs generated to accomplish union
		
		//input n by command line
		//int n = Integer.parseInt(args[0]);
		
		//run the experiment for a fixed set of n values
		int n =1;
		for (int i=0; i<5; i++) {
			int m =count(n);
			//System.out.print("Number of sites n: "+n+", ");
			System.out.println(m);
			
			double temp = n;
			double tempn = Math.pow(2, temp);
			int intn = (int) tempn;
			n = intn;
		}
	}
	
	private static int count(int n) {
		int countConnections = 0;
		UF_HWQUPC hwqupc = new UF_HWQUPC(n,true);
		while (hwqupc.components() != 1) {
			int[] pairArr = generatePairs(n);
			if (!hwqupc.connected(pairArr[0],pairArr[1])) {
				hwqupc.union(pairArr[0], pairArr[1]);
				
			}
			countConnections++;
		}
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

}
