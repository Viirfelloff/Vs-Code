package CodeForcesAndUSACOProblems;

import java.util.Scanner;

//Ayy div 2 b problem 1000
public class CodeForces688B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(n);
        String ss = new StringBuilder(s).reverse().toString();
        sb.append(s);
        sb.append(ss);
        System.out.println(sb.toString());
    }
}

