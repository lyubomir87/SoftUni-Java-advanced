import java.util.*;
import java.util.stream.Collectors;

public class basic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands = scanner.nextLine().split("\\s+");
        List<String> asd = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int remove1 = Integer.parseInt(commands[1]);
        int compare = Integer.parseInt(commands[2]);
        for (int i = 0; i < remove1; i++) {

            asd.remove(asd.size() - 1);

        }
        for (String s : asd) {
            stack.push(Integer.parseInt(s));
        }
        if (stack.contains(compare)) {

                System.out.println("true");



        } else {
            if (stack.size() != 0) {
                int smallest = stack.pop();
                for (Integer integer : stack) {
                    if (integer <= smallest) {
                        smallest = integer;
                    }
                }
                System.out.println(smallest);
            } else {
                System.out.println(stack.size());
            }


        }

    }
}
