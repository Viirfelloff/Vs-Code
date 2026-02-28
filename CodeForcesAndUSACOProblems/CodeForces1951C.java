package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1951C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            long k = sc.nextLong();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            List<Long> sorted = new ArrayList<>(list);
            Collections.sort(sorted);

        }
    }
}
