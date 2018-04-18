package com.androidians.sample;

public class CamelCase {

    public static void main(String[] args) {
        System.out.println(camelCase("nithinWarrierIsACoolPerson"));
    }

    public static int camelCase(String str) {
        StringBuilder builder = new StringBuilder(str);
        int count = 1;
        for (int i=0; i<builder.length(); i++) {
            int ch = builder.charAt(i);
            if (ch >= 65 && ch<= 90) {
                count++;
            }
        }

        return count;
    }

}
