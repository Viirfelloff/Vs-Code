package LeetCodeAndUSACOProblems;
//easy

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CodeForces2126A {
    public static int solution(int a) {
        String s = Integer.toString(Math.abs(a));
        ArrayList<Integer> arr = new ArrayList<>();
        for (char x : s.toCharArray()) {
            arr.add(Character.getNumericValue(x));
        }
        return Collections.min(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(solution(input));
    }
}
