import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//deleting last element which is inserted first
public class QueueToStackLIFO {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    static void add(int data){
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.poll();
        }
        q1.add(data);

        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.poll();
        }
    }
    static int remove(){
        if(q1.isEmpty()){
            System.out.println("Stack underflow");
            System.exit(0);
        }

        int ele = q1.peek();
        q1.poll();
        return ele;

    }
    public static void main(String[] args) {
        QueueToStackLIFO s = new QueueToStackLIFO();

        s.add(2);
        s.add(5);
        s.add(7);
        s.add(10);

        System.out.println("Deleted element is: "+s.remove());
        System.out.println("Deleted element is: "+s.remove());
    }
}
