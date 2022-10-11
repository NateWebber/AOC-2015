import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 1 Part A and B
* Nathaniel Webber 10/11/22
*/

public class Day1A {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day1A.txt");
        Scanner inScanner = new Scanner(inFile);
        String inLine = inScanner.nextLine();

        int currentFloor = 0;
        int basementPosition = 0;
        boolean enteredBasement = false;
        for (int i = 0; i < inLine.length(); i++) {
            if (inLine.charAt(i) == '(')
                currentFloor++;
            else
                currentFloor--;
            if (currentFloor < 0 && !enteredBasement) {
                basementPosition = i + 1;
                enteredBasement = true;
            }
        }
        System.out.printf("Final floor: %d - Position of first basement entry: %d\n", currentFloor, basementPosition);
        inScanner.close();
    }
}