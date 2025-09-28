import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Java_HashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet<String> uniquePairs = new HashSet<>();
        for (int i = 0; i < t; i++) {
            // Normalize order of pairs to handle unordered pair equivalence if needed
            String a = pair_left[i];
            String b = pair_right[i];
            String pair = (a.compareTo(b) <= 0) ? (a + " " + b) : (b + " " + a);

            uniquePairs.add(pair);
            System.out.println(uniquePairs.size());
        }

    }
}