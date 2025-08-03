package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class USACOABCs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);
        int a = nums.getFirst();
        int b = nums.get(1);
        int c = nums.getLast() - (a + b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
