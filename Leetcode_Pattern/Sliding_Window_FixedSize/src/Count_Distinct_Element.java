import java.util.*;

public class Count_Distinct_Element {
    public static List<Integer> countDistinct(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (i >= k - 1) {
                result.add(freq.size());
                int toRemove = arr[i - (k - 1)];
                freq.put(toRemove, freq.get(toRemove) - 1);
                if (freq.get(toRemove) == 0) freq.remove(toRemove);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println("Distinct counts in each window: " + countDistinct(arr, k));

    }
}

//Count Distinct Elements in Each Window of Size K
