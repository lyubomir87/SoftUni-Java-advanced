import java.io.*;


public class sumLines {
    public static void main(String[] args) {


        String path = "C:\\Users\\Lyubo\\Desktop\\test\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null) {
                int asciiSum = 0;

                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }
                System.out.println(asciiSum);
                line = reader.readLine();
            }
        } catch (IOException ex) {

        }

    }
}
