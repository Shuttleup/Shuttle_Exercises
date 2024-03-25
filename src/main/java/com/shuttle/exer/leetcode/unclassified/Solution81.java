package com.shuttle.exer.leetcode.unclassified;

public class Solution81 {

    /**
     * 思路：二分查找，排序数组旋转后，一定还是有一部分是有序的
     * 时间复杂度：O(N) N 是 nums 数组的长度，最坏情况需要遍历完全
     * 空间复杂度：O(1)
     *
     * @param nums   旋转排序数组
     * @param target 目标值
     * @return 目标值在旋转排序数组中的索引位置
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) {
                return true;
            }
            // 左右部分必有一边有序
            if (nums[leftIndex] < nums[midIndex]) {
                // 左边有序
                if (nums[leftIndex] <= target && target < nums[midIndex]) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else if (nums[leftIndex] > nums[midIndex]) {
                // 右边有序
                if (nums[rightIndex] >= target && target > nums[midIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            } else {
                // nums[midIndex] == nums[leftIndex] 时
                // if nums[leftIndex] == target ==> nums[midIndex] == target 不满足
                // if nums[leftIndex] != target ==> leftIndex 就不是目标值的索引
                leftIndex++;
            }
        }

        return false;
    }

}
