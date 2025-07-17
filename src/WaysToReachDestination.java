import java.util.Scanner;

public class WaysToReachDestination {
    public static int countways(int n){
        if (n < 0) return 0;
        if (n == 0) return 1; 

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int i = 1; i <= n; i++) {
            ways[i] = 0;
            if (i - 1 >= 0) ways[i] += ways[i - 1];
            if (i - 2 >= 0) ways[i] += ways[i - 2];
            if (i - 3 >= 0) ways[i] += ways[i - 3];
        }
        return ways[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter destination :");
        int n = sc.nextInt();
        System.out.println("Number of ways to reach destination " + n + " is " + countways(n));
    }
}
