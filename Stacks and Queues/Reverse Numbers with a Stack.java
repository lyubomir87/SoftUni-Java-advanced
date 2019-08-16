import java.util.ArrayDeque;
import java.util.Scanner;

public class reverseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }
        for (String s : stack) {
            System.out.print(s + " ");
        }
    }
}
