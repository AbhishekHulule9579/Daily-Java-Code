import java.util.*;

public class Problem_1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");

        int brokenWords = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (brokenLetters.indexOf(c) != -1) {
                    brokenWords += 1;
                    break;
                }
            }
        }
        return words.length - brokenWords;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String brokenLetters = sc.nextLine();

        Problem_1935 obj = new Problem_1935();
        int result = obj.canBeTypedWords(text, brokenLetters);

        System.out.println(result);

        sc.close();
    }
}
/*
* Leetcode Problem 1935
* Maximum Number of Words You Can Type
 * */