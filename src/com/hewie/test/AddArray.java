package com.hewie.test;

/**
 * 题目：输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 思路:求连续数字之和,当和为负值,抛弃.当和为正值,比较其与最大值,如大于,则替换之
 */
public class AddArray {
    /**
     * @param args
     */
    public static void main(String[] args) {
//        AddArray f = new AddArray();
//        int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
//        System.out.println("MaxSum:" + f.findMaxSum(arr));
//        System.out.println(maxSubArray(arr));
//        System.out.println(test1("aaa"));

    }
    private static int  test1(String s){
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + (s.charAt(num) -'0');
        }
        return num;
    }

    public Integer findMaxSum(int[] arr) {
        int curSum = 0;
        int maxSum = 0;
        int len = arr.length;

        if (arr == null || len == 0) {
            return null;
        }

        for (int i = 0; i < len; i++) {
            curSum += arr[i];
            if (curSum < 0) {
                curSum = 0;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        // all data are negative
        if (maxSum == 0) {
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    maxSum = arr[i];
                }
                if (arr[i] > maxSum) {
                    maxSum = arr[i];
                }
            }
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
