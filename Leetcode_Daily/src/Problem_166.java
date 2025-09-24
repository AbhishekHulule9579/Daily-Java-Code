import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        num = num % den;

        if (num == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());

        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;

            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }

        return result.toString();
    }
}

public class Problem_166 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("1/2 = " + sol.fractionToDecimal(1, 2));    // "0.5"
        System.out.println("2/1 = " + sol.fractionToDecimal(2, 1));    // "2"
        System.out.println("2/3 = " + sol.fractionToDecimal(2, 3));    // "0.(6)"
        System.out.println("4/333 = " + sol.fractionToDecimal(4, 333)); // "0.(012)"
        System.out.println("-50/8 = " + sol.fractionToDecimal(-50, 8)); // "-6.25"
        System.out.println("7/-12 = " + sol.fractionToDecimal(7, -12)); // "-0.58(3)"
    }
}
