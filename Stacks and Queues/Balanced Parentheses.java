import java.util.ArrayDeque;
import java.util.Scanner;

public class balanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean balanced = true;
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);

            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            } else {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;


                }
                char equals = stack.pop();
                if (a == ')' && equals != '(') {
                    balanced = false;
                    break;
                } else if (a == '}' && equals != '{') {
                    balanced = false;
                    break;
                } else if (a == ']' && equals != '[') {
                    balanced = false;
                    break;
                }
            }
        }

        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
