import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Two_Stacks{

    // Queue implementation using two Stacks
    static class MyQueue<T> {
        private final Deque<T> stackIn = new ArrayDeque<>();
        private final Deque<T> stackOut = new ArrayDeque<>();

        // Enqueue: push element to stackIn
        public void enqueue(T value) {
            stackIn.push(value);
        }

        // Shift elements from stackIn to stackOut when stackOut is empty
        private void shiftStacks() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

        // Dequeue: pop element from stackOut
        public T dequeue() {
            shiftStacks();
            return stackOut.pop();
        }

        // Peek: retrieve head of queue from stackOut
        public T peek() {
            shiftStacks();
            return stackOut.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null) return;

        int q = Integer.parseInt(line.trim());
        MyQueue<Integer> queue = new MyQueue<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(tokenizer.nextToken());

            switch (type) {
                case 1 -> {
                    int x = Integer.parseInt(tokenizer.nextToken());
                    queue.enqueue(x);
                }
                case 2 -> queue.dequeue();
                case 3 -> output.append(queue.peek()).append('\n');
            }
        }

        System.out.print(output);
    }
}