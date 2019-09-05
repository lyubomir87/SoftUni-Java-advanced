import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class setsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        Set<String> nElements = new LinkedHashSet<>();
        Set<String> mElements = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String numsN = scanner.nextLine();
            nElements.add(numsN);
        }

        for (int i = 0; i < m; i++) {
            String numsM = scanner.nextLine();
            mElements.add(numsM);
        }
        Set<String> equals = new LinkedHashSet<>();
        for (String nElement : nElements) {
            for (String mElement : mElements) {
                if (nElement.equals(mElement)) {
                    equals.add(nElement);
                }
            }
        }

        for (String equal : equals) {
            System.out.print(equal + " ");
        }
    }
}
