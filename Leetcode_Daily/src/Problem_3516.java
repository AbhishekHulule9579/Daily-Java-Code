import java.util.Scanner;

public class Problem_3516 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter x");
        int x=sc.nextInt();
        System.out.println("Enter y");
        int y= sc.nextInt();
        System.out.println("Enter z");
        int z=sc.nextInt();

        int result=nearest(x,y,z);
        System.out.println(result);
    }
    public static int nearest(int x,int y,int z){
        int xstep=Math.abs(z-x);
        int ystep=Math.abs(z-y);
        if(xstep==ystep){
            return 0;
        }
        if(xstep<ystep){
            return 1;
        }
        return 2;

    }
}
/*3516. Find Closest Person
You are given three integers x, y, and z, representing the positions of three people on a number line:

x is the position of Person 1.
y is the position of Person 2.
z is the position of Person 3, who does not move.
Both Person 1 and Person 2 move toward Person 3 at the same speed.

Determine which person reaches Person 3 first:

Return 1 if Person 1 arrives first.
Return 2 if Person 2 arrives first.
Return 0 if both arrive at the same time.
Return the result accordingly.



Example 1:

Input: x = 2, y = 7, z = 4

Output: 1

Explanation:

Person 1 is at position 2 and can reach Person 3 (at position 4) in 2 steps.
Person 2 is at position 7 and can reach Person 3 in 3 steps.
Since Person 1 reaches Person 3 first, the output is 1.*/