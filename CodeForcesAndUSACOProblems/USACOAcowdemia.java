package CodeForcesAndUSACOProblems;

import java.util.*;
//failed yet agian
public class USACOAcowdemia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] citations = new int[n];
        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        Arrays.sort(citations);

        int left = 0, right = n;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Count how many papers already have citations >= mid
            int count_ge = 0;
            int count_eq_h_minus_1 = 0;
            for (int i = 0; i < n; i++) {
                if (citations[i] >= mid) count_ge++;
                else if (citations[i] == mid - 1) count_eq_h_minus_1++;
            }

            // We can use boosts on h-1 citations
            int possible = count_ge + Math.min(count_eq_h_minus_1, k);

            if (possible >= mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
