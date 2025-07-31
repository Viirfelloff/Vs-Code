package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class USACOWerecooked {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int M = sc.nextInt();
        int max = 0;
        for (int yCount = 0; yCount * Y <= M; yCount++) {
            int remaining = M - yCount * Y;
            int xCount = remaining / X;
            int total = yCount * Y + xCount * X;
            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}
