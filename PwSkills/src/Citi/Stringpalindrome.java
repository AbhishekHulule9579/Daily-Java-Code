package Citi;

public class Stringpalindrome {
    public boolean ispalindrome(String str){
        String CleanedStr=str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left=0;
        int right=CleanedStr.length()-1;
        while(left<right){
            if(CleanedStr.charAt(left)!=CleanedStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str="madam";
        Stringpalindrome pali=new Stringpalindrome();
        System.out.println(str+" is Palindrome: "+pali.ispalindrome(str));
    }
}
