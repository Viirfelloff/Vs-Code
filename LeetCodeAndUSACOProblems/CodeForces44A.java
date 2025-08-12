package LeetCodeAndUSACOProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces44A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(sc.next());
        }
        System.out.println(set1.size());
    }
}
