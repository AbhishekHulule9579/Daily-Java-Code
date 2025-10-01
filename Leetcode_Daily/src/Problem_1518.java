import java.util.Scanner;

public class Problem_1518 {

        public static int numWaterBottles(int numBottles, int numExchange) {
            int result=numBottles;
            int emptyWB=numBottles;

            while(emptyWB>=numExchange){
                int newWB=emptyWB/numExchange;
                result +=newWB;
                emptyWB=newWB;
                emptyWB=newWB+(emptyWB % numExchange);
            }
            return result;
        }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numBottles=sc.nextInt();

        int numExchange=sc.nextInt();

        int result=numWaterBottles(numBottles,numExchange);

        System.out.println(result);
    }
}
