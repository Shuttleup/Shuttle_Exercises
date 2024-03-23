package com.shuttle.exer.sort.executor;

import com.shuttle.exer.sort.helper.DataHelper;

public class QuickSortV1Executor implements SortExecutor {

    /**
     * 快速排序版本 I
     * 思路：每趟排序时选出一个基准值，然后将所有元素与该基准值比较，并按大小分成左右两部分，递归执行该过程，直到所有元素都完成排序。
     * 时间复杂度：O(N * log N) N 为数组的长度
     * 空间复杂度：O(N * log N) 递归调用所消耗的栈空间
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (checkNumsEmpty(nums)) {
            return;
        }
        int leftBoundary = 0;
        int rightBoundary = nums.length - 1;

        quickSort(nums, leftBoundary, rightBoundary);
    }

    private void quickSort(int[] nums, int leftBoundary, int rightBoundary) {
        if (leftBoundary > rightBoundary) {
            return;
        }
        int leftIndex = leftBoundary;
        int rightIndex = rightBoundary;
        // 选取一个基准值 pivot，小于 pivot 的元素在左边，大于 pivot 的元素在右边。
        int pivot = nums[leftIndex];

        while (leftIndex < rightIndex) {
            // 从右往左找一个小于 pivot 的数
            while (pivot <= nums[rightIndex] && leftIndex < rightIndex) {
                rightIndex--;
            }
            // 从左往右找一个大于 pivot 的数
            while (pivot >= nums[leftIndex] && leftIndex < rightIndex) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                DataHelper.swapTwoElementInArray(nums, leftIndex, rightIndex);
            }
        }
        // 中间这个数放左边
        nums[leftBoundary] = nums[leftIndex];
        // pivot 放中间
        nums[leftIndex] = pivot;
        // 递归中间数的左右部分
        quickSort(nums, leftBoundary, leftIndex - 1);
        quickSort(nums, rightIndex + 1, rightBoundary);
    }

}
