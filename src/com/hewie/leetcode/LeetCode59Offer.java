package com.hewie.leetcode;

import java.util.Arrays;

public class LeetCode59Offer {
    /**
     * 方法3：最快
     *      使用下标记住每个窗口的最大值位置，
     *      窗口每次向右移动一步，直到窗口右端超出数组长度
     *      当最大值位置不在当前窗口就让最大值下标放到当前窗口第一个位置，再在当前窗口定位最大值
     *      如果最大值位置再当前窗口内部，则直接比较当前窗口最右边数与最大值即可，
     * */
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= 0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        int left = 0,right = k - 1,maxIndex = -1;
        while (right < nums.length){
            if(maxIndex < left){
                maxIndex = left;
                for (int i = left;i <= right; i++) {
                    maxIndex = (nums[maxIndex] < nums[i]) ? i : maxIndex;
                }
            } else {
                maxIndex = (nums[maxIndex] < nums[right]) ? right : maxIndex;
            }
            result[left] = nums[maxIndex];
            left ++;
            right ++;
        }
        return result;
    }*/

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= 0){
            return new int[0];
        }
        int[] result = new int[nums.length- k + 1];
        int left = 0,right = k - 1, maxIndex = -1;
        while (right < nums.length){
            if(maxIndex < left){
                maxIndex = left;
                for (int i = left; i <= right; i++) {
                    maxIndex = (nums[maxIndex] < nums[i]) ? i : maxIndex;
                }
            } else {
                maxIndex = (nums[maxIndex] < nums[right]) ? right : maxIndex;
            }
            result[left] = nums[maxIndex];
            left ++;
            right ++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1,3,-1,-3,5,3,6,7};
        LeetCode59Offer leetCode59Offer = new LeetCode59Offer();
        System.out.println(Arrays.toString(leetCode59Offer.maxSlidingWindow(num,3)));
    }

      /**
       * 方法2：次快
       *       将窗口内找最大值时间控制为O(1)，使用栈，栈头到栈尾递减，且栈内只有窗口内的元素
       *       1. 将第一个窗口的元素入栈，位置栈头最大，递减到栈尾，存储栈头元素
       *       2. 窗口右移一位，判断新的元素与栈内元素大小（从栈尾开始比较），保持栈内是递减的
       *          保持栈内的元素只有当前窗口的元素：判断栈头元素是否等于窗口前一个元素，是则弹出栈头元素
       *       3. 存储栈头元素
       *       4. 重复2，3直到数组最后一个元素
       * */
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums.length <= 0) return new int[0];
    //     int[] res = new int[nums.length-k+1];
    //     Deque<Integer> q = new LinkedList<>();
    //     for (int i=0; i<k; i++) {   // 第一个窗口元素入栈
    //         while (!q.isEmpty() && q.peekLast()<nums[i]) {
    //             q.removeLast();
    //         }
    //         q.addLast(nums[i]);
    //     }
    //     res[0] = q.peekFirst();
    //     for (int i=k; i<nums.length; i++) {
    //         if (q.peekFirst()==nums[i-k]) {
    //             q.removeFirst();
    //         }
    //         while (!q.isEmpty() && q.peekLast()<nums[i]) {
    //             q.removeLast();
    //         }
    //         q.addLast(nums[i]);
    //         res[i-k+1] = q.peekFirst();
    //     }
    //     return res;
    // }

      /**
       * 方法1：暴力最慢
       *       暴力解
       * */
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums.length <= 0) return new int[0];
    //     int[] res = new int[nums.length-k+1];
    //     for (int i=0; i<=nums.length-k; i++) {
    //         int max = Integer.MIN_VALUE;
    //         for (int j=i; j<i+k; j++) {
    //             if (max < nums[j]) {
    //                 max = nums[j];
    //             }
    //         }
    //         res[i] = max;
    //     }
    //     return res;
    // }
}
