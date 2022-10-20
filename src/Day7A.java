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
    static boolean doPartTwo = true;
    static HashMap<String, Wire> wireMap;
    static int PART_ONE_SIGNAL = 46065;

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
        if (doPartTwo) {
            wireMap.get("b").setSource(String.valueOf(PART_ONE_SIGNAL));
        }
        System.out.printf("Signal on wire a: %d\n", evaluateWire(wireMap.get("a"), 0));
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

    private static int evaluateWire(Wire w, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print(" ");
        System.out.printf("DEPTH %d: evaluating %s - %s\n", depth, w.getSymbol(), w.getSource());
        if (w.getSource().matches("\\d+")) { // cheeky regex to see if string is an int
            // System.out.printf("int regex fired\n");
            return Integer.parseInt(w.getSource());
        }
        String[] sourceSplit = w.getSource().split(" ");
        if (sourceSplit.length == 1) { // direct assignment from other wire
            w.setSource(String.valueOf(evaluateWire(wireMap.get(sourceSplit[0]), depth + 1)));
            return Integer.parseInt(w.getSource());
        }
        if (sourceSplit[0].equals("NOT")) {
            w.setSource(String.valueOf(~(evaluateWire(wireMap.get(sourceSplit[1]), depth + 1))));
            return Integer.parseInt(w.getSource());
        }
        switch (sourceSplit[1]) {
            case "LSHIFT":
                w.setSource(String.valueOf(
                        evaluateWire(wireMap.get(sourceSplit[0]), depth + 1) << Integer.parseInt(sourceSplit[2])));
                return Integer.parseInt(w.getSource());
            case "RSHIFT":
                w.setSource(String.valueOf(
                        evaluateWire(wireMap.get(sourceSplit[0]), depth + 1) >> Integer.parseInt(sourceSplit[2])));
                return Integer.parseInt(w.getSource());
            case "AND":
                if (sourceSplit[0].matches("\\d+")) {
                    w.setSource(String.valueOf(
                            Integer.parseInt(sourceSplit[0]) & evaluateWire(wireMap.get(sourceSplit[2]), depth + 1)));
                    return Integer.parseInt(w.getSource());
                }
                w.setSource(String.valueOf(evaluateWire(wireMap.get(sourceSplit[0]), depth + 1)
                        & evaluateWire(wireMap.get(sourceSplit[2]), depth + 1)));
                return Integer.parseInt(w.getSource());
            case "OR":
                w.setSource(String.valueOf(evaluateWire(wireMap.get(sourceSplit[0]), depth + 1)
                        | evaluateWire(wireMap.get(sourceSplit[2]), depth + 1)));
                return Integer.parseInt(w.getSource());
            default:
                System.out.printf("broke on wire %s, source %s\nresults likely incorrect...\n", w.getSymbol(),
                        w.getSource());
                return 0;
        }

    }

}