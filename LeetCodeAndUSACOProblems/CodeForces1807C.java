package LeetCodeAndUSACOProblems;

import java.awt.desktop.SystemSleepEvent;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces1807C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            Set<Character> chars = new HashSet<>();
            for (int k = 0; k < n; k++) {
                chars.add(s.charAt(k));
            }
            boolean valid = true;
            for (char x : chars) {
                int first = -1;
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == x) {
                        if (first == -1) {
                            first = j;
                        } else {
                            if (!(j % 2 == first % 2)) {
                                valid = false;
                                break;
                            }
                        }
                    }
                }
                if (!valid) {
                    break;
                }
            }
            if (!valid) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
