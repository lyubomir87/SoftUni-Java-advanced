import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Predicate<Integer> shouldPrint = num -> {
            boolean isPrintable = true;

            for (int element : sequence) {
                if (num % element != 0) {
                    isPrintable = false;
                    break;
                }
            }
            return isPrintable;
        };


        for (int i = 1; i <= n; i++) {
            if (shouldPrint.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
