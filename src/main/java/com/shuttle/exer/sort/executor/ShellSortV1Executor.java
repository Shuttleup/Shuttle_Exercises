package com.shuttle.exer.sort.executor;

public class ShellSortV1Executor implements SortExecutor {

    /**
     * 希尔排序版本 I
     * 思路：类似于插入排序，在此基础上设置 increment 间隔作为逻辑分组
     * 时间复杂度：O(N * log N) ~ O(N²) 取决于 increment 的选取
     * 空间复杂度：O(1)
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (checkNumsEmpty(nums)) {
            return;
        }
        int numsLen = nums.length;
        int increment = numsLen;

        while (increment > 1) {
            // 自定义
            increment = increment / 3 + 1;
            // 对每个按增量划分后的逻辑分组，进行插入排序
            for (int i = increment; i < numsLen; i++) {
                if (nums[i - increment] > nums[i]) {
                    int curNum = nums[i];
                    int j = i - increment;

                    while (j >= 0 && nums[j] > curNum) {
                        nums[j + increment] = nums[j];
                        j -= increment;
                    }
                    nums[j + increment] = curNum;
                }
            }
        }
    }

}
