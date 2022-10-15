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

        public Wire(String symbol, String source) {
            this.symbol = symbol;
            this.source = source;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public void setSource(String s) {
            this.source = s;
        }

        public String getSource() {
            return this.source;
        }

        public String toString() {
            return String.format("Symbol: %s - Source: %s\n", this.symbol, this.source);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day7A.txt");
        Scanner inScanner = new Scanner(inFile);
        wireMap = new HashMap<String, Wire>();
        while (inScanner.hasNextLine()) {
            parseLineToWire(inScanner.nextLine());
        }
        System.out.printf("Signal on wire a: %d\n", evaluateWire(wireMap.get("a")));
        inScanner.close();
    }

    private static void parseLineToWire(String line) {
        String[] splitArr = line.split("->");
        splitArr[0] = splitArr[0].substring(0, splitArr[0].length() - 1);
        splitArr[1] = splitArr[1].substring(1);
        // System.out.printf("split line into %s,%s\n", splitArr[0], splitArr[1]);
        String wireName = splitArr[1];
        Wire newWire = new Wire(wireName, splitArr[0]);
        wireMap.put(wireName, newWire);
    }

    private static int evaluateWire(Wire w) {
        System.out.printf("evaluating %s - %s\n", w.getSymbol(), w.getSource());
        if (w.getSource().matches("\\d+")) // cheeky regex to see if string is an int
            return Integer.parseInt(w.getSource());
        String[] sourceSplit = w.getSource().split(" ");
        if (sourceSplit.length == 1) // direct assignment from other wire
            return evaluateWire(wireMap.get(sourceSplit[0]));
        if (sourceSplit[0].equals("NOT"))
            return ~(evaluateWire(wireMap.get(sourceSplit[1])));
        switch (sourceSplit[1]) {
            case "LSHIFT":
                return evaluateWire(wireMap.get(sourceSplit[0])) << Integer.parseInt(sourceSplit[2]);
            case "RSHIFT":
                return evaluateWire(wireMap.get(sourceSplit[0])) >> Integer.parseInt(sourceSplit[2]);
            case "AND":
                if (sourceSplit[0].matches("\\d+"))
                    return Integer.parseInt(sourceSplit[0]) & evaluateWire(wireMap.get(sourceSplit[2]));
                return evaluateWire(wireMap.get(sourceSplit[0])) & evaluateWire(wireMap.get(sourceSplit[2]));
            case "OR":
                return evaluateWire(wireMap.get(sourceSplit[0])) | evaluateWire(wireMap.get(sourceSplit[2]));
            default:
                System.out.printf("broke on wire %s, source %s\nresults likely incorrect...\n", w.getSymbol(),
                        w.getSource());
                return 0;
        }

    }

}