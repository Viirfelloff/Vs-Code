package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1854A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int neg = 0;
            int pos = 0;
            for (int k = 0; k < t; k++) {
                int x = sc.nextInt();
                list.add(x);
                if (x == -1) neg++;
                else pos++;
            }
            if (n % 2 == 0) {
                if (neg > pos) {
                    System.out.println();
                }
                else if (neg < pos) {
                    if (neg % 2 == 0) {
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                }
                else if (pos == 0) {
                    if (neg == 2) System.out.println(neg);
                    else System.out.println(n / 2);
                } else {
                    System.out.println(0);
                }
            } else {
                if (neg > pos) {

                } else if (neg < pos){

                }
                else if (neg == 0) {

                }
                else if (pos == 0) {

                }
            }
        }
    }
}
