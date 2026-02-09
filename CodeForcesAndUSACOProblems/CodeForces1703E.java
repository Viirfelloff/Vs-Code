import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1703E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            if (n == 1) {
                sc.next(); // read the single char row
                System.out.println(0);
                continue;
            }

            List<List<Character>> grid = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String rowStr = sc.next();
                List<Character> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(rowStr.charAt(j));
                }
                grid.add(row);
            }

            int ops = 0;

            for (int r = 0; r < n / 2; r++) {
                for (int c = 0; c < n / 2; c++) {

                    int zero = 0, one = 0;

                    int r0 = r, c0 = c;
                    int r1 = c, c1 = n - 1 - r;
                    int r2 = n - 1 - r, c2 = n - 1 - c;
                    int r3 = n - 1 - c, c3 = r;

                    if (grid.get(r0).get(c0) == '0') zero++; else one++;
                    if (grid.get(r1).get(c1) == '0') zero++; else one++;
                    if (grid.get(r2).get(c2) == '0') zero++; else one++;
                    if (grid.get(r3).get(c3) == '0') zero++; else one++;

                    ops += Math.min(zero, one);
                }
            }

            System.out.println(ops);
        }
    }
}
