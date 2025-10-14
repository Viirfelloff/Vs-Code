
import java.util.Scanner;

public class CodeForces1857A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t;i++) {
            int n = sc.nextInt();
            int oddcount = 0;
            int evencount = 0;
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() % 2 != 0) oddcount++;
                else evencount++;
            }
            if (oddcount % 2 == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
