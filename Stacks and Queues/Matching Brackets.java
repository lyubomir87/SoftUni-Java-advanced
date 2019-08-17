import java.util.ArrayDeque;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);

            if (a == '(') {
                stack.push(i);

            } else if (a == ')') {


                String contents = input.substring(stack.pop(), i + 1);
                System.out.println(contents);
            }
        }
    }
}


