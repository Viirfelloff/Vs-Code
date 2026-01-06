package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1991C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            boolean zero = true;
            boolean even = false;
            boolean odd = false;
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                if (x != 0) zero = false;
                if (x % 2 == 0) even = true;
                else odd = true;
                list.add(x);
            }
            if (zero) System.out.println(0);
            else if (even && odd) System.out.println(-1);
            else {
                //sequence to decrease diff between elements
                //goal is to get everything to either 2 or zero.
                //for odds first decrease will make everything even, for even decreases will stay even.
                //observed best strategy has been subtracting the minimum (keep in mind 40 move limit)'
                List<Long> ops = new ArrayList<>();
                int k = 0;
                while (true) {
                    //op

                    k++;
                }
            }
        }
    }
}
