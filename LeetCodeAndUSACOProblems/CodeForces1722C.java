
import java.util.*;

public class CodeForces1722C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Set<String> g1 = new HashSet<>();
            Set<String> g2 = new HashSet<>();
            Set<String> g3 = new HashSet<>();
            Set<String> all = new HashSet<>();
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < n; k++) {
                    String x = sc.next();
                    if (j == 0) g1.add(x);
                    else if (j == 1) g2.add(x);
                    else g3.add(x);
                    all.add(x);
                }
            }
            for (String s : all) {
                boolean a = g1.contains(s);
                boolean b = g2.contains(s);
                boolean c = g3.contains(s);
                int contained = 0;
                if (a) contained++;
                if (b) contained++;
                if (c) contained++;
                if (contained == 1) {
                    if (a) score1 += 3;
                    if (b) score2 += 3;
                    if (c) score3 += 3;
                }
                else if (contained == 2) {
                    if (a) score1 += 1;
                    if (b) score2 += 1;
                    if (c) score3 += 1;
                }
            }
            System.out.println(score1);
            System.out.println(score2);
            System.out.println(score3);
        }
    }
}
