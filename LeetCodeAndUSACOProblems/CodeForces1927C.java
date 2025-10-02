import java.util.*;

public class CodeForces1927C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int halfK = k / 2;

            boolean[] has1 = new boolean[k + 1];
            boolean[] has2 = new boolean[k + 1];

            // Read array a
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x <= k) has1[x] = true;
            }

            // Read array b
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                if (x <= k) has2[x] = true;
            }

            int count1 = 0, count2 = 0, shared = 0;
            boolean possible = true;

            for (int x = 1; x <= k; x++) {
                if (!has1[x] && !has2[x]) {
                    // Number missing from both arrays
                    possible = false;
                    break;
                } else if (has1[x] && has2[x]) {
                    shared++;
                } else if (has1[x]) {
                    count1++;
                } else {
                    count2++;
                }
            }

            if (!possible || count1 > halfK || count2 > halfK) {
                System.out.println("NO");
            } else {
                // Number of additional picks needed for each list
                int needed1 = halfK - count1;
                int needed2 = halfK - count2;

                if (needed1 + needed2 <= shared) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
