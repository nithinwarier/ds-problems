package com.androidians.sample;

public class IsPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i=3;i<=sqrt;i=i+2) {
            if (n%i==0) {
                return false;
            }
        }

        return true;
    }
}
