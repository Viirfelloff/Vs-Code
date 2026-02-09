import java.util.*;

public class CodeForces1948B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int last = -1;
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int firstDigit = (x < 10) ? x : x / 10;

                if (firstDigit < last) ok = false;
                last = firstDigit;
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
