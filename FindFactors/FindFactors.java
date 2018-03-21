package com.androidians.interviewbitmath;

import java.util.ArrayList;

/**
 * Created by nithin on 21/03/18.
 */

public class FindFactors {

    public static void main(String[] args) {
        ArrayList<Integer> result = findFactorsInSortedOrder(7);
        for (Integer i: result) {
            System.out.println(i);
        }
    }

    private static ArrayList<Integer> findFactors(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);
        for (int i=1;i<=sqrt;i++) {
            if (n % i == 0) {
                result.add(i);
            }

            if (i != sqrt) {
                result.add(n / i);
            }
        }
        return result;
    }

    private static ArrayList<Integer> findFactorsInSortedOrder(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);
        for (int i=1;i<=sqrt;i++) {
            if (n % i == 0) {
                result.add(i-1, i);
            }

            if (i != sqrt) {
                result.add(i,n / i);
            }
        }
        return result;
    }
}
