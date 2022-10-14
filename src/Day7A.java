import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 7 Part A and B
* Nathaniel Webber xx/xx/22
*/

//b starts at 1674
public class Day7A {
    static HashMap<String, Wire> wireMap;

    private static class Wire {
        private String source;
        private String symbol;

        public Wire(String symbo, String source) {
            this.symbol = symbol;
        }

        public void setSource(String s) {
            this.source = s;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day7A.txt");
        Scanner inScanner = new Scanner(inFile);
        wireMap = new HashMap<String, Wire>();
        while (inScanner.hasNextLine()) {
            parseLineToWire(inScanner.nextLine());
        }
        inScanner.close();
    }

    private static void parseLineToWire(String line) {
        String[] splitArr = line.split("->");
        splitArr[0] = splitArr[0].substring(0, splitArr[0].length() - 1);
        splitArr[1] = splitArr[1].substring(1);
        System.out.printf("split line into %s,%s\n", splitArr[0], splitArr[1]);
        String wireName = splitArr[1];
        Wire newWire = new Wire(wireName, splitArr[0]);
        wireMap.put(wireName, newWire);
    }

    private int evaluateWire(Wire w) {
        return 0;
    }

}