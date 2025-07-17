import java.util.*;

public class ClothShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Cloth available");
        int n = sc.nextInt();
        int[] clothsize = new int[n];
        System.out.println("Enter Size of cloth available");
        for (int i = 0; i < n; i++) {
            clothsize[i] = sc.nextInt();
        }

        System.out.println("Enter number of total customer visited");
        int cus = sc.nextInt();
        int[][] request = new int[cus][2];
        System.out.println("Enter customer request (Size and price)");
        for (int i = 0; i < cus; i++) {
            request[i][0] = sc.nextInt();
            request[i][1] = sc.nextInt();
        }

        List<Integer> available = new ArrayList<>();
        for (int size : clothsize) {
            available.add(size);
        }

        int total = 0;
        for (int i = 0; i < cus; i++) {
            int reqSize = request[i][0];
            int price = request[i][1];
            int idx = available.indexOf(reqSize);
            if (idx != -1) {
                total += price;
                available.remove(idx);
            }
        }

        System.out.println("Total price for available cloths: " + total);
    }
}
