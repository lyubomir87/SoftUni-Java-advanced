import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countOfRows = sc.nextInt();
        sc.nextLine();

        String[][] matrix = readMatrix(sc, countOfRows);
        String[] input = sc.nextLine().split("\\s+");
        Map<String, Integer> resultMap = new LinkedHashMap<>() {{
            put("C", 0);
            put("P", 0);
            put("L", 0);
            put("Harmed vegetables", 0);
        }};
        while (!input[0].equals("End")) {
            String command = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            String direction = "";
            switch (command) {

                case "Harvest":
                    harvest(matrix, row, col, resultMap);
                    break;

                case "Mole":
                    direction = input[3];
                    mole(row, col, matrix, direction, resultMap);
                    break;
            }
            input = sc.nextLine().split("\\s+");
        }

        printMatrix(matrix);
        printResultMap(resultMap);
    }

    private static void printResultMap(Map<String, Integer> resultMap) {
        for (Map.Entry<String, Integer> kvp : resultMap.entrySet()) {
            switch (kvp.getKey()) {
                case "C":
                    System.out.printf("Carrots: %d%n", kvp.getValue());
                    break;
                case "P":
                    System.out.printf("Potatoes: %d%n", kvp.getValue());
                    break;
                case "L":
                    System.out.printf("Lettuce: %d%n", kvp.getValue());
                    break;
                default:
                    System.out.printf("Harmed vegetables: %d%n", kvp.getValue());
                    break;
            }
        }
    }

    private static void mole(int row, int col, String[][] matrix, String direction, Map<String, Integer> resultMap) {
        boolean validPosition = checkPosition(row, col, matrix);

        while (validPosition) {

            if (!matrix[row][col].equals(" ")) {
                resultMap.put("Harmed vegetables", resultMap.get("Harmed vegetables") + 1);
                matrix[row][col] = " ";
            }
            switch (direction) {

                case "up":
                    row -= 2;
                    break;
                case "left":
                    col -= 2;
                    break;

                case "down":
                    row += 2;
                    break;

                case "right":
                    col += 2;
                    break;
            }
            validPosition = checkPosition(row, col, matrix);
        }

    }


    private static void harvest(String[][] matrix, int row, int col, Map<String, Integer> resultMap) {
        boolean validPosition = checkPosition(row, col, matrix);
        if (validPosition) {
            if (!matrix[row][col].equals(" ")) {
                String vegetable = matrix[row][col];
                resultMap.put(vegetable, resultMap.get(vegetable) + 1);
                matrix[row][col] = " ";
            }
        }
    }

    private static boolean checkPosition(int row, int col, String[][] matrix) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static String[][] readMatrix(Scanner sc, int countOfRows) {
        String[][] matrix = new String[countOfRows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = sc.nextLine().split("\\s");
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
