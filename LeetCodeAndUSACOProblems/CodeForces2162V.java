package LeetCodeAndUSACOProblems;

import java.util.*;

public class CodeForces2162V {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            String s = sc.next();
            String ress = "-1";
            List<String> res = new ArrayList<>();
            class DFS {
                void run(int i, StringBuilder cur) {
                    if (i == n) {
                        res.add(cur.toString());
                        return;
                    }

                    // option 1: skip s[i]
                    run(i + 1, cur);

                    // option 2: take s[i] if non-decreasing
                    if (cur.length() == 0 || s.charAt(i) >= cur.charAt(cur.length() - 1)) {
                        cur.append(s.charAt(i));
                        run(i + 1, cur);
                        cur.deleteCharAt(cur.length() - 1); // backtrack
                    }
                }
            }

            new DFS().run(0, new StringBuilder());
            // remove duplicates and print
            Set<String> unique = new LinkedHashSet<>(res);
            for (String ss : unique) {
                String newS = s.replace(ss, "");
                String reversed = new StringBuilder(s).reverse().toString();
                if (newS.equals(reversed)) {
                    ress = newS;
                    break;
                }
            }
            if (ress.equals("-1")) System.out.println(-1);
            else {
                System.out.println(ress.length());

            }
        }
    }
}
