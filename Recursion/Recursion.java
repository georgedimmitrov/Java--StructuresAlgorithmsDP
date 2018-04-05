package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class Recursion {
    // Note: a TreeMap is used to store the fibonacci numbers that have already been calculated,
    // also a BigInteger is used to avoid loss of precision.
    static Map<Integer, BigInteger> memo = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        // Factorial demo
//        BufferedReader inKb = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter a number: ");
//        int num = Integer.parseInt(inKb.readLine());
//        System.out.println("Factorial is: " + factorial(num));

        // Fibonacci Simple demo
//        BufferedReader inKb = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter a number: ");
//        int num = 0;
//        int fibNum = 0;
//        num = Integer.parseInt(inKb.readLine());
//        fibNum = fibonacci(num);
//        System.out.println("The fibonacci value of " + num + "th element is: " + fibNum);


        // Fibonacci Memoized Demo
        BufferedReader inKb = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int num = 0;
        BigInteger fibNum = BigInteger.valueOf(0);
        num = Integer.parseInt(inKb.readLine());
        fibNum = fibonacciMemoized(num);
        System.out.println("The memoized fibonacci value of " + num + "th element is: " + fibNum);




    }

    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Note: a TreeMap is used to store the fibonacci numbers that have already been calculated,
    // also a BigInteger is used to avoid loss of precision.
    public static BigInteger fibonacciMemoized(int n) {
        if (n < 2) {
            return BigInteger.ONE;
        }

        if (memo.get(n) == null) {
            // if the element is not in the TreeMap -> calculate it and add it
            memo.put(n, fibonacciMemoized(n - 1).add(fibonacciMemoized(n - 2)));
        }

        return memo.get(n);
    }

}
