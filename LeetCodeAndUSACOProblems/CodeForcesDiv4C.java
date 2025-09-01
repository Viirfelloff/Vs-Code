package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv4C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                rows.add(sc.next());
            }
            boolean found = false;
            char res = ' ';
            while (!found) {
                for (int j = 0; j < 8; j++) {
                    char starting = rows.getFirst().charAt(j);
                    boolean valid = true;
                    for (int k = 0; k < 8; k++) {
                        if (rows.get(k).charAt(j) == '.' || rows.get(k).charAt(j) != starting) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        res = starting;
                        found = true;
                        break;
                    }
                }
                if (found) break;
                for (int b = 0; b < 8; b++) {
                    boolean valid = true;
                    char st = rows.get(b).charAt(0);
                    for (char c : rows.get(b).toCharArray()) {
                        if (c == '.' || c != st) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        found = true;
                        res = st;
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
