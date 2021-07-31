/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.simple;
import  edu.neu.coe.info6205.util.Benchmark;
import  edu.neu.coe.info6205.util.Benchmark_Timer;
import  edu.neu.coe.info6205.util.LazyLogger;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class InsertionSort{
   
	public void sort (Integer[] intArr){
        for (int i = 1; i < intArr.length; i++)
            insert(i, intArr);
    }
    
	private void insert(int i, Integer[] intArr){
        for (int j = i-1; j >= 0; j--)
            if (((Comparable)intArr[j]).compareTo(intArr[j+1])>0)
                {
            	swap(intArr, j, j+1);
        		//printArray(intArr);
        		}
            else 
            	{
            	//printArray(intArr);
                break;
                }
    }
    
	private void swap(Integer[] intArr, int j, int i){
        int temp = intArr[j];
        intArr[j] = intArr[i];
        intArr[i] = temp; 
    }
    
    private static void printArray(Integer[] intArr) {
        for (int i = 0; i < intArr.length; i++) 
            System.out.print(intArr[i] + " ");
  
        System.out.println(); 
        
    } 

/**	
	public static void main(String args[]) {
		//Integer[] intArr = new int[args.length];
        //for (int i = 0; i < args.length; i++) {
        //    intArr[i] = Integer.parseInt(args[i]);        
    } 
**/    
}


/**
import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
/**    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
/**    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
/**   public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
/**    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();

        // TO BE IMPLEMENTED
    }

    /**
     * This is used by unit tests.
     *
     * @param ys  the array to be sorted.
     * @param <Y> the underlying element type.
     */
/**    public static <Y extends Comparable<Y>> void mutatingInsertionSort(Y[] ys) {
        new InsertionSort<Y>().mutatingSort(ys);
    }

    public static final String DESCRIPTION = "Insertion sort";

}
**/