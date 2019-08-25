import java.util.Arrays;
import java.util.Scanner;

public class fillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(", ");
        int size = Integer.parseInt(inputData[0]);
        String pattern = inputData[1];

        int[][] matrix = new int[size][size];
        int value = 1;
        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {

                    matrix[row][col] = value;
                    value++;
                }
            }
        } else {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {

                        matrix[row][col] = value;
                        value++;
                    }
                } else {
                    for (int row1 = matrix.length - 1; row1 >= 0; row1--) {
                        matrix[row1][col] = value;
                        value++;
                    }
                }

            }
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints).replaceAll("\\[|\\]|,", ""));
        }

    }
}
