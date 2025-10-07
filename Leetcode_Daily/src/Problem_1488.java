import java.util.*;

public class Problem_1488 {

    static class Solution {
        public int[] avoidFlood(int[] rains) {

            int n = rains.length;
            int ans[] = new int[n];
            Arrays.fill(ans, 1);
            HashMap<Integer, Integer> map = new HashMap<>();
            TreeSet<Integer> zero = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                if (rains[i] == 0) {
                    zero.add(i);
                } else {
                    if (map.containsKey(rains[i])) {
                        int prevOccur = map.get(rains[i]);
                        Integer possible = zero.ceiling(prevOccur);
                        if (possible == null)
                            return new int[0];
                        ans[possible] = rains[i];
                        zero.remove(possible);
                    }
                    ans[i] = -1;
                    map.put(rains[i], i);
                }
            }

            for (int idx : zero) {
                ans[idx] = 1;
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of days:");
        int n = sc.nextInt();
        int[] rains = new int[n];

        System.out.println("Enter rains array (0 for dry day, lake number otherwise):");
        for (int i = 0; i < n; i++) {
            rains[i] = sc.nextInt();
        }

        Solution solver = new Solution();
        int[] result = solver.avoidFlood(rains);

        if (result.length == 0) {
            System.out.println("[]  (Flood cannot be avoided)");
        } else {
            System.out.println("Output array:");
            System.out.println(Arrays.toString(result));
        }
    }
}
