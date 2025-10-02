import java.util.Scanner;

public class Problem_3100 {
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int result=numBottles;
        int emptyWB=numBottles;

        while(emptyWB>=numExchange){
            emptyWB=emptyWB-numExchange;
            numExchange +=1;
            result +=1;
            emptyWB +=1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter numsBottle");
        int numBottles=sc.nextInt();
        System.out.println("Enter The numExchange");
        int numExchange=sc.nextInt();

        System.out.println(maxBottlesDrunk(numBottles,numExchange));
    }
}

