import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Advent of Code 2015 Day X Part A and B
* Nathaniel Webber xx/xx/22
*/

public class Template {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Template.txt");
        Scanner inScanner = new Scanner(inFile);
        System.out.println(inScanner.nextLine());
        inScanner.close();
    }
}