import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RecursiveStaircase {
  // https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem

    static int stepPerms(int steps) {
        if (steps < 0)
            return 0;
        // Only count what you need to count using memoization
        return countSteps(steps, new int[steps + 1]);
    }

    static int countSteps(int steps, int[] stepsRemaining) {
        if (steps < 0)
            return 0;
        else if (steps == 0)
            return 1;

        if (stepsRemaining[steps] == 0)
            stepsRemaining[steps] = countSteps(steps - 1, stepsRemaining)
                + countSteps(steps - 2, stepsRemaining) + countSteps(steps - 3, stepsRemaining);

        return stepsRemaining[steps];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
