import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 2 Part A and B
* Nathaniel Webber 10/11/22
*/

public class Day2A {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day2A.txt");
        Scanner inScanner = new Scanner(inFile);
        int finalTotal = 0;
        int finalRibbonTotal = 0;

        while (inScanner.hasNextLine()) {
            String[] values = inScanner.nextLine().split("x");
            finalTotal += calculateTotalArea(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                    Integer.parseInt(values[2]));
            finalRibbonTotal += calculateRibbonLength(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                    Integer.parseInt(values[2]));
        }

        System.out.printf("Final paper total: %d\nFinal ribbon total: %d\n", finalTotal, finalRibbonTotal);
        inScanner.close();
    }

    public static int calculateTotalArea(int l, int w, int h) {
        int lengthWidth = 2 * l * w;
        int smallest = lengthWidth / 2;
        int lengthHeight = 2 * l * h;
        if (lengthHeight / 2 < smallest)
            smallest = lengthHeight / 2;
        int widthHeight = 2 * w * h;
        if (widthHeight / 2 < smallest)
            smallest = widthHeight / 2;

        return smallest + lengthWidth + lengthHeight + widthHeight;
    }

    public static int calculateRibbonLength(int l, int w, int h) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(l);
        nums.add(w);
        nums.add(h);
        Collections.sort(nums);
        return (2 * nums.get(0)) + (2 * nums.get(1)) + (l * w * h);
    }
}