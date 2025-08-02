package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class USACOHardLesGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String m = sc.next();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= m.length()) {
                boolean match = true;
                for (int i = 0; i < m.length(); i++) {
                    if (sb.charAt(sb.length() - m.length() + i) != m.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.delete(sb.length() - m.length(), sb.length());
                }
            }
        }
        System.out.println(sb.toString());
    }
}
