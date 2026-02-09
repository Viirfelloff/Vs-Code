package CodeForcesAndUSACOProblems;
import java.util.Scanner;

public class CodeForces2044B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int k = s.length() - 1; k >= 0; k--) {
                if (s.charAt(k) == 'q') sb.append('p');
                else if (s.charAt(k) == 'p') sb.append('q');
                else sb.append('w');
            }
            System.out.println(sb);
        }
    }
}
