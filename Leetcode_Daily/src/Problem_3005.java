import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_3005 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter array size");
        int n=sc.nextInt();

        System.out.println("Enter array element");
        int nums[]=new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int result=maxFrequencyElements(nums);
        System.out.println(result);
    }
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>();
        int maxFreq=0;

        for(int num:nums){
            int count=freq.getOrDefault(num,0)+1;
            freq.put(num,count);
            maxFreq=Math.max(maxFreq,count);
        }
        int result=0;
        for(int value:freq.values()){
            if(value==maxFreq){
                result +=value;
            }
        }
        return result;
    }
}
