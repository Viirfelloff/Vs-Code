package LeetCodeAndUSACOProblems;

import java.util.Scanner;

public class USACOOoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] petals = new int[n];
        for (int i = 0; i < n; i++) {
            petals[i] = sc.nextInt();
        }

        // prefix sums: prefix[i] = sum of petals[0..i-1]
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + petals[i - 1];
        }

        int count = 0;

        // Loop through all subarrays [i, j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int length = j - i + 1;
                int sum = prefix[j + 1] - prefix[i];

                if (sum % length != 0) continue;  // skip if avg not integer

                int avg = sum / length;

                // check if any flower in [i..j] has exactly avg petals
                for (int k = i; k <= j; k++) {
                    if (petals[k] == avg) {
                        count++;
                        break;  // only count once per segment
                    }
                }
            }
        }

        System.out.println(count);
    }
}
