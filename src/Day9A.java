import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
* Advent of Code 2015 Day 9 Part A and B
* Nathaniel Webber 10/20/22
*/

public class Day9A {
    static ArrayList<Node> nodes;

    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./input/Day9A.txt");
        Scanner inScanner = new Scanner(inFile);
        nodes = new ArrayList<>();
        while (inScanner.hasNextLine())
            nodes.add(generateNode(inScanner.nextLine()));
        inScanner.close();
    }

    private static class Node {
        String name;
        HashMap<String, Integer> destinations;
        boolean visited;

        public Node(String n) {
            this.name = n;
            this.destinations = new HashMap<>();
            this.visited = false;
        }

        public void reset() {
            this.visited = false;
        }

        public void addDestination(String dest, int distance) {
            this.destinations.put(dest, distance);
        }

    }

    private static Node generateNode(ArrayList<String> line) {
        return null;
    }
}
