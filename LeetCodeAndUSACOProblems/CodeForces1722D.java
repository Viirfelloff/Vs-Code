import java.util.*;

public class CodeForces1722D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            long count = 0;
            long[] gains = new long[n];

            // Step 1: compute initial line value and gain if flipped
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'L') {
                    count += i;
                    gains[i] = (n - 1 - i) - i;
                } else {
                    count += (n - 1 - i);
                    gains[i] = i - (n - 1 - i);
                }
            }

            // Step 2: sort gains descending
            Arrays.sort(gains);
            long sumGain = 0;

            // Step 3: print answers for k = 1..n
            for (int k = 1; k <= n; k++) {
                if (k <= n && gains[n - k] > 0) sumGain += gains[n - k];
                System.out.print((count + sumGain) + (k == n ? "\n" : " "));
            }
        }
    }
}
