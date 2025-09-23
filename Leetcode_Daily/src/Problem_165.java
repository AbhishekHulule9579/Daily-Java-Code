public class Problem_165 {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int v1len = version1.length();
        int v2len = version2.length();
        int n1, n2;

        while (i < v1len || j < v2len) {
            n1 = 0;
            n2 = 0;

            while (i < v1len && version1.charAt(i) != '.') {
                n1 = n1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            while (j < v2len && version2.charAt(j) != '.') {
                n2 = n2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (n1 < n2) {
                return -1;
            } else if (n1 > n2) {
                return 1;
            }

            i++;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Problem_165 solution = new Problem_165();

        String version1_1 = "1.01";
        String version2_1 = "1.001";
        System.out.println("Result for \"" + version1_1 + "\" vs \"" + version2_1 + "\": " + solution.compareVersion(version1_1, version2_1));

        String version1_2 = "1.0";
        String version2_2 = "1.0.0";
        System.out.println("Result for \"" + version1_2 + "\" vs \"" + version2_2 + "\": " + solution.compareVersion(version1_2, version2_2));

        String version1_3 = "0.1";
        String version2_3 = "1.1";
        System.out.println("Result for \"" + version1_3 + "\" vs \"" + version2_3 + "\": " + solution.compareVersion(version1_3, version2_3));
    }
}