package com.hewie.test;

import java.util.Arrays;

public class OrderArray {
//    private static int[] orderArray(int[] arrayOld){
//        if(arrayOld == null || arrayOld.length < 2){
//            return arrayOld;
//        }
//        int startIndex = 0;
//        int endIndex = arrayOld.length -1;
//        while (startIndex < endIndex){
//            //奇数
//            while ((arrayOld[startIndex] & 0x1) == 1){
//                startIndex ++;
//            }
//            while ((arrayOld[endIndex] & 0x1) == 0){
//                endIndex --;
//            }
//            int temp = arrayOld[startIndex];
//            arrayOld[startIndex++] = arrayOld[endIndex];
//            arrayOld[endIndex--] = temp;
//        }
//        return arrayOld;
//    }

    public static int[] sortArrayByParity(int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums,(m,n) -> Integer.compare(m%2, n%2));
        for (int j = 0; j < nums.length; j++) {
            nums[j] = newNums[j];
        }
        return nums;
    }

    public static int[] sortArrayByParity1(int[] A) {
    //        Integer[] B = new Integer[A.length];
    //        for (int t = 0; t < A.length; ++t){
    //            B[t] = A[t];
    //        }
    //        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));
    //
    //        for (int t = 0; t < A.length; ++t){
    //            A[t] = B[t];
    //        }
    //        return A;
        return Arrays.stream(A).boxed().sorted((m,n) -> Integer.compare(m%2,n%2)).mapToInt(ele -> ele).toArray();
            /* Alternative:
            return Arrays.stream(A)
                         .boxed()
                         .sorted((a, b) -> Integer.compare(a%2, b%2))
                         .mapToInt(i -> i)
                         .toArray();
            */
    }

    public static void main(String[] args) {
//        int[] newArray = {7,9,2,4,6,10};
//        System.out.println(Arrays.toString(sortArrayByParity(newArray)));
        int[] arra = {3,2,2,3};
        System.out.println(removeElement(arra,3));
    }

    public static int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }
}
