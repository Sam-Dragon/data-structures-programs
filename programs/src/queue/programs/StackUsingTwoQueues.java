package queue.programs;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    Queue<Integer> firstQueue = new LinkedList<>();
    Queue<Integer> secondQueue = new LinkedList<>();

    public void push(int value) {
        if (firstQueue.isEmpty())
            firstQueue.add(value);
        else {
            while (!firstQueue.isEmpty())
                secondQueue.add(firstQueue.poll());

            firstQueue.add(value);

            while (!secondQueue.isEmpty())
                firstQueue.add(secondQueue.poll());
        }
    }

    public Integer pop() {
        if (firstQueue.isEmpty()) return null;

        return firstQueue.remove();
    }

    public Integer top() {
        if (firstQueue.isEmpty()) return null;

        return firstQueue.peek();
    }

    public void display() {
        System.out.println(firstQueue);
    }

    static void main() {
        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
        stackUsingTwoQueues.push(10);
        stackUsingTwoQueues.push(20);
        stackUsingTwoQueues.push(30);
        stackUsingTwoQueues.display();
        System.out.println(stackUsingTwoQueues.top());
        int removed = stackUsingTwoQueues.pop();
        System.out.println(removed);

        stackUsingTwoQueues.display();
        System.out.println(stackUsingTwoQueues.top());
    }
}
