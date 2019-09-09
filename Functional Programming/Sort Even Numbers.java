import java.util.*;
import java.util.stream.Collectors;

public class sortEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> evenNums = Arrays.stream(scanner.nextLine().split(", ")).
                map(Integer::parseInt).
                filter(x -> x % 2 == 0).
                collect(Collectors.toList());
        List<String> numbers = evenNums.
                stream().
                map(String::valueOf).
                collect(Collectors.toList());


        String even = String.join(", ", numbers);

        System.out.println(even);

        evenNums.sort(Integer::compareTo);
        List<String> evenSorted = evenNums.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String evenFinal = String.join(", ", evenSorted);
        System.out.println(evenFinal);
    }
}
