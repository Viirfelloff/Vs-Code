import java.util.Scanner;

public class CodeForces2145A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (n % 3 != 0) System.out.println(3 - (n % 3));
            else System.out.println(0);
        }
    }
}
