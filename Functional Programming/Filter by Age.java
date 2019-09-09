import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;


public class FilterAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan = (person, ages) -> person.getValue() < ages;
        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan = (person, ages) -> person.getValue() >= ages;
        Consumer<Map.Entry<String, Integer>> printName = person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = person -> System.out.printf("%s - %d\n", person.getKey(), person.getValue());
        Map<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] personData = scanner.nextLine().split(", ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            people.put(name, age);

        }
        String compare = scanner.nextLine();
        int ages = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        people.entrySet().stream()
                .filter(person ->
                        compare.equals("younger") ?
                                youngerThan.test(person, ages) :
                                olderThan.test(person, ages)
                ).forEach(person -> {
                    if (printType.equals("age")) {
                        printAge.accept(person);
                    } else if (printType.equals("name")) {
                        printName.accept(person);
                    } else {
                        printNameAndAge.accept(person);
                    }
                }
        );
    }
}
