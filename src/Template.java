import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Template {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Template.txt");
        Scanner inScanner = new Scanner(inFile);
        System.out.println(inScanner.nextLine());
        inScanner.close();
    }
}