

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1941A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int count = 0;
            for (int j = 0; j < n; j++) {
                list1.add(sc.nextInt());
            }
            for (int l = 0; l < m; l++) {
                list2.add(sc.nextInt());
            }
            for (int x : list1) {
                for (int y : list2) {
                    if (x + y <= k) count++;
                }
            }
            System.out.println(count);
        }
    }
}
