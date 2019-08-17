import java.util.ArrayDeque;
import java.util.Scanner;

public class decimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        int num = Integer.parseInt(scanner.nextLine());
        String res = Integer.toBinaryString(num);
        stack.push(res);
        System.out.println(stack.pop());
    }
}
