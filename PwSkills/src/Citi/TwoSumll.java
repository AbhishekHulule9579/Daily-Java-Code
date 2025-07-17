package Citi;

import java.util.Scanner;

public class TwoSumll {
    public static int[] findtwosum(int[]arr,int target){
        if(arr==null || arr.length<0){
            return new int[0];
        }
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            } else if (sum<target) {
                left++;
            }
            else{
                right--;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={2,7,10,18,27};
        int target=9;
        int[] result=findtwosum(arr,target);
        if(result.length>0){
            System.out.println("Numbers: [2, 7, 10, 18,27], Target: 9 -> Indices: ["+result[0]+","+result[1]+"]");
        }
        else {
            System.out.println("No Solution Found");
        }
    }
}
