import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesRound1076A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int x = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += sc.nextInt();
            }
            boolean valid = true;
            if (sum > s) valid = false;
            else if (sum == s) valid = true;
            else valid = (s - sum) % x == 0;
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
