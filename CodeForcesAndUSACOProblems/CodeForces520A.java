package CodeForcesAndUSACOProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces520A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Character> set1 = new HashSet<>();
        String s = sc.next();
        for (char x : s.toCharArray()) set1.add(x);
        System.out.println(set1.size() >= 26);
    }
}
