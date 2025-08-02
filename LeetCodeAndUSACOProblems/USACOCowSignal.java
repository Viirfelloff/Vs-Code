package LeetCodeAndUSACOProblems;

import java.util.*;

public class USACOCowSignal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<String> modified = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();

            char last = s.charAt(0);
            int count = 1;

            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == last) {
                    count++;
                } else {
                    sb.append(String.valueOf(last).repeat(count * k));
                    last = s.charAt(j);
                    count = 1;
                }
            }
            sb.append(String.valueOf(last).repeat(count * k));
            for (int v = 0; v < k; v++) {
                modified.add(sb.toString());
            }
        }
        for (String g : modified) {
            System.out.println(g);
        }
    }
}
