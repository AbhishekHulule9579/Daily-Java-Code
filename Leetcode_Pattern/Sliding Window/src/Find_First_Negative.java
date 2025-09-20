import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;


public class Find_First_Negative {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array:");
        int N=sc.nextInt();
        System.out.println("Enter Array element");
        long[] A=new long[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextLong();
        }

        System.out.println("Enter the window length 'k'");
        int k=sc.nextInt();

        long[] res=printfirstNegativeNum(A,N,k);
        System.out.println(Arrays.toString(res));
    }

    public static long[] printfirstNegativeNum(long[] A,int N,int K){
        Queue<Long>queue=new LinkedList<Long>();
        int index=0;
        while(index<K){
            if(A[index]<0){
                queue.offer(A[index]);
            }
            index++;
        }
        long res[]=new long[N-K+1];
        res[0]=(queue.isEmpty())?0:queue.peek();
        for(int i=1;i<N-K+1;i++){
            //remove previous element
            if(A[i-1]<0){
                queue.poll();
            }
            if(A[i+K-1]<0){
                queue.offer(A[i+K-1]);
            }
            res[i]=(queue.isEmpty())?0:queue.peek();
        }
        return res;
    }
}
/*
* Print first negative number in the list window of k
* */