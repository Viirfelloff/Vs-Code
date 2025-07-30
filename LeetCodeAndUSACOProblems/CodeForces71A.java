package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeForces71A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.length() > 10) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                sb.append(s.length() - 2);
                sb.append(s.charAt(s.length() - 1));
                result.add(sb.toString());
            } else {
                result.add(s);
            }
        }
        for (String x : result) {
            System.out.println(x);
        }
    }
}
