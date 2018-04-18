package com.androidians.sample;

public class RegexSamples {

    public static void main(String[] args) {
        regexForEmail();
    }

    private static void regexForNumbers() {
        String pattern = "^[0-9.]+$";
        String input = "123123213123.";
        if (input.matches(pattern)) {
            System.out.println("Input matches regex");
        } else {
            System.out.println("Input Fails regex");
        }
    }

    private static void regexForAlphabets() {
        String pattern = "^[A-z]+$";
        String input = "Asdfsdfsdfsdssdfsdfefeqofjgqevnlksdlkssadjkvsdkjljkhdasjk";
        if (input.matches(pattern)) {
            System.out.println("Input matches regex");
        } else {
            System.out.println("Input Fails regex");
        }
    }

    private static void regexMin6Char() {
        String pattern = "^[A-z0-9]{6,}+$";
        String input = "Asdf123";
        if (input.matches(pattern)) {
            System.out.println("Input matches regex");
        } else {
            System.out.println("Input Fails regex");
        }
    }

    // email address which can have underscore(_) or dot(.) can have in the email address
    private static void regexForEmail() {
        String pattern = "^([a-zA-Z0-9]+_?\\.?[a-zA-Z0-9]+)[@][A-Za-z]+[\\.].*";
        String input = "nit+warier@gmail.com";
        if (input.matches(pattern)) {
            System.out.println("Input matches regex");
        } else {
            System.out.println("Input Fails regex");
        }
    }

    private static void regexLast4Digits() {
        String pattern = ".*[^\\d]\\d{4}$";
        String input = "werewerg1234";
        if (input.matches(pattern)) {
            System.out.println("Input matches regex");
        } else {
            System.out.println("Input Fails regex");
        }
    }
}
