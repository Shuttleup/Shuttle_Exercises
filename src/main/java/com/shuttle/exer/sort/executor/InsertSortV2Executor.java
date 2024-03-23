package com.shuttle.exer.sort.executor;

public class InsertSortV2Executor implements SortExecutor {

    /**
     * 插入排序版本 II
     * 优化点：将比较过程改为二分法
     * 时间复杂度：O(N * log N) 外层循环 * 内层二分查找，N 是 nums 的长度。
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
            int leftIndex = 0;
            int rightIndex = i - 1;
            int curNum = nums[i];

            while (leftIndex <= rightIndex) {
                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
                if (nums[midIndex] > curNum) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
            // 需要将所有元素往右移一位
            int j;

            for (j = i - 1; j >= rightIndex + 1; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = curNum;
        }
    }

}
