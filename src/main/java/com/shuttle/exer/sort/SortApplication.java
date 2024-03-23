package com.shuttle.exer.sort;

import com.shuttle.exer.sort.executor.SortExecutor;
import com.shuttle.exer.sort.executor.SortExecutorManager;
import com.shuttle.exer.sort.helper.DataHelper;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static com.shuttle.exer.sort.constant.NumberConstants.NUMBER_100_000;

public class SortApplication {
    public static void main(String[] args) {
        Map<String, SortExecutor> sortExecutorManager = SortExecutorManager.getSortExecutorManager();
        int[] randomNums = DataHelper.generateRandomNumsByCount(NUMBER_100_000);
        Set<String> allSortExecutorNames = sortExecutorManager.keySet();

        for (String executorName : allSortExecutorNames) {
            long startTimestamp = System.currentTimeMillis();
            int[] copyRandomNums = Arrays.copyOf(randomNums, randomNums.length);
            sortExecutorManager.get(executorName).sort(copyRandomNums);
//            System.out.println(Arrays.toString(copyRandomNums));
            long endTimestamp = System.currentTimeMillis();
            computeAndPrintDuration(executorName, startTimestamp, endTimestamp);
        }
        /**
         * Bubble Sort Version I ==> 14636 ms
         * Bubble Sort Version II ==> 11860 ms
         * Select Sort Version I ==> 4471 ms
         * Select Sort Version II ==> 2363 ms
         * Insert Sort Version I ==> 3342 ms
         * Insert Sort Version II ==> 1507 ms
         * Shell Sort Version I ==> 11 ms
         * Quick Sort Version I ==> 26 ms
         * Merge Sort Version I ==> 21 ms
         * Heap Sort Version I ==> 10 ms
         * JDK Sort ==> 22 ms
         */
    }

    private static void computeAndPrintDuration(String executorName, long startTimestamp, long endTimestamp) {
        System.out.println(executorName + " ==> " + (endTimestamp - startTimestamp) + " ms");
    }

}
