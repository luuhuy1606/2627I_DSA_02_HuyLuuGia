import java.io.*;
import java.util.*;

class Result {

    public static String isBalanced(String s) {
        if (s == null || (s.length() % 2 != 0)) {
            return "NO";
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(', '{', '[' -> stack.push(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return "NO";
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return "NO";
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return "NO";
                }
                default -> { }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class Balanced_Brackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();
            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}