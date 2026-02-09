import java.util.Scanner;

public class CodeForces1759C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long x = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == b) System.out.println(0);
            else  {
                if (b - a >= x) {
                    System.out.println(1);
                } else {
                    if (b + x <= r && a < b) System.out.println(2);
                    else if (b - x >= l && a > b) System.out.println(2);
                    else {
                        if (a > b && b + x <= r && Math.abs(a - l) >= x) System.out.println(3);
                        else if (a < b && b - x >= l && Math.abs(a - r) >= x) System.out.println(3);
                        else System.out.println(-1);
                    }
                }
            }
        }
    }
}