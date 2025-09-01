import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int[] arr:classes){
            int pass=arr[0];
            int total=arr[1];
            double diff=findDiff(pass,total);
            pq.offer(new double[]{diff,pass,total});
        }
        while(extraStudents>0){
            double arr[]=pq.poll();
            int pass=(int)arr[1]+1;
            int total=(int)arr[2]+1;
            double diff=findDiff(pass,total);
            pq.offer(new double[]{diff,pass,total});
            extraStudents--;
        }
        double totalPassRatio=0;
        while(!pq.isEmpty()){
            double arr[]=pq.poll();
            double pass=arr[1];
            double total=arr[2];
            totalPassRatio +=(pass/total);
        }

        return totalPassRatio/classes.length;
    }
    public double findDiff(int pass,int total){
        return ((double)(pass+1)/(total+1))-((double)pass/total);
    }
}

public class Problem_1792 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] classes = { {1,2}, {3,5}, {2,2}};
        int extraStudents = 2;
        double result = solution.maxAverageRatio(classes, extraStudents);
        System.out.printf("Maximum average pass ratio: %.5f\n", result);
    }
}
/*You are also given an integer extraStudents. There are another extraStudents brilliant students
that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of
 the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam
 divided by the total number of students of the class. The average pass ratio is the sum of pass
 ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers
within 10-5 of the actual answer will be accepted.



Example 1:

Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal
to (3/4 + 3/5 + 2/2) / 3 = 0.78333.*/