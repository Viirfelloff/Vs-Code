import java.util.Scanner;

public class CodeForces2173A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int l = 0;
            int total = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    l = 0;
                    l += k;
                }
                else {
                    if (l == 0) total++;
                    else l--;
                }
            }
            System.out.println(total);
        }
    }
}
