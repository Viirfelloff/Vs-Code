import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1878B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> res = new ArrayList<>();
            long cur = 1;
            for (int j = 0; j < n; j++) {
                res.add(cur);
                cur += 2;
            }
            for (long x : res) System.out.println(x);
        }
    }
}
