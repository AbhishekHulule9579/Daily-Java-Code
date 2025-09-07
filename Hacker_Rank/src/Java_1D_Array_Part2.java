import java.util.*;
public class Java_1D_Array_Part2 {
    public static boolean canWin(int leap, int[] game) {
        return canWinRec(leap, game, 0);
    }

    private static boolean canWinRec(int leap, int[] game, int i) {

        if (i >= game.length) return true;

        if (i < 0 || game[i] != 0) return false;

        game[i] = 1;

        return canWinRec(leap, game, i + leap) ||
                canWinRec(leap, game, i + 1) ||
                canWinRec(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
