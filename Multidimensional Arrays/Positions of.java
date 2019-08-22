import java.util.Arrays;
import java.util.Scanner;

public class positions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = data;
        }
        int searchingNum = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == searchingNum) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
