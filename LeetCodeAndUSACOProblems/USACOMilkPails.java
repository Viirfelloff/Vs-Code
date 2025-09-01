package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//too fucking easy lads were moving up in life yayyhhhh
public class USACOMilkPails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> fills = new ArrayList<>();
        fills.add(x * (m / x));
        fills.add(y * (m / y));
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                if ((x*i) + (y * j) <= m) fills.add((x*i) + (y * j));
                else break;
            }
        }
        System.out.println(Collections.max(fills));
    }
}
