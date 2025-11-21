package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CodeForces2172E {
    public static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        StringBuilder current = new StringBuilder();
        backtrack(s, used, current, result);
        return result;
    }

    private static void backtrack(String s, boolean[] used,
                                  StringBuilder current, List<String> result) {

        if (current.length() == s.length()) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(s.charAt(i));

                backtrack(s, used, current, result);

                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int number = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            List<String> = permute(Integer.toString(number));
        }
    }
}
