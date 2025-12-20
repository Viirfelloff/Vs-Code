package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2169C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            //possible two pointer + prefix sum?
            //build prefix sum
            int[] pfs = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += list.get(j);
                pfs[j] = sum;
            }
            //sum between a and b == pfs[a] - pfs[b] use for 2 pointer
            //what we need to do here to maximize the sum when replaced is replace the longest segment possible
            //smaller segments do not guarantee maximization of sum
            //traverse possibilities with 2 pointer
            int left = 0;
            int right = n - 1;
            while (true) {
                if (right + left > pfs[right] - pfs[left]) {
                    //code for update sum
                    break;
                } else {
                    //
                }
            }
        }
    }
}
