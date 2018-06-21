import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    public static boolean containsRansomWords(String[] magazineItems, String[] ransomItems) {
        if (ransomItems.length > magazineItems.length)
            return false;

        HashMap<String, Integer> magazineMap = new HashMap<>();
        HashMap<String, Integer> ransomMap = new HashMap<>();

        for (String word : magazineItems) {
            Integer value = magazineMap.get(word);

            if (value == null)
                magazineMap.put(word, 1);
            else
                magazineMap.put(word, value + 1);
        }

        for (String word : ransomItems) {
            Integer value = magazineMap.get(word);

            if (value == null || magazineMap.get(word) == 0)
                return false;
            else
                magazineMap.put(word, value - 1);
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        if (containsRansomWords(magazineItems, ransomItems)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}
