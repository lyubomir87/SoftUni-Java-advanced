import java.util.*;

public class socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(leftSocks::push);

        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(rightSocks::offer);

        List<Integer> pairs = new ArrayList<>();
        while (!leftSocks.isEmpty() && !rightSocks.isEmpty()) {
            int leftSock = leftSocks.peek();
            int rightSock = rightSocks.peek();

            if (leftSock > rightSock) {
                int pairSock=leftSock+rightSock;
                pairs.add(pairSock);
                leftSocks.pop();
                rightSocks.poll();
            } else if (rightSock > leftSock) {
                leftSocks.pop();
            } else {
                rightSocks.poll();
                leftSock++;
                leftSocks.pop();
                leftSocks.push(leftSock);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer pair : pairs) {
            if (pair > max) {
                max = pair;
            }
        }
        System.out.println(max);
        for (Integer pair : pairs) {
            System.out.print(pair + " ");
        }
    }
}
