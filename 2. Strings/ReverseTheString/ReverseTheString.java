package com.androidians.sample.strings;

public class ReverseTheString {

    public static void main(String[] args) {
        System.out.println(reverseTheString2("ankrqzzcel dyaiug y rkicv t"));
    }

    public static String reverseTheString(String a) {
        if (a == null || a.length() == 0) return a;
        String[] arr = a.split(" ");
        StringBuilder builder = new StringBuilder();

        if (arr != null) {
            for (int i=arr.length-1;i>=0;i--) {
                builder.append(arr[i]);
                if (i!=0)
                    builder.append(" ");
            }
        }

        return builder.toString();
    }

    public static String reverseTheString2(String a) {
        if (a == null || a.length() == 0 || a.indexOf(" ") == -1) return a;
        StringBuilder builder = new StringBuilder();

        int endIndex = a.length();
        int firstIndexSpace = a.indexOf(" ", 0);
        for (int i=a.length()-1;i>=0;i--) {
            if (a.charAt(i) == ' ') {
                builder.append(a.substring(i+1, endIndex)).append(" ");
                endIndex = i;
            }
        }
        builder.append(a.substring(0, firstIndexSpace));


        return builder.toString();
    }

}
