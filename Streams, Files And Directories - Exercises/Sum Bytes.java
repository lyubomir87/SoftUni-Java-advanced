import java.io.*;


public class sumLines {
    public static void main(String[] args) {


        String path = "C:\\Users\\Lyubo\\Desktop\\test\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";
        long asciiSum = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null) {


                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }

                line = reader.readLine();
            }
            System.out.println(asciiSum);
        } catch (IOException ex) {

        }

    }
}
