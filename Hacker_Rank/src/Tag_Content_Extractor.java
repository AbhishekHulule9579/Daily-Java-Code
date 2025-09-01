import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tag_Content_Extractor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        while(testCases>0){
            String line = sc.nextLine();

            Pattern p=Pattern.compile("<(.+)>([^<]+)</\\1>");

            Matcher m=p.matcher(line);
            Boolean found=false;
            while(m.find()){
                System.out.println(m.group(2));
                found=true;
            }
            if(!found){
                System.out.println("None");
            }
            testCases--;
        }
    }
}
//Tag_Content_Extractor
//Input
/*4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>*/
//output
/*Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush*/