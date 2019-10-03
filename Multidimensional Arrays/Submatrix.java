import java.util.Arrays;
import java.util.Scanner;

public class sub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int maxValue = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int current = matrix[r][c];
                int right = matrix[r][c + 1];
                int down = matrix[r + 1][c];
                int downRight = matrix[r + 1][c + 1];

                int sum = current + right + down + downRight;
                if (sum > maxValue) {
                    maxValue = sum;
                    maxMatrix[0][0] = current;
                    maxMatrix[0][1] = right;
                    maxMatrix[1][0] = down;
                    maxMatrix[1][1] = downRight;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxValue);
    }
}
