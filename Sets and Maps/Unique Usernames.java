import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class uniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> persons = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String names = scanner.nextLine();
            persons.add(names);
        }
        for (String person : persons) {
            System.out.println(person);
        }
    }
}
