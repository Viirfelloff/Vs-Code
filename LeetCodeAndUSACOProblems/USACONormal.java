package LeetCodeAndUSACOProblems;

import java.util.*;

public class USACONormal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] global = new int[26];  // a to z

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();

            int[] freqA = new int[26];
            int[] freqB = new int[26];

            for (char ch : a.toCharArray()) {
                freqA[ch - 'a']++;
            }
            for (char ch : b.toCharArray()) {
                freqB[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                global[j] += Math.max(freqA[j], freqB[j]);
            }
        }

        for (int count : global) {
            System.out.println(count);
        }
    }
}
