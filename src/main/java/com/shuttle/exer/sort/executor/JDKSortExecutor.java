package com.shuttle.exer.sort.executor;

import java.util.Arrays;

public class JDKSortExecutor implements SortExecutor {

    /**
     * JDK Arrays 工具类的内置排序
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (checkNumsEmpty(nums)) {
            return;
        }
        Arrays.sort(nums);
    }

}
