
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class CodeForces1608A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> res = new ArrayList<>();
            int current = 2;
            for (int k = 1; k <= n; k++) {
                res.add(current);
                current++;
            }
            for (int x : res) System.out.println(x);
        }
    }
}
