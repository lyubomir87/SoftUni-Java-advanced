import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class trojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWaves = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> platesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> warriorsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(platesQueue::offer);

        for (int i = 1; i <= numberOfWaves && !platesQueue.isEmpty(); i++) {
            Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(warriorsStack::push);

            if (i % 3 == 0) {
                int newPlate = Integer.parseInt(scanner.nextLine());
                platesQueue.offer(newPlate);
            }

            while (!platesQueue.isEmpty() && !warriorsStack.isEmpty()) {
                int plate = platesQueue.poll();
                int warrior = warriorsStack.pop();

                if (warrior > plate) {
                    warrior -= plate;
                    warriorsStack.push(warrior);
                } else if (warrior < plate) {
                    plate -= warrior;
                    platesQueue.addFirst(plate);
                }

            }
        }
        if (platesQueue.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            String output = warriorsStack.stream().map(w -> String.format("%d", w)).collect(Collectors.joining(", "));
            System.out.printf("Warriors left: %s", output);
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            String output = platesQueue.stream().map(p -> String.format("%d", p)).collect(Collectors.joining(", "));
            System.out.printf("Plates left: %s", output);

        }
    }
}
