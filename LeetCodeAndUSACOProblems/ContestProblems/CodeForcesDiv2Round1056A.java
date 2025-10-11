import java.util.Scanner;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

public class CodeForcesDiv2Round1056A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            if (!scanner.hasNextInt()) break;
            int n = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int k = scanner.nextInt();


            if (k == n * n - 1 && n >= 2) {
                out.println("NO");
                continue;
            }

            if (k == n * n) {
                out.println("YES");
                for (int r = 0; r < n; r++) {
                    out.println("U".repeat(n));
                }
                continue;
            }

            out.println("YES");
            char[][] grid = new char[n][n];

            for (int cellIndex = 0; cellIndex < k; cellIndex++) {
                int r = cellIndex / n;
                int c = cellIndex % n;
                grid[r][c] = 'U';
            }

            grid[n - 1][n - 2] = 'R'; // A -> B
            grid[n - 1][n - 1] = 'L'; // B -> A

            for (int cellIndex = k; cellIndex < n * n - 2; cellIndex++) {
                int r = cellIndex / n;
                int c = cellIndex % n;

                if (r < n - 1) {
                    grid[r][c] = 'D';
                } else {
                    grid[r][c] = 'R';
                }
            }

            for (int r = 0; r < n; r++) {
                out.println(new String(grid[r]));
            }
        }
        out.flush();
        scanner.close();
    }
}
