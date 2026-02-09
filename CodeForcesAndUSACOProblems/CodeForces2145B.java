

import java.util.Scanner;

public class CodeForces2145B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            StringBuilder sb = new StringBuilder("+".repeat(n));

            int top = 0;         // top pointer
            int bottom = n - 1;  // bottom pointer
            int leftQ = n;       // leftmost uncertain index
            int rightQ = -1;     // rightmost uncertain index

            for (int j = 0; j < k; j++) {
                char op = s.charAt(j);
                if (op == '0') {
                    // remove definite top
                    sb.setCharAt(top, '-');
                    top++;
                }
                else if (op == '1') {
                    // remove definite bottom
                    sb.setCharAt(bottom, '-');
                    bottom--;
                }
                else { // op == '2' → unknown removal (either top or bottom)
                    // expand uncertain region
                    leftQ = Math.min(leftQ, top);
                    rightQ = Math.max(rightQ, bottom);

                    // move both inward because one card is definitely gone
                    top++;
                    bottom--;
                }
            }

            // now mark uncertain range with '?'
            if (leftQ <= rightQ) {
                for (int i = leftQ; i <= rightQ; i++) {
                    sb.setCharAt(i, '?');
                }
            }

            System.out.println(sb);
        }
    }
}
