package LeetCodeAndUSACOProblems;

import java.util.*;

public class CodeForces2165A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<Long> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            List<Long> sorted = new ArrayList<>(list);
            Collections.sort(sorted);

        }
    }
}
