package edu.neu.coe.info6205.sort.par;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * This code has been fleshed out by Ziyao Qiao. Thanks very much.
 * TODO tidy it up a bit.
 */
public class Main {
	public static int max_cutoff = 1000000;
	public static int num_cutoff_tested = 10;
	public static int exp_array_size = 8000000;
	public static int max_depth = 9;
	// Note that given cutoff & array size,
	// the max depth possible is log2(exp_array_size/cur_cutoff)
	// max_depth larger than this is meaningless
	

    public static void main(String[] args) {
        processArgs(args);
        System.out.println("Degree of parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        Random random = new Random();
        int[] array = new int[exp_array_size];
        int cur_cutoff = max_cutoff;
        ArrayList<Long> timeList = new ArrayList<>();
        for (int j = 0; j < num_cutoff_tested; j++) {
        	for (int d = 0; d < max_depth; d++) {
        		// Set experiment parameters
        		ParSort.MaxDepth = d;
        		ParSort.cutoff = cur_cutoff;
        		// Run experiment (for t times)
        		long time;
                long startTime = System.currentTimeMillis();
                for (int t = 0; t < 10; t++) {
                    for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
                    ParSort.sort(array, 0, array.length, 0); // Last 0 indicates depth = 0 in main
                }
                long endTime = System.currentTimeMillis();
                time = (endTime - startTime);
                timeList.add(time);
                System.out.println("cutoff：" + cur_cutoff + "\tdepth" + d + "\tAvg. Time:" + time + "ms");
        	}
        	// update cutoff
    		cur_cutoff /=2 ;
        }
        try {
            FileOutputStream fis = new FileOutputStream("./src/result.csv");
            OutputStreamWriter isr = new OutputStreamWriter(fis);
            BufferedWriter bw = new BufferedWriter(isr);
            int j = 0;
            for (long i : timeList) {
                String content = (double) 10000 * (j + 1) / 2000000 + "," + (double) i / 10 + "\n";
                j++;
                bw.write(content);
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processArgs(String[] args) {
        String[] xs = args;
        while (xs.length > 0)
            if (xs[0].startsWith("-")) xs = processArg(xs);
    }

    private static String[] processArg(String[] xs) {
        String[] result = new String[0];
        System.arraycopy(xs, 2, result, 0, xs.length - 2);
        processCommand(xs[0], xs[1]);
        return result;
    }

    private static void processCommand(String x, String y) {
        if (x.equalsIgnoreCase("N")) setConfig(x, Integer.parseInt(y));
        else
            // TODO sort this out
            if (x.equalsIgnoreCase("P")) //noinspection ResultOfMethodCallIgnored
                ForkJoinPool.getCommonPoolParallelism();
    }

    private static void setConfig(String x, int i) {
        configuration.put(x, i);
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private static final Map<String, Integer> configuration = new HashMap<>();


}
