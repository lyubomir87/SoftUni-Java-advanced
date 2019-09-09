import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).
                        collect(Collectors.toList());

        System.out.printf("Count = %d\n", nums.size());
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        System.out.printf("Sum = %d", sum);
    }
}
