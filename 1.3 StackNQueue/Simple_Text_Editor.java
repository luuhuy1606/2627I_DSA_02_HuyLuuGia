import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Simple_Text_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        if (firstLine == null) return;

        int q = Integer.parseInt(firstLine.trim());

        StringBuilder text = new StringBuilder();
        Deque<String> history = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String line = reader.readLine();
            if (line == null) break;

            StringTokenizer tokenizer = new StringTokenizer(line);
            int type = Integer.parseInt(tokenizer.nextToken());

            switch (type) {
                case 1 -> {
                    history.push(text.toString());
                    String w = tokenizer.nextToken();
                    text.append(w);
                }
                case 2 -> {
                    history.push(text.toString());
                    int k = Integer.parseInt(tokenizer.nextToken());
                    text.delete(text.length() - k, text.length());
                }
                case 3 -> {
                    int k = Integer.parseInt(tokenizer.nextToken());
                    output.append(text.charAt(k - 1)).append('\n');
                }
                case 4 -> {
                    if (!history.isEmpty()) {
                        text = new StringBuilder(history.pop());
                    }
                }
            }
        }

        System.out.print(output);
    }
}