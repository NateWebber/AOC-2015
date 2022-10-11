import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 3 Part A
* Nathaniel Webber 10/11/22
*/

public class Day3A {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day3A.txt");
        Scanner inScanner = new Scanner(inFile);
        inScanner.useDelimiter(""); // empty delimiter lets us pull char by char
        int[] currentCoords = { 0, 0 };
        HashMap<String, Integer> coordsToGifts = new HashMap<>();
        coordsToGifts.put("00", 1);
        while (inScanner.hasNext()) {
            char nextChar = inScanner.next().charAt(0);
            switch (nextChar) {
                case '^':
                    currentCoords[1]++;
                    break;
                case 'v':
                    currentCoords[1]--;
                    break;
                case '>':
                    currentCoords[0]++;
                    break;
                case '<':
                    currentCoords[0]--;
                    break;
            }
            String coordString = coordsToString(currentCoords);
            if (coordsToGifts.containsKey(coordString))
                coordsToGifts.put(coordString, coordsToGifts.get(coordString) + 1);
            else
                coordsToGifts.put(coordString, 1);
        }
        System.out.printf("Houses that received at least 1 present: %d\n", coordsToGifts.size());
        inScanner.close();
    }

    public static String coordsToString(int[] coords) {
        return Integer.toString(coords[0]) + "-" + Integer.toString(coords[1]);
    }
}