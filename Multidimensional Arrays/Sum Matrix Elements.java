import java.util.Arrays;
import java.util.Scanner;

public class sumMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] coordinates = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(coordinates[0]);
        int cols = Integer.parseInt(coordinates[1]);

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
