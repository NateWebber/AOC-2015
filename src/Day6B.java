import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 6 Part B
* Nathaniel Webber 10/13/22
*/

public class Day6B {
    static int[][] grid;

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day6A.txt");
        Scanner inScanner = new Scanner(inFile);

        grid = new int[1000][1000];
        int finalCount = 0;

        while (inScanner.hasNextLine())
            parseInstruction(inScanner.nextLine());

        for (int[] column : grid)
            for (int x : column)
                finalCount += x;
        System.out.printf("%d lights are on\n", finalCount);
        inScanner.close();
    }

    private static void parseInstruction(String line) {
        String[] splitArr = line.split(" ");
        if (line.startsWith("turn on")) {
            String firstCoordsString = splitArr[2];
            String secondCoordsString = splitArr[4];
            String[] firstCoordsArr = firstCoordsString.split(",");
            String[] secondCoordsArr = secondCoordsString.split(",");
            turnOn(Integer.parseInt(firstCoordsArr[0]), Integer.parseInt(firstCoordsArr[1]),
                    Integer.parseInt(secondCoordsArr[0]), Integer.parseInt(secondCoordsArr[1]));
        } else if (line.startsWith("turn off")) {
            String firstCoordsString = splitArr[2];
            String secondCoordsString = splitArr[4];
            String[] firstCoordsArr = firstCoordsString.split(",");
            String[] secondCoordsArr = secondCoordsString.split(",");
            turnOff(Integer.parseInt(firstCoordsArr[0]), Integer.parseInt(firstCoordsArr[1]),
                    Integer.parseInt(secondCoordsArr[0]), Integer.parseInt(secondCoordsArr[1]));
        } else {
            String firstCoordsString = splitArr[1];
            String secondCoordsString = splitArr[3];
            String[] firstCoordsArr = firstCoordsString.split(",");
            String[] secondCoordsArr = secondCoordsString.split(",");
            toggle(Integer.parseInt(firstCoordsArr[0]), Integer.parseInt(firstCoordsArr[1]),
                    Integer.parseInt(secondCoordsArr[0]), Integer.parseInt(secondCoordsArr[1]));
        }
    }

    private static void turnOn(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++)
            for (int y = startY; y <= endY; y++)
                grid[x][y] += 1;
    }

    private static void turnOff(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++)
            for (int y = startY; y <= endY; y++)
                if (grid[x][y] > 0)
                    grid[x][y]--;
    }

    private static void toggle(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++)
            for (int y = startY; y <= endY; y++)
                grid[x][y] += 2;
    }
}