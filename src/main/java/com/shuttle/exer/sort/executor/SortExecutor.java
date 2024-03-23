package com.shuttle.exer.sort.executor;

public interface SortExecutor {

    /**
     * 排序数组
     *
     * @param nums 待排序的数组
     */
    void sort(int[] nums);

    default boolean checkNumsEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

}
