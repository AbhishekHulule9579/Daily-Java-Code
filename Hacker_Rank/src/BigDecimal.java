import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        Arrays.sort(s,0,n,new Comparator<Object>() {
            public int compare(Object o1,Object o2){
                BigDecimal b1=new BigDecimal((String)o1);
                BigDecimal b2=new BigDecimal((String)o2);

                return b2.compareTo(b1);
            }
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}
/*input
* 9
-100
50
0
56.6
90
0.12
.12
02.34
000.000*/
//output
/*90
56.6
50
02.34
0.12
.12
0
000.000
-100*/