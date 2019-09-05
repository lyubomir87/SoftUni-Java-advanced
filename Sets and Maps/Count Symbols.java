import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class countSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbols = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (!symbols.containsKey((a))) {

                symbols.put(a, 1);
            } else {
                int res = symbols.get(a) + 1;
                symbols.put(a, res);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
