package LeetCodeAndUSACOProblems.ContestProblems;
import java.io.*;
import java.util.*;


public class CodeForcesDiv4Round1050A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    sum += x;
                } else {
                    sum += (x * -1);
                }
            }
            System.out.println(sum);
        }
    }
}