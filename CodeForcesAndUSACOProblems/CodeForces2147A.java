import java.util.Scanner;

public class CodeForces2147A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            if (x == y) System.out.println(-1);
            else {
                if (x > y) {
                    if (x % 2 != 0 || y % 2 != 0) System.out.println(-1);
                    else System.out.println(3);
                }
                else System.out.println(2);
            }
        }
    }
}
