package com.androidians.interviewarraymath;

import java.util.ArrayList;

/**
 * Created by nithin on 11/03/18.
 */

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println("maxSubArrayN3: "+maxSubArrayN3(new int[]{1,2,3,4,5}));
        System.out.println("maxSubArrayN2: "+maxSubArrayN2(new int[]{1,2,3,4,5}));
        System.out.println("maxSubArrayN: "+maxSubArrayN(new int[]{-2,-3}));
    }

    // time complexity - O(n)
    private static int maxSubArrayN(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0;i<arr.length-1;i++) {
            sum +=  arr[i];
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    // time complexity - O(n2)
    private static int maxSubArrayN2(int[] arr) {
        int maxSum = 0;
        int sum;
        for (int i=0;i<arr.length;i++) {
            sum = 0;
            for (int j=i;j<arr.length-1;j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    // time complexity - O(n3)
    private static int maxSubArrayN3(int[] arr) {
        int maxSum = 0;
        int tempSum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0;i<arr.length;i++) {
            for (int j=i; j<arr.length; j++) {
                tempSum = 0;

                for (int k=i; k<j;k++) {
                    tempSum += arr[k];
                    if (tempSum > maxSum) {
                        result.add(arr[k]);
                        maxSum = tempSum;
                    }
                }
            }
        }

        // to get the sub array elements
        for (int i=0;i<result.size();i++) {
            System.out.print("\t"+result.get(i));
        }

        return maxSum;
    }
}
