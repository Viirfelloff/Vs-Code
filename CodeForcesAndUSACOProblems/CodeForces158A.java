package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeForces158A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(sc.nextInt());
        }
        int count = 0;
        for (int x : scores) {
            if (x > 0 && x >= scores.get(k - 1)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
