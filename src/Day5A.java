import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 5 Part A and B
* Nathaniel Webber 10/12/22
*/

public class Day5A {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Template.txt");
        Scanner inScanner = new Scanner(inFile);
        System.out.println(inScanner.nextLine());
        inScanner.close();
    }

    private boolean stringIsNice(String s){
        char[] charArr = s.toCharArray();
        int vowelCount = 0;
        String[] forbiddenStrings = {"ab", "cd", "pq", "xy"};
        boolean foundDouble = false;
        for (int i = 0; i < charArr.length; i++){
            
        }

    }
}