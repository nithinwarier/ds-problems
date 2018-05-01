package com.androidians.sample.codility;

public class OddOccurence {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,2}));
        System.out.println(solution(new int[]{9,3,3,9,3}));
    }

    // to find duplicate, to find odd occurence -
    // we use XOR operator (no need to sort the array)
    static int solution(int[] A) {
        int res = 0;
        for (int i=0; i<A.length; i++) {
            res ^= A[i];
        }

        return res;
    }

    // XOR TABLE
    // 0  0  - 0
    // 1  1  - 0
    // 0  1  - 1
    // 1  0  - 1

}
