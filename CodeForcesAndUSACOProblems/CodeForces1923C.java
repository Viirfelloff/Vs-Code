package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1923C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            for (int j = 0; j < q; j++) {
                int[] query = new int[]{sc.nextInt() - 1, sc.nextInt() - 1}; //0 indexed
                if (query[1] - query[0] == 0) System.out.println("NO");

            }
        }
    }
}
