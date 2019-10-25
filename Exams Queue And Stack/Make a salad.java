import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class salad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vegetablesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vegetablesQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(calories::push);

        while (!vegetablesQueue.isEmpty() && !calories.isEmpty()) {
            int calorie = calories.peek();

            while (calorie > 0 && !vegetablesQueue.isEmpty()) {
                String vegetable = vegetablesQueue.poll();

                switch (vegetable) {
                    case "tomato":
                        calorie -= 80;
                        break;

                    case "carrot":
                        calorie -= 136;
                        break;

                    case "lettuce":
                        calorie -= 109;
                        break;

                    case "potato":
                        calorie -= 215;
                        break;
                }

            }
            System.out.print(calories.pop() + " ");
        }
        System.out.println();
        if (!vegetablesQueue.isEmpty()) {
            vegetablesQueue.forEach(e -> System.out.print(e + " "));
        }
        if (!calories.isEmpty()) {
            calories.forEach(e -> System.out.print(e + " "));
        }
    }
}
