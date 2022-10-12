import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
* Advent of Code 2015 Day 4 Part A and B
* Nathaniel Webber 10/12/22
*/

public class Day4A {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input_key = "iwrupvqb";
        MessageDigest md5 = MessageDigest.getInstance("md5");
        int five_num = 0;
        int six_num = 0;
        int index = 0;
        boolean five_found = false;
        boolean six_found = false;
        while (!(five_found && six_found)) {
            //if (index % 5000 == 0)
                //System.out.printf("index = %d, five_found: %s, six_found: %s, still searching...\n", index, five_found, six_found);
            byte[] bytes = String.format("%s%d", input_key, index++).getBytes();
            byte[] digest = md5.digest(bytes);
            String digest_string = "";
            for (byte b : digest)
                digest_string += (String.format("%02x", b & 0xff));
            //if (index % 5000 == 0)
                //System.out.printf("digest_string: %s\n", digest_string);
            if (digest_string.startsWith("00000") && !five_found) {
                five_found = true;
                five_num = index;
                //System.out.printf("found five_num as: %d\n", five_num);
            }
            if (digest_string.startsWith("000000") && !six_found) {
                six_found = true;
                six_num = index;
                //System.out.printf("found six_num as: %d\n", six_num);
            }
        }

        System.out.printf("Lowest number for 5 zeroes: %d\nLowest number for 6 zeros: %d\n", five_num--, six_num--);

    }
}