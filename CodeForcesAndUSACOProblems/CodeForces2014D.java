import java.util.Scanner;
public class CodeForces2014D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();
            int[] diffStart = new int[n + 2];
            int[] diffEnd = new int[n + 2];

            for (int j = 0; j < k; j++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                diffStart[l]++;
                diffEnd[r]++;
            }
            int[] prefStart = new int[n + 2];
            int[] prefEnd = new int[n + 2];
            for (int j = 1; j <= n; j++) {
                prefStart[j] = prefStart[j - 1] + diffStart[j];
                prefEnd[j] = prefEnd[j - 1] + diffEnd[j];
            }
            int minJobs = Integer.MAX_VALUE;
            int maxJobs = Integer.MIN_VALUE;
            int brotherDay = 1;
            int motherDay = 1;
            for (int i = 1; i <= n - d + 1; i++) {
                int windowStart = i;
                int windowEnd = i + d - 1;

                int currentOverlaps = prefStart[windowEnd] - prefEnd[windowStart - 1];

                if (currentOverlaps > maxJobs) {
                    maxJobs = currentOverlaps;
                    brotherDay = i;
                }
                if (currentOverlaps < minJobs) {
                    minJobs = currentOverlaps;
                    motherDay = i;
                }
            }
            System.out.println(brotherDay + " " + motherDay);
        }
    }
}