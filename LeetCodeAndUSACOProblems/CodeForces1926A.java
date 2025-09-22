package LeetCodeAndUSACOProblems;
import java.util.Scanner;

public class CodeForces1926A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t;i++) {
            String s = sc.next();
            int acount = 0;
            for (char c : s.toCharArray()) {
                if (c == 'A') acount++;
            }
            if (acount >= 3) System.out.println("A");
            else System.out.println("B");
        }
    }
}
