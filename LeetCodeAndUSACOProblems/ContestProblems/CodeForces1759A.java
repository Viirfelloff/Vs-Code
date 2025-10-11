

import java.util.Scanner;

public class CodeForces1759A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            String target = "Yes".repeat(50);
            if (target.contains(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
