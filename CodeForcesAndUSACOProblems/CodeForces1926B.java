package CodeForcesAndUSACOProblems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1926B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<String> rows = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                rows.add(sc.next());
            }
            int r1 = -1;
            int r = 0;
            String res = "0";
            for (String s : rows) {
                if (r1 != -1) break;
                int c = 0;
                for (char cc : s.toCharArray()) {
                    if (cc == '1') {
                        r1 = r;
                        break;
                    }
                    c++;
                }
                r++;
            }
            String row = rows.get(r1 + 1);
            int count1 = 0;
            int count2 = 0;
            for (char ccc : rows.get(r1).toCharArray()) {
                if (ccc == '1') {
                    count1++;
                }
            }
            for (char cccc : row.toCharArray()) {
                if (cccc == '1') {
                    count2++;
                }
            }
            if (count1 == count2) res = "SQUARE";
            else res = "TRIANGLE";
            System.out.println(res);
        }
    }
}
