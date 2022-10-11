import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 3 Part A
* Nathaniel Webber 10/11/22
*/

public class Day3B {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day3A.txt");
        Scanner inScanner = new Scanner(inFile);
        inScanner.useDelimiter(""); // empty delimiter lets us pull char by char
        int[] santaCoords = { 0, 0 };
        int[] roboSantaCoords = { 0, 0 };
        HashMap<String, Integer> coordsToGifts = new HashMap<>();
        coordsToGifts.put("0-0", 2);
        int counter = 0; // count instructions read, when odd santa moves, when even robo-santa moves
        while (inScanner.hasNext()) {
            counter++;
            char nextChar = inScanner.next().charAt(0);
            switch (nextChar) {
                case '^':
                    if (counter % 2 == 1)
                        santaCoords[1]++;
                    else
                        roboSantaCoords[1]++;
                    break;
                case 'v':
                    if (counter % 2 == 1)
                        santaCoords[1]--;
                    else
                        roboSantaCoords[1]--;
                    break;
                case '>':
                    if (counter % 2 == 1)
                        santaCoords[0]++;
                    else
                        roboSantaCoords[0]++;
                    break;
                case '<':
                    if (counter % 2 == 1)
                        santaCoords[0]--;
                    else
                        roboSantaCoords[0]--;
                    break;
            }
            String coordString = null;
            if (counter % 2 == 1)
                coordString = coordsToString(santaCoords); // odd then santa moved
            else
                coordString = coordsToString(roboSantaCoords); // even then robo-santa moved

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