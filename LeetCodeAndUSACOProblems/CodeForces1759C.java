import java.util.Scanner;

public class CodeForces1759C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        for (int i = 0; i < t; i++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long x = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (a == b) {
                System.out.println(0);
            } else if (Math.abs(a - b) >= x) {
                System.out.println(1);
            } else if ((b + x <= r || b - x >= l) && (a + x <= r || a - x >= l)) {
                // You can first move away from a and then reach b
                System.out.println(2);
            } else if (r - l >= x) {
                // You can go to an endpoint (l or r) and then to the other side, then to b
                System.out.println(3);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}