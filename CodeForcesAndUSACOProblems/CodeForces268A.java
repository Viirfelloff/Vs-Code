package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeForces268A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> homes = new ArrayList<>();
        ArrayList<Integer> aways = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            homes.add(x);
            aways.add(y);
        }
        int count = 0;
        for (int xx: homes) {
            for (int yy : aways) {
                if (xx == yy) count++;
            }
        }
        System.out.println(count);
    }
}
