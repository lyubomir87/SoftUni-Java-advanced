import java.util.*;
import java.util.stream.Collectors;

public class queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands = scanner.nextLine().split("\\s+");
        List<String> nums = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int remove1 = Integer.parseInt(commands[1]);
        int compare = Integer.parseInt(commands[2]);
        for (int i = 0; i < remove1; i++) {

            nums.remove(0);

        }
        for (String s : nums) {
            queue.offer(Integer.parseInt(s));
        }
        if (queue.contains(compare)) {

            System.out.println("true");


        } else {
            if (queue.size() != 0) {
                int smallest = queue.poll();
                for (Integer integer : queue) {
                    if (integer <= smallest) {
                        smallest = integer;
                    }
                }
                System.out.println(smallest);
            } else {
                System.out.println(queue.size());
            }


        }

    }
}
