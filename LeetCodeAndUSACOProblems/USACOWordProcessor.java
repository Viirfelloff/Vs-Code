package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class USACOWordProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<String> lines = new ArrayList<>();
        int currentLength = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (currentLength + s.length() <= k) {
                currentLength += s.length();
                lines.add(s);
            } else {
                currentLength = s.length();
                lines.add("New");
                lines.add(s);
            }
        }
        for (String x : lines) {
            if (x.equals("New")) {
                System.out.println();
            } else {
                System.out.println(x + " ");
            }
        }
    }
}
