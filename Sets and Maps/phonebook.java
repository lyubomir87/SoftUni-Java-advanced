import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> nameAndContact = new LinkedHashMap<>();
        while (!"search".equals(input)) {
            String[] data = input.split("-");
            String name = data[0];
            String phoneNum = data[1];
            nameAndContact.put(name, phoneNum);


            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!"stop".equals(input2)) {
            if (!nameAndContact.containsKey(input2)) {
                System.out.printf("Contact %s does not exist.\n", input2);
            } else {
                for (Map.Entry<String, String> entry : nameAndContact.entrySet()) {
                    if (entry.getKey().equals(input2)) {
                        System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
                    }
                }
            }

            input2 = scanner.nextLine();
        }
    }
}
