import java.io.*;


public class sumLines {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\Lyubo\\Desktop\\test\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File[] files = new File(path).listFiles();
        int size = 0;
        for (File file : files) {
            size += file.length();
        }

        System.out.printf("Folder size: %d", size);
    }
}
