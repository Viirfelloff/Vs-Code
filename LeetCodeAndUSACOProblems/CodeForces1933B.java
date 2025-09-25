package LeetCodeAndUSACOProblems;

import java.util.*;

public class CodeForces1933B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            int sum = 0;
            Set<Integer> remainderOne = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                nums.add(x);
                sum += x;
                if (x % 3 == 1) remainderOne.add(x);
            }
            if (sum % 3 == 0) {
                System.out.println(0);
            }
            else if (sum % 3 == 2) {
                System.out.println(1);
            } else {
                if (!remainderOne.isEmpty()) System.out.println(1);
                else System.out.println(2);
            }
        }
    }
}
