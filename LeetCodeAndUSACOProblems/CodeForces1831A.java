package LeetCodeAndUSACOProblems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//ur fucking retarded
public class CodeForces1831A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> perm = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                perm.add(sc.nextInt());
            }
            List<Integer> res = new ArrayList<>();
            res.add(n);
            int max = n + perm.get(perm.size() - 1);
            List<Integer> list2 = new ArrayList<>(perm);
            for (int j = perm.size() - 2; j >= 0; j--) {
                int diff = max - perm.get(j);
                if (diff >= n) {
                    res.add(Collections.max(list2));
                    list2.remove(Integer.valueOf(Collections.max(list2)));
                } else {
                    res.add(diff);
                    list2.remove(Integer.valueOf(diff));
                }
            }
            Collections.reverse(res);
            for (int x : res) {
                System.out.println(x);
            }
        }
    }
}
