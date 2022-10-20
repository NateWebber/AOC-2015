import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 8 Part A and B
* Nathaniel Webber 10/20/22
*/

public class Day8A {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day8A.txt");
        Scanner inScanner = new Scanner(inFile);
        int literalCharacters = 0;
        int memoryCharacters = 0;
        int encodedCharacters = 0;

        while (inScanner.hasNextLine()) {
            String line = inScanner.nextLine();
            literalCharacters += line.length();
            memoryCharacters += partAParse(line);
            encodedCharacters += partBParse(line);
        }

        System.out.printf("Part A: Literal Characters (%d) - Memory Characters (%d) = %d\n", literalCharacters,
                memoryCharacters, literalCharacters - memoryCharacters);

        System.out.printf("Part B: Encoded Characters (%d) - Literal Characters (%d) = %d\n", encodedCharacters,
                literalCharacters, encodedCharacters - literalCharacters);

        inScanner.close();
    }

    private static int partAParse(String line) {
        int sum = 0;
        for (int i = 1; i <= line.length() - 2; i++) { // start at the second character (first after quote), end at
            // second to last (last before quote)
            if (line.charAt(i) == '\\') {
                if (i == line.length() - 1)
                    continue;
                if (line.charAt(i + 1) == 'x') {
                    // hex parse
                    sum++;
                    i += 3;
                } else {
                    i++; // skip so it doesn't get counted again
                    sum++;
                }
            } else {
                sum++;
            }
        }
        return sum;
    }

    private static int partBParse(String line) {
        int sum = 6; // inherently account for the " on each end of the string
        for (int i = 1; i <= line.length() - 2; i++) {
            if (line.charAt(i) == '\\' || line.charAt(i) == '\"') {
                sum += 2; // character plus \ to escape it
            } else {
                sum++;
            }
        }
        return sum;
    }
}