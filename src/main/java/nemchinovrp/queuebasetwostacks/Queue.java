package nemchinovrp.queuebasetwostacks;

import java.util.Stack;

public class Queue {
    private Stack<Integer> s1 = new Stack();
    private Stack<Integer> s2 = new Stack();

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue.get());
        System.out.println(queue.get());
    }


    public void put(Integer i) {
        s1.push(i);
    }

    public Integer get() {
        Integer result;
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        result = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return result;
    }
}