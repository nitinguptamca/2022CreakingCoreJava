package com.interviewQ.hard.fibonacci;

public class Fibonacci_app2 {
    static int fib(int n) {
        System.out.println("Math.sqrt(5) "+ Math.sqrt(5));

        double phi = (1 + Math.sqrt(5)) / 2;

        System.out.println("  math power  "+Math.round(Math.pow(phi, n)));

        return (int) Math.round(Math.pow(phi, n)/ Math.sqrt(5));
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
    }
}
