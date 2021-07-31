package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UnionFind_WQU_Depth {
	
	public static int count(int n) {
		
		int countConnections = 0;
		WQU_Depth wqud = new WQU_Depth(n);
		while (wqud.count() != 1) {
			int[] pairArr = generatePairs(n);
			if (!wqud.connected(pairArr[0],pairArr[1])) {
				wqud.union(pairArr[0], pairArr[1]);
			}
			countConnections++;
		}
		System.out.println("Number of sites n: " + n +
						   ", "+"Number of pairs m: "+ countConnections +
						   ", Depth: " + wqud.findMaxHeight());
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
