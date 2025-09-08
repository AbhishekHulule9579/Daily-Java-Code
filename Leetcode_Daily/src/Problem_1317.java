import java.util.Scanner;
import java.util.Arrays;

public class Problem_1317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Sum number");
        int n = sc.nextInt();
        int[] result = getNoZeroIntegers(n);
        System.out.println("Two No-Zero Integers are: " + Arrays.toString(result));
    }

    public static int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; A++) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") && !String.valueOf(B).contains("0")) {
                return new int[]{A, B};
            }
        }
        return new int[]{};
    }
}
