import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class minerTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> resourseQuant = new LinkedHashMap<>();
        while (!"stop".equals(input)) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourseQuant.containsKey(resource)) {
                resourseQuant.put(resource, quantity);
            } else {
                int res = resourseQuant.get(resource) + quantity;
                resourseQuant.put(resource, res);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourseQuant.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
