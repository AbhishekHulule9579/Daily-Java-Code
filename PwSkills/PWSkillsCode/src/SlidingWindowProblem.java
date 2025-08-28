import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowProblem {
    private static int[] slidingWindow(int[] arr,int k){
        int n=arr.length;
        int[] r=new int[n-k+1];
        int ri=0;
        Deque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while (!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }
            while (!q.isEmpty() && arr[q.peek()]<arr[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                r[ri++]=arr[q.peek()];
            }
        }
        return r;
    }
    public static void main(String[] args) {
        int[] arr={4,5,7,10,85,25,1,99};
        int k=3;
        int n=8;
        int res[]=new int[n-k+1];
        res=slidingWindow(arr,k);
        System.out.println("Desired Output is ");
        for(int i=0;i<n-k+1;i++){
            System.out.println(res[i]);
        }
    }
}
