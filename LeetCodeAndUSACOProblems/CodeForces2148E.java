import java.util.*;

public class CodeForces2148E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            int[] totalCount = new int[n + 1];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                totalCount[a[i]]++;
            }

            // Step 1: check if any value's total count % k != 0
            boolean impossible = false;
            for (int v = 1; v <= n; v++) {
                if (totalCount[v] % k != 0) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println(0);
                continue;
            }

            // Step 2: compute per-value quotas
            int[] quota = new int[n + 1];
            for (int v = 1; v <= n; v++) {
                quota[v] = totalCount[v] / k;
            }

            // Step 3: sliding window
            int[] freq = new int[n + 1];
            int l = 0;
            long count = 0;

            for (int r = 0; r < n; r++) {
                freq[a[r]]++;

                // shrink left if quota exceeded
                while (freq[a[r]] > quota[a[r]]) {
                    freq[a[l]]--;
                    l++;
                }

                // subarrays ending at r starting from l..r are valid
                count += r - l + 1;
            }

            System.out.println(count);
        }

        sc.close();
    }
}
