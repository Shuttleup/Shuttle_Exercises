package com.shuttle.exer.sort.executor;

import com.shuttle.exer.sort.helper.DataHelper;

public class InsertSortV1Executor implements SortExecutor {

    /**
     * 插入排序版本 I
     * 思路：将数组分为前边已排序和后边未排序的两部分，依次将未排序部分的元素插入到排序序列的指定位置。
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

        for (int i = 1; i < numsLen; i++) {
            // 未排序部分的元素在排序部分 从右往左 找到属于自己的位置
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                DataHelper.swapTwoElementInArray(nums, j, j + 1);
            }
        }
    }

}
