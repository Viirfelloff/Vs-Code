import java.util.Scanner;

public class CodeForces2167A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if (a == b && b == c && c == d) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}
