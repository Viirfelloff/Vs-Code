package CodeForcesAndUSACOProblems;

import java.util.*;

public class CodeForcesDiv4B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> set = new ArrayList<>();
            List<Integer> products = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                set.add(sc.nextInt());
            }
            for (int k = 0; k < n; k++) {
                int pro = 1;
                set.set(k, set.get(k) + 1);
                for (int x : set) {
                    pro *= x;
                }
                products.add(pro);
                set.set(k, set.get(k) - 1);
            }
            System.out.println(Collections.max(products));
        }
    }
}
