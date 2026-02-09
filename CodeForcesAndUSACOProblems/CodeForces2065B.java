
import java.util.Scanner;

public class CodeForces2065B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            boolean valid = false;
            char last = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (last == s.charAt(j)) {
                    valid = true;
                    break;
                }
                last = s.charAt(j);
            }
            if (valid) System.out.println(1);
            else System.out.println(s.length());
        }
    }
}
