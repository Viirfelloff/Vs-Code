import java.util.Scanner;

public class USACOContest1BronzeP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        long[][] grid = new long[n][n];
        long[][] squareSums = new long[n][n];
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            long v = sc.nextLong();
            long cc = v - grid[r][c];
            grid[r][c] = v;
            if (cc != 0) {
                int startY = Math.max(r - k + 1, 0);
                int endY = Math.min(r, n - k);
                int startX = Math.max(c - k + 1, 0);
                int endX = Math.min(c, n - k);
                for (int j = startY; j <= endY; j++) {
                    for (int s = startX; s <= endX; s++) {
                        squareSums[j][s] += v;
                    }
                }
            }
            long curMax = 0;
            for (long[] longs : squareSums) {
                for (long l : longs) {
                    if (l > curMax) curMax = l;
                }
            }
            System.out.println(curMax);
        }
    }
}
