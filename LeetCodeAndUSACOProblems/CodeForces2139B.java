import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2139B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> ovens = new ArrayList<>();
            for (int j = 0; j < n; j++) ovens.add(sc.nextInt());
            long total = 0;
            Collections.sort(ovens);
            int a1 = ovens.get(ovens.size() - 1);
            int a2 = ovens.get(ovens.size() - 2);
            total = (long) (m / 2) * (a1 + a2);
            if (m % 2 == 1) total += a1;
            System.out.println(total);
        }
    }
}
