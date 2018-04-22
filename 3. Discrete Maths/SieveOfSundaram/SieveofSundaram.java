package com.androidians.sample;

public class SieveofSundaram {

    public static void main(String[] args) {
        sieveOfSundaram(20);
    }

    public static void sieveOfSundaram(int n) {
        int nNew = (n-2)/2;
        boolean[] marked = new boolean[nNew + 1];

        for (int i=1;i<=nNew;i++) {
            for (int j=i; i+j+2*i*j<=nNew; j++) {
                marked[i+j+2*i*j] = true;
            }
        }

        if (n > 2) {
            System.out.print(2 + " ");
        }

        for (int i=1;i<=nNew;i++) {
            if (!marked[i]) {
                System.out.print(2 * i + 1 + " ");
            }
        }
    }
}
