import java.util.Scanner;

public class CodeForces2158A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            int total = r;
            if (y % 2 == 0) total += (y / 2);
            else {
                total += ((y - 1) / 2);
            }
            if (total > n) System.out.println(n);
            else System.out.println(total);
        }
    }
}
