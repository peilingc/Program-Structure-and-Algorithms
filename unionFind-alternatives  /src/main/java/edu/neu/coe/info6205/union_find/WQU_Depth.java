package edu.neu.coe.info6205.union_find;

import java.util.Arrays;

public class WQU_Depth {
		
	private int[] parent;  	//parent[i] = parent of i
	private int[] height;	//height[i] = height of subtree rooted at i
	private int count;  	//number of components
		
		
	//constructor - make a set of data, height starts from 0 and components start from N
	public WQU_Depth(int n) {
		count = n;
		parent = new int[n];
	    height = new int[n];
	    for (int i = 0; i < n; i++) {
	        parent[i] = i;
	        height[i] = 0;
	       }
	}
		
		
	//count number of components, should be 1 at the end
	public int count() {
		return count;
	}
		
		
	//find the root of p
	/**
	Look for the root of i, "prnt[i] == i" only exists in the root. 
	If i != current prnt[i] value, which means prnt[i] is not its original value, 
	return adjusted value and keep looking for higher index.
	**/
		
	public int find(int p) {
		validate(p);
		while (p != parent[p])
			p = parent[p];
	    return p;
	}
		
		
	//validate that p is a valid index
	private void validate(int p) {
		int n = parent.length;
	    if (p < 0 || p >= n) {
	    	throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
	    }
	}
	    
	    
	//return true if the the two sites are in the same component
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
		
			
	//union 2 integers
	/**
	Each time only one(p's or q's root) will change value.
	If p and q have same height, union and then height will increment by 1.
	After each union, component will decrease by 1.
	**/
	
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		
		// make shorter root point to taller one
		if (height[i] < height[j]) parent[i] = j;
	    else if (height[i] > height[j]) parent[j] = i;
	    else {
	    	parent[j] = i;
	        height[i]++;
	    }
		count--;
	}
	
	public int findMaxHeight() {
		int max = Arrays.stream(height).max().getAsInt();
		return max;
	}
}
