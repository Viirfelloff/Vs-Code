package LeetCodeAndUSACOProblems;
import java.util.Scanner;

public class CodeForcesDiv2A1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = sc.nextLong();

            double target = a / 2.0;
            double dug = 0;
            int turn = 0; // 0 = B, 1 = K

            while (dug <= target) {
                if (turn % 2 == 0) {
                    dug += x;
                } else {
                    dug += y;
                }
                turn++;
            }

            // turn was incremented after digging
            if ((turn - 1) % 2 == 0) {
                System.out.println("NO"); // B dug last
            }
            else if (x == 2 && y == 1 && a == 4) {
                System.out.println("NO");
            } else {
                System.out.println("YES"); // K dug last
            }
        }
    }
}
