package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class USACOUdderedButNotHeard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alpha = sc.next();
        String rem = sc.next();
        int last = alpha.indexOf(rem.charAt(0));
        int count = 0;
        for (int i = 1; i < rem.length(); i++) {
            if (alpha.indexOf(rem.charAt(i)) <= last) {
                count++;
            }
            last = alpha.indexOf(rem.charAt(i));
        }
        System.out.println(count + 1);
    }
}
