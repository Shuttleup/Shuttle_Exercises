package com.shuttle.exer.sort.executor;

import com.shuttle.exer.sort.helper.DataHelper;

public class SelectSortV2Executor implements SortExecutor {

    /**
     * 选择排序版本 II
     * 优化点：每一轮同时找出最小值和最大值，分别放在队首和队尾，理论上循环次数可减半。
     * 时间复杂度：O(N²)，最坏情况为 N/2 次循环。
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
        int leftIndex = 0;
        int rightIndex = numsLen - 1;

        while (leftIndex < rightIndex) {
            int minNumIndex = leftIndex;
            int maxNumIndex = rightIndex;

            for (int i = leftIndex; i <= rightIndex; i++) {
                if (nums[i] < nums[minNumIndex]) {
                    minNumIndex = i;
                }
                if (nums[i] > nums[maxNumIndex]) {
                    maxNumIndex = i;
                }
            }
            DataHelper.swapTwoElementInArray(nums, maxNumIndex, rightIndex);
            // 需要考虑 minNumIndex == maxNumIndex 的情况
            if (minNumIndex == rightIndex) {
                minNumIndex = maxNumIndex;
            }
            DataHelper.swapTwoElementInArray(nums, minNumIndex, leftIndex);
            leftIndex++;
            rightIndex--;
        }
    }

}
