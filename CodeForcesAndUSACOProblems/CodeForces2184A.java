import java.util.Scanner;

public class CodeForces2184A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (n == 2) System.out.println(n);
            else if (n == 3) System.out.println(3);
            else {
                System.out.println(n % 2);
            }
        }
    }
}
