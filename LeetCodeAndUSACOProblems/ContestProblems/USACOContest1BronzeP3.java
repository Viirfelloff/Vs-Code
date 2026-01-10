import java.util.Scanner;

public class USACOContest1BronzeP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        long[][] grid = new long[n][n];
        long[][] pref = new long[n][n];
        long max = 0;
        for (int i = 0; i < q; i++) {
            //the idea here is for every query brute force the positon of the camera
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            long v = sc.nextLong();
            grid[r][c] = v;
            for (int j = 0; j < n; j++) {
                for (int kk = 0; kk < n; kk++) {
                    long up = kk > 0 ? pref[kk - 1][j] : 0;
                    long left = j > 0 ? pref[kk][j - 1] : 0;
                    long diag = (kk > 0 && j > 0) ? pref[kk - 1][j - 1] : 0;
                    pref[kk][j] = grid[kk][j] + up + left - diag;
                }
            }
            int r1 = Math.max(0, r - k + 1);
            int c1 = Math.max(0,c - k + 1);

            for (int b = r1; b <= Math.min(r, n - k); b++) {
                for (int j = c1; j <= Math.min(c, n - k); j++) {
                    int r2 = b + k - 1;
                    int c2 = j + k - 1;

                    long sum = pref[r2][c2];
                    if (b > 0) sum -= pref[b - 1][c2];
                    if (j > 0) sum -= pref[r2][j - 1];
                    if (b > 0 && j > 0) sum += pref[b - 1][j - 1];

                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
