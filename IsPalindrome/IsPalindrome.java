package com.androidians.sample;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("malayalam"));
    }

    public static boolean isPalindrome(String A) {
        if (A == null || A.length() == 0) {
            return false;
        }

        A = A.toUpperCase();
        int lastIndex = A.length() - 1, i;
        for (i=0; i<(A.length()/2); i++) {
            if (A.charAt(i) == A.charAt(lastIndex)) {
                lastIndex -= 1;
            } else {
                break;
            }
        }

        if (i == (A.length()/2)) {
            return true;
        } else {
            return false;
        }
    }
}
