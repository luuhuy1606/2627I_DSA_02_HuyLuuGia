import java.util.Scanner;

public class Counting_Sort_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        int[] frequency = new int[100];
        for (int i = 0; i < n; i++) {
            frequency[scanner.nextInt()]++;
        }
        
        for (int i = 0; i < 100; i++) {
            System.out.print(frequency[i] + (i < 99 ? " " : ""));
        }
        System.out.println();
        
        scanner.close();
    }
}