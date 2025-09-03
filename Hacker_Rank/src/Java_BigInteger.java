import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Java_BigInteger {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        BigInteger num1 = sc.nextBigInteger();
        BigInteger num2 = sc.nextBigInteger();

        sc.close();

        System.out.println(num1.add(num2));

        System.out.println(num1.multiply(num2));
    }
}