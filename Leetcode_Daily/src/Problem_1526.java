import java.util.*;

public class Problem_1526 {

    public int minNumberOperations(int[] target) {
        int count = 0;
        int prev = 0;
        for (int num : target) {
            if (num > prev) {
                count += num - prev;
            }
            prev = num;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] target = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }

        Problem_1526 obj = new Problem_1526();
        int result = obj.minNumberOperations(target);
        System.out.println("Minimum number of operations: " + result);

        sc.close();
    }
}
