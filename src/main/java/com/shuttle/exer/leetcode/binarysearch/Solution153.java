package com.shuttle.exer.leetcode.binarysearch;

public class Solution153 {

    /**
     * 思路：二分查找
     * 详细解释：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/126635/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
     * 时间复杂度：O(log N)
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 数组中的最小值
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] > nums[rightIndex]) {
                // [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            } else {
                // [leftIndex, midIndex]
                rightIndex = midIndex;
            }
        }

        return nums[leftIndex];
    }

}
