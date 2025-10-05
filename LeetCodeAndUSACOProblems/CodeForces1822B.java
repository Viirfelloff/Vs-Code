

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces1822B {
    // number of elements between two indices = idx1 - idx2 - 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> l1 = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                l1.add(sc.nextLong());
            }
            Collections.sort(l1);
            long m1 = l1.get(0);
            long m2 = l1.get(1);

            long max1 = l1.get(l1.size() - 1);
            long max2 = l1.get(l1.size() - 2);

            System.out.println(Math.max(max2 * max1, m1 * m2));
        }
    }
}
