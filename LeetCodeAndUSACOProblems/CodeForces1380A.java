package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1380A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 0; x < t; x++) {
            boolean found = false;
            int n = sc.nextInt();
            List<Integer> res = new ArrayList<>();
            List<Integer> numbers = new ArrayList<>();
            for (int p = 0; p < n; p++) {
                numbers.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                if (found) break;
                for (int j = i + 1; j < n; j++) {
                    if (found) break;
                    for (int k = j + 1; k < n; k++) {
                        if (i < j && j < k && numbers.get(i) < numbers.get(j) && numbers.get(j) > numbers.get(k)) {
                            res.add(i);
                            res.add(j);
                            res.add(k);
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(res.get(0) + 1);
                System.out.println(res.get(1) + 1);
                System.out.println(res.get(2) + 1);
            }
        }
    }
}
