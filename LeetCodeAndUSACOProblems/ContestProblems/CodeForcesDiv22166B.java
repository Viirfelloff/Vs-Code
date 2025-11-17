import java.util.Scanner;

public class CodeForcesDiv22166B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long n = sc.nextLong();
            if (b <= a / n) System.out.println(1);
            else {
                //if a <= b, then no matter what m, a/m will be the minimum. close from the end.
                //else, u can close from the end until it stabilizes then close from the front. 2.
                if (a <= b) System.out.println(1);
                else {
                    System.out.println(2);
                }
            }
        }
    }
}
