package com.shuttle.exer.sort.executor;

import com.shuttle.exer.sort.helper.DataHelper;

public class BubbleSortV2Executor implements SortExecutor {

    /**
     * 冒泡排序版本 II
     * 优化点：添加一个标识用来确定内层排序是否存在交换元素的动作，没有则说明数组已经有序。
     * 时间复杂度：最差为O(N²)，取决于随机数组的数据分布特点。
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
            boolean isExistSwap = false;
            // 减去 i 是因为之前的循环已经排过序了
            for (int j = 0; j < numsLen - 1 - i; j++) {
                if (nums[j + 1] >= nums[j]) {
                    continue;
                }
                isExistSwap = true;
                DataHelper.swapTwoElementInArray(nums, j, j + 1);
            }
            if (!isExistSwap) {
                return;
            }
        }
    }

}
