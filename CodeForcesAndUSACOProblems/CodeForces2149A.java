package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2149A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            int zerocount = 0;
            int negone = 0;
            for (int k = 0; k < n; k++) {
                int x = sc.nextInt();
                if (x == 0) zerocount++;
                else if (x == -1) negone++;
                nums.add(x);
            }
            int ops = zerocount;
            if (negone % 2 != 0) ops += 2;
            System.out.println(ops);
        }
    }
}
