import java.util.Scanner;

public class Problem_2785 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String s=sc.next();

        String result=solution(s);
        System.out.println(result);
    }
    public static String solution(String s){
        String vowels="AEIOUaeiou";
        int freq[]=new int[128];
        for(char c:s.toCharArray()){
            if(vowels.indexOf(c)!=-1){
                freq[c]+=1;
            }
        }
        StringBuilder sortedVowels=new StringBuilder();
        for(int ascii=0;ascii<128;ascii++){
            while(freq[ascii]>0){
                sortedVowels.append((char)ascii);
                freq[ascii]-=1;
            }
        }
        StringBuilder result=new StringBuilder();
        int index=0;
        for(char c:s.toCharArray()){
            if(vowels.indexOf(c)!=-1){
                result.append(sortedVowels.charAt(index));
                index +=1;
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }
}
