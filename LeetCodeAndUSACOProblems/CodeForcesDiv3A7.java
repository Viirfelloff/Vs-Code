package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv3A7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            if (k % 2 == 0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
