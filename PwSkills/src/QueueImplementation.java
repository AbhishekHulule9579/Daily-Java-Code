import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<10;i++){
            q.add(i);
        }
        System.out.println(q);
        q.remove();
        System.out.println(q.peek());
        System.out.println(q);
    }
}