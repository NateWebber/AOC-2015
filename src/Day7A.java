import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 7 Part A and B
* Nathaniel Webber xx/xx/22
*/

public class Day7A {
    static HashMap<String, Integer> wireMap;

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day7A.txt");
        Scanner inScanner = new Scanner(inFile);
        wireMap = new HashMap<>();
        while (inScanner.hasNextLine()) {
            parseInstruction(inScanner.nextLine());
        }
        System.out.printf("Signal on wire a is: %d\n", wireMap.get("a"));
        inScanner.close();
    }

    private static void parseInstruction(String line) {
        System.out.printf("parsing %s\n", line);
        String[] splitArr = line.split(" ");
        if (splitArr[0].equals("NOT"))
            notOp(splitArr[1], splitArr[3]);
        else {
            switch (splitArr[1]) {
                case "->":
                    assignOp(splitArr[0], splitArr[2]);
                    break;
                case "AND":
                    andOp(splitArr[0], splitArr[2], splitArr[4]);
                    break;
                case "OR":
                    orOp(splitArr[0], splitArr[2], splitArr[4]);
                    break;
                case "LSHIFT":
                    leftShiftOp(splitArr[0], splitArr[2], splitArr[4]);
                    break;
                case "RSHIFT":
                    rightShiftOp(splitArr[0], splitArr[2], splitArr[4]);
                default:
                    System.out.printf("instruction parse of %s failed...\n", line);
            }
        }
    }

    private static void notOp(String source, String destination) {
        wireMap.put(destination, ~(wireMap.get(source)));
    }

    private static void assignOp(String value, String destination) {
        wireMap.put(destination, Integer.parseInt(value));
    }

    private static void andOp(String source1, String source2, String destination) {
        wireMap.put(destination, (wireMap.get(source1) & wireMap.get(source2)));
    }

    private static void orOp(String source1, String source2, String destination) {
        wireMap.put(destination, (wireMap.get(source1) | wireMap.get(source2)));

    }

    private static void leftShiftOp(String source1, String source2, String destination) {
        wireMap.put(destination, (wireMap.get(source1) << wireMap.get(source2)));

    }

    private static void rightShiftOp(String source1, String source2, String destination) {
        wireMap.put(destination, (wireMap.get(source1) >> wireMap.get(source2)));

    }
}