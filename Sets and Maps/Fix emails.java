import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class fixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> personAndMail = new LinkedHashMap<>();
        while (!"stop".equals(input)) {
            String name = input;
            String email = scanner.nextLine();
            if (!email.contains("us")) {
                if (!email.contains("uk")) {
                    if (!email.contains("com")) {
                        personAndMail.put(name, email);
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : personAndMail.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}
