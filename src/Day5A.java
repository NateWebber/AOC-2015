import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 5 Part A and B
* Nathaniel Webber 10/12/22
*/

public class Day5A {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day5A.txt");
        Scanner inScanner = new Scanner(inFile);
        int niceCountA = 0;
        int niceCountB = 0;
        while (inScanner.hasNextLine()) {
            String s = inScanner.nextLine();
            if (stringIsNiceA(s))
                niceCountA++;
            if (stringIsNiceB(s))
                niceCountB++;
        }
        System.out.printf("Part A nice strings: %d\n", niceCountA);
        System.out.printf("Part B nice strings: %d\n", niceCountB);
        inScanner.close();
    }

    private static boolean stringIsNiceA(String s) {
        char[] charArr = s.toCharArray();
        int vowelCount = 0;
        boolean foundDouble = false;
        for (int i = 0; i < charArr.length; i++) {
            if (!foundDouble && i >= 1)
                if (charArr[i] == charArr[i - 1])
                    foundDouble = true;
            if (i > 0) {
                switch (charArr[i]) {
                    case 'b':
                        if (charArr[i - 1] == 'a')
                            return false;
                        break;
                    case 'd':
                        if (charArr[i - 1] == 'c')
                            return false;
                        break;
                    case 'q':
                        if (charArr[i - 1] == 'p')
                            return false;
                        break;
                    case 'y':
                        if (charArr[i - 1] == 'x')
                            return false;
                        break;
                    default:
                        break;
                }
            }
            switch (charArr[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCount++;
                    break;
                default:
                    break;
            }
        }
        return (foundDouble && (vowelCount >= 3));
    }

    private static boolean stringIsNiceB(String s) {
        boolean trioFound = false;
        boolean pairFound = false;
        System.out.printf("%s\n", s);
        for (int i = 0; i < (s.length() - 2); i++) {
            String trio = s.substring(i, i + 3);
            // System.out.printf("%s\n", trio);
            if (trio.charAt(0) == trio.charAt(2)) {
                trioFound = true;
                break;
            }
        }
        ArrayList<String> pairs = new ArrayList<>();
        for (int i = 0; i < (s.length() - 1); i++) {
            String pair = s.substring(i, i + 2);
            System.out.printf("%d : %s\n", i, pair);
            if (pairs.contains(pair)) {
                if (!(pair.charAt(0) == pair.charAt(1))) {
                    pairFound = true;

                } else {
                    if (i == 0) {
                        if (!(pair.charAt(1) == s.charAt(i + 2))) {
                            pairFound = true;

                        }
                    } else if (i == (s.length() - 2)) {
                        if (!(pair.charAt(0) == s.charAt(i - 1))) {
                            pairFound = true;

                        }
                    } else {
                        if (!(pair.charAt(0) == s.charAt(i - 1)) && !(pair.charAt(1) == s.charAt(i +
                                2))) {
                            pairFound = true;

                        }
                    }
                }
            }
            pairs.add(pair);
        }
        System.out.printf("trio: %s - pair: %s\n", trioFound, pairFound);
        return trioFound && pairFound;
    }
}
