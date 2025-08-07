package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//another easy problem fail.
public class USACOMilkPails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> amts = new ArrayList<>();
        int maxX = M / X;
        int maxY = M / Y;
        int xFactor = maxX - 1;
        int yFactor = 1;
        amts.add(X * maxX);
        amts.add(Y * maxY);
        while (xFactor > 0) {
            int amt = X * xFactor + Y * yFactor;
            if (amt <= M) {
                amts.add(amt);
            }
            xFactor--;
            yFactor++;
        }
        System.out.println(Collections.max(amts));
    }
}
