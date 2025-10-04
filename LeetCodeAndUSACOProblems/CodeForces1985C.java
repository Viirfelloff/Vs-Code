import java.util.*;

public class CodeForces1985C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long sum = 0;
            long max = Long.MIN_VALUE;
            int good = 0;

            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                sum += x;
                max = Math.max(max, x);

                if (sum == 2 * max) {
                    good++;
                }
            }

            System.out.println(good);
        }
    }
}
