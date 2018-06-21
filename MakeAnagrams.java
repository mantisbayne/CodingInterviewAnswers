import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakeAnagrams {

    public static int makeAnagrams(String a, String b) {
        int[] letters = new int[26];
        int deletedLetters = 0;
        int aLength = a.length();
        int bLength = b.length();

        if (a == null || b == null)
            deletedLetters = 0;

        if (aLength == 0 || bLength == 0) {
            deletedLetters = 0;
        }

        // Add at the index representing that letter
        for (char letter : a.toCharArray()) {
            letters[letter - 'a']++;
        }

        for (char letter : b.toCharArray()) {
            letters[letter - 'a']--;
        }

        for (int letterIndex : letters) {
            deletedLetters += Math.abs(letterIndex);
        }

        return deletedLetters;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.print(makeAnagrams(a, b));
        scanner.close();
    }
}
