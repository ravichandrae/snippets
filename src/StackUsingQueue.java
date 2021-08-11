import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String []args) {
        QStack<Integer> stack = new QStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
    }

    /**
     * Implements a Stack using a single queue 
     * It makes use of add, remove, size methods of queue interface
     * @param <T>: Type of elements stored in the stack
     */
    static class QStack<T> {
        private final Queue<T> queue;

        public QStack() {
            queue = new LinkedList<T>();
        }

        /**
         * Push the element onto stack
         * Time complexity O(n)
         * @param element: element to be pushed
         */
        public void push(T element) {
            int currentQueueSize = queue.size();
            queue.add(element);
            while(currentQueueSize-- > 0) {
                queue.add(queue.remove());
            }
        }

        /**
         * remove and return the element on the top of the stack
         * @return top element
         * Time complexity O(1)
         */
        public T pop() {
            return queue.remove();
        }
    }
}
