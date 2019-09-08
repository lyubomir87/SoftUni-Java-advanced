import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class sumLines {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\Lyubo\\Desktop\\test\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";

        String text = Files.readString(Path.of(path)).replaceAll("\r\n", " ");
        int[] countData = new int[3];
        String vowels = "aeiou";
        String punctuation = "!,.?";
        for (char symbol : text.toCharArray()) {
            if (vowels.contains(symbol + "")) {
                countData[0]++;
            } else if (punctuation.contains(symbol + "")) {
                countData[2]++;
            } else if (symbol != ' ') {
                countData[1]++;
            }
        }
        PrintWriter printer = new PrintWriter("Output.txt");
        printer.printf("Vowels: %d\n" +
                "Consonants: %d\n" +
                "Punctuation: %d\n", countData[0], countData[1], countData[2]);

        printer.close();
    }
}
