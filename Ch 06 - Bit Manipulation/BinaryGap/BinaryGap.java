package com.androidians.sample.codility;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(binaryGap(529));
    }

    // find the number of zeroes in the binary version
    static int binaryGap(int N) {
        int current = 0;
        int max = 0;

        while (N > 0) {
            if (N % 2 == 0)
                ++current;
            else {
                max = Math.max(max, current);
                current = 0;
            }
            N /= 2;
        }
        return max;
    }

}
