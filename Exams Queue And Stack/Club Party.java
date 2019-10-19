import java.util.*;

public class clubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> input = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s")).forEach(input::push);

        ArrayDeque<String> halls = new ArrayDeque<>();
        List<Integer> currentHallPopulation = new ArrayList<>();


        while (!input.isEmpty()) {
            String currentElement = input.pop();

            if (Character.isLetter(currentElement.charAt(0))) {
                halls.offer(currentElement);
            } else {
                int numberOfPeople = Integer.parseInt(currentElement);
                int count = 0;
                for (Integer integer : currentHallPopulation) {
                    count += integer;
                }
                if (count + numberOfPeople <= capacity && !halls.isEmpty()) {
                    currentHallPopulation.add(numberOfPeople);
                } else {
                    printHalls(halls, currentHallPopulation);
                    if (!halls.isEmpty()) {
                        currentHallPopulation.add(numberOfPeople);
                    }
                }
            }
        }
        System.out.println();
    }

    private static void printHalls(ArrayDeque<String> halls, List<Integer> currentHallPopulation) {
        if (!halls.isEmpty()) {
            System.out.printf("%s -> ", halls.poll());
            System.out.println(String.join(", ", currentHallPopulation.toString().substring(1, currentHallPopulation.toString().length() - 1)));
            currentHallPopulation.removeAll(currentHallPopulation);
        }
    }
}
