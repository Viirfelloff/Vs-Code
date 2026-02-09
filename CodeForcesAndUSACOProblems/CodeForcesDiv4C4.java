package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv4C4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int i = 0; i< t; i++) {
            int n = sc.nextInt();
            List<Integer> finals = new ArrayList<>();
            for (int j = 0; j < n; j++) finals.add(sc.nextInt());
            List<String> changes = new ArrayList<>();
            for (int m = 0; m < n; m++) {
                int x = sc.nextInt();
                String s = sc.next();
                changes.add(s);
            }
            for (int g = 0; g < n; g++) {
                int og = finals.get(g);
                String ch = changes.get(g);
                for (char c : ch.toCharArray()) {
                    if (c == 'U') {
                        og--;
                        if (og == -1) og = 9;
                    } else {
                        og++;
                        if (og == 10) og = 0;
                    }
                }
                finals.set(g, og);
            }
            for (int y : finals) System.out.println(y);
        }
    }
}
