import java.util.Scanner;

public class Problem_2749 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter num 1");
        int num1=sc.nextInt();
        System.out.println("Enter num 2");
        int num2=sc.nextInt();

        int result=makeTheIntegerZero(num1,num2);
        System.out.println(result);
    }
    public static int makeTheIntegerZero(int num1,int num2){
        for(int k=1;k<=60;k++){
            long diff=(long)num1-(long)k*num2;
            if(diff<=0){
                continue;
            }
            int bits=Long.bitCount(diff);
            if(bits<=k && diff>=k){
                return k;
            }
        }
        return -1;
    }
}

/* Problem 2749
--------------------Minimum Operations to Make the Integer Zero---------------------

You are given two integers num1 and num2.

In one operation, you can choose integer i in the range [0, 60] and subtract 2i + num2 from num1.

Return the integer denoting the minimum number of operations needed to make num1 equal to 0.

If it is impossible to make num1 equal to 0, return -1.



Example 1:

Input: num1 = 3, num2 = -2
Output: 3
Explanation: We can make 3 equal to 0 with the following operations:
- We choose i = 2 and subtract 22 + (-2) from 3, 3 - (4 + (-2)) = 1.
- We choose i = 2 and subtract 22 + (-2) from 1, 1 - (4 + (-2)) = -1.
- We choose i = 0 and subtract 20 + (-2) from -1, (-1) - (1 + (-2)) = 0.
It can be proven, that 3 is the minimum number of operations that we need to perform.*/
