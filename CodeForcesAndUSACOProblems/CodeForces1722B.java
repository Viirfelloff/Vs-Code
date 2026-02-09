
import java.util.Scanner;

public class CodeForces1722B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == s2.charAt(j) || s2.charAt(j) == 'G' && s1.charAt(j) == 'B' || s1.charAt(j) == 'G' && s2.charAt(j) == 'B') {
                    int poop = 0;
                } else {
                    valid = false;
                    break;
                }
            }
            if (!valid) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
