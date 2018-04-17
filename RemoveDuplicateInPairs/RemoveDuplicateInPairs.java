package com.androidians.sample;

public class RemoveDuplicateInPairs {

    public static void main(String[] args) {
        removeDuplicateInPairs("aabccd");
    }

    public static void removeDuplicateInPairs(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);

        for (int i=1;i<stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i-1)) {
                stringBuilder.delete(i-1, i+1);
                i = 0;
            }
        }

        if(stringBuilder.length() == 0)
            System.out.println("Empty String");
        else
            System.out.println(stringBuilder);
    }

}
