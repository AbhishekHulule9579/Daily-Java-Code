import java.util.Queue;
import java.util.Stack;
//deleting first inserted element in stack
public class QueueUsingStack {
    static Stack<Integer> stack1=new Stack<>();
    static Stack<Integer>stack2=new Stack<>();

    static void enQueue(int data){
        stack1.push(data);
    }
    static int deQueue(){
        int ele;
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("Stack is empty");
            System.exit(0);
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                ele=stack1.pop();
                stack2.push(ele);
            }
        }
        ele=stack2.pop();
        return ele;
    }

    public static void main(String[] args) {
        QueueUsingStack q=new QueueUsingStack();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        System.out.println(q.deQueue());
    }
}