import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Java_List {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List <Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int q=sc.nextInt();
        for(int i=0;i<q;i++){
            String op=sc.next();
            int index=sc.nextInt();
            if(op.equals("Insert")){
                int data =sc.nextInt();
                list.add(index,data);
            }
            else{
                list.remove(index);
            }
        }
        for(int item:list){
            System.out.print(item+" ");
        }

    }
}