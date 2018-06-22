import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> costMap = new HashMap<>();

        for (int i = 0; i < cost.length; i++){
            int complement = money - cost[i];

            if (complement >= money){
                continue;
            }

            if (costMap.containsKey(complement)){
                printPair(costMap.get(complement), i + 1);
            }

            costMap.put(cost[i], i + 1);
        }
    }

    static void printPair(int cost1, int cost2){
        if (cost1 < cost2){
            System.out.println(String.format("%d %d", cost1, cost2));
        } else{
            System.out.println(String.format("%d %d", cost2, cost1));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
