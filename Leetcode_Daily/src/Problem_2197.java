import java.util.*;

public class Problem_2197 {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int currentNum : nums) {
            stack.add(currentNum);

            while (stack.size() > 1) {
                int lastElement = stack.get(stack.size() - 1);
                int secondLastElement = stack.get(stack.size() - 2);

                int gcdValue = gcd(lastElement, secondLastElement);

                if (gcdValue == 1) {
                    break;
                }

                stack.remove(stack.size() - 1);

                int lcmValue = (int) ((long) lastElement * secondLastElement / gcdValue);
                stack.set(stack.size() - 1, lcmValue);
            }
        }
        return stack;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Problem_2197 solution = new Problem_2197();

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> result = solution.replaceNonCoprimes(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
