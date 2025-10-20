import java.util.Scanner;
public class CodeForces1807D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] a = new long[n];
            long totalSum = 0;
            for (int k = 0; k < n; k++) {
                long x = sc.nextLong();
                a[k] = x;
                totalSum += x;
            }
            long[] prefix = new long[n + 1]; // +1 so we can use 1-based indexing
            for (int j = 1; j <= n; j++) {
                prefix[j] = prefix[j - 1] + a[j - 1];
            }
            for (int m = 0; m < q; m++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                long segmentSum = prefix[r] - prefix[l - 1];
                long len = r - l + 1;
                long newSum = totalSum - segmentSum + len * k;
                if (newSum % 2 != 0) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}