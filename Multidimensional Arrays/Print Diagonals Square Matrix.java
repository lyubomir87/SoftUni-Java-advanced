import java.util.Arrays;
import java.util.Scanner;

public class diag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int row = 0;
        int col = 0;

        while (row < size && col < size) {
            int element = matrix[row][col];
            System.out.print(element + " ");


            row++;
            col++;
        }
        row = size - 1;
        col = 0;
        System.out.println();
        while (row >= 0 && col < size) {
            int element = matrix[row][col];
            System.out.print(element + " ");

            row--;
            col++;
        }
    }
}
