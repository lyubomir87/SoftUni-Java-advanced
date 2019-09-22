import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] robotsWithTime = reader.readLine().split(";");
        String[] robots = new String[robotsWithTime.length];
        int[] times = new int[robotsWithTime.length];
        int[] processTime = new int[robotsWithTime.length];
        int index = 0;
        for (String robot : robotsWithTime) {
            String[] data = robot.split("-");
            robots[index] = data[0];
            times[index] = Integer.parseInt(data[1]);
            index++;


        }
        String[] timeData = reader.readLine().split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);
        int beginSeconds = hours * 3600 + minutes * 60 + seconds;
        ArrayDeque<String> queue = new ArrayDeque<>();
        String line = reader.readLine();

        while (!"End".equals(line)) {
            queue.offer(line);

            line = reader.readLine();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            beginSeconds++;
            String product = queue.poll();
            for (int i = 0; i < processTime.length; i++) {
                if (processTime[i] > 0) {
                    processTime[i]--;
                }


            }

            boolean isTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0) {
                    processTime[i] = times[i];
                    stringBuilder.append(print(robots[i], product, beginSeconds));

                    isTaken = true;
                    break;
                }

            }
            if (!isTaken) {
                queue.offer(product);
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static String print(String robot, String product, long beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;

        return String.format("%s - %s [%02d:%02d:%02d]%n", robot, product, h, m, s);
    }
}
