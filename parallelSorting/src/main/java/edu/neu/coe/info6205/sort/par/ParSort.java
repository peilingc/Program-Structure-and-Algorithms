package edu.neu.coe.info6205.sort.par;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * This code has been fleshed out by Ziyao Qiao. Thanks very much.
 * TODO tidy it up a bit.
 */
class ParSort {
	
	// set value in main
    public static int cutoff ; 
    public static int MaxDepth ;

    public static void sort(int[] array, int from, int to, int cur_depth) {
        if (to - from < cutoff) Arrays.sort(array, from, to);
        else {
            CompletableFuture<int[]> parsort1 = parsort(array, from, from + (to - from) / 2, cur_depth+1); // TO IMPLEMENT
            CompletableFuture<int[]> parsort2 = parsort(array, from + (to - from) / 2, to, cur_depth+1); // TO IMPLEMENT
            CompletableFuture<int[]> parsort = parsort1.thenCombine(parsort2, (xs1, xs2) -> {
                int[] result = new int[xs1.length + xs2.length];
                // TO IMPLEMENT
                int x1Index = 0;
				int x2Index = 0;
                for (int i = 0; i < result.length; i++) {
					if (x1Index >= xs1.length)
						result[i] = xs2[x2Index++];
					else if (x2Index >= xs2.length)
						result[i] = xs1[x1Index++];
					else if (xs1[x1Index] < xs2[x2Index])
						result[i] = xs1[x1Index++];
					else
						result[i] = xs2[x2Index++];
				}
                
                return result;
            });

            parsort.whenComplete((result, throwable) -> System.arraycopy(result, 0, array, from, result.length));
//            System.out.println("# threads: "+ ForkJoinPool.commonPool().getRunningThreadCount());
            parsort.join();
        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to, int cur_depth) {
        return CompletableFuture.supplyAsync(
                () -> {
                    int[] result = new int[to - from];
                    // System.out.print(cur_depth);
                    // System.out.print("  ");
                    // System.out.println(MaxDepth);
                    // TO IMPLEMENT
                    System.arraycopy(array, from, result, 0, result.length);
                    
                    //if the current number of available threads >= the max number of threads, stop recursion
        			if (cur_depth >= MaxDepth) {
        				Arrays.sort(result);
        			} else {
        				sort(result, 0, result.length, cur_depth);
        			}
        			return result;
                }
        );
    }
}