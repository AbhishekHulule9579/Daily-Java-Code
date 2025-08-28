import java.util.ArrayDeque;
import java.util.Deque;

public class DequeImp {
    public static void main(String[] args) {
        Deque<Integer>deque=new ArrayDeque<>();
        deque.addLast(5);
        deque.addLast(7);
        deque.addLast(9);
        System.out.println("deque will look like "+deque);
        deque.removeLast();
        System.out.println("Deque will look like "+deque);
    }
}
