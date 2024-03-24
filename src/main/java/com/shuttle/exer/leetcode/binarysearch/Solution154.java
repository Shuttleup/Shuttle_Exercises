package com.shuttle.exer.leetcode.binarysearch;

public class Solution154 {

    /**
     * 思路：二分查找
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
            } else if (nums[midIndex] < nums[leftIndex]) {
                // [leftIndex, midIndex]
                rightIndex = midIndex;
            } else {
                // [leftIndex, rightIndex--]
                rightIndex--;
                /**
                 * nums[midIndex] == nums[rightIndex]，那么 rightIndex-- 继续进入下一轮循环
                 * 这个操作会一直尝试收缩右边界，且不会越界，rightIndex > leftIndex >= 0
                 * nums[rightIndex] 必定不是唯一的最小值，如果是唯一最小值，nums[midIndex] > nums[rightIndex] => true
                 */
            }
        }

        return nums[leftIndex];
    }

}
