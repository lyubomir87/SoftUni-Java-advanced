import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class countUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        Predicate<String> isCapital = word -> Character.isUpperCase(word.charAt(0));
        List<String> capitalWords = Arrays.stream(words)
                .filter(isCapital)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());

        for (String capitalWord : capitalWords) {
            System.out.println(capitalWord);
        }
    }
}
