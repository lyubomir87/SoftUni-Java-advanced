import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");
        UnaryOperator<Double> vat = d -> 1.2 * d;
        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(vat)
                .forEach(d ->
                        System.out.printf("%.2f\n", d));
    }
}
