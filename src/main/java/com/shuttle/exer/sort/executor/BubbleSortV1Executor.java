package com.shuttle.exer.sort.executor;

import com.shuttle.exer.sort.helper.DataHelper;

public class BubbleSortV1Executor implements SortExecutor {

    /**
     * 冒泡排序版本 I
     * 思路：将数组中相邻元素从前往后依次进行比较，如果前一个元素比后一个元素大则交换，每一轮循环最大元素就在数组末尾。
     * 时间复杂度：O(N²) 内外两层循环，N 是 nums 的长度
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
            for (int j = 0; j < numsLen - 1; j++) {
                if (nums[j + 1] >= nums[j]) {
                    continue;
                }
                DataHelper.swapTwoElementInArray(nums, j, j + 1);
            }
        }
    }

}
