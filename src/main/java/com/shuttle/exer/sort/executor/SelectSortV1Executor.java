package com.shuttle.exer.sort.executor;

import com.shuttle.exer.sort.helper.DataHelper;

public class SelectSortV1Executor implements SortExecutor {

    /**
     * 选择排序版本 I
     * 思路：将数组分为前边已排序和后边未排序的两部分，在未排序序列中找到最小元素，存放到排序序列的末尾。
     * 时间复杂度：O(N²) 内外两层循环，N 是 nums 的长度。
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

        for (int i = 0; i < numsLen - 1; i++) {
            int minNumIndex = i;

            for (int j = i + 1; j < numsLen; j++) {
                if (nums[j] >= nums[minNumIndex]) {
                    continue;
                }
                minNumIndex = j;
            }
            DataHelper.swapTwoElementInArray(nums, i, minNumIndex);
        }
    }

}
