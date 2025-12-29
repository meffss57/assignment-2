import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/alfiya/Desktop/assignment1/src/source");

        Scanner sc = new Scanner(file);


        sc.useDelimiter("[,\\s]+");
    }
}