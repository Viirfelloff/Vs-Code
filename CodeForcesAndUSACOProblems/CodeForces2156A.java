import java.util.Scanner;

public class CodeForces2156A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextInt();
            long alex = 0;
            while (n > 2) {
                long a = 0;
                long b = 0;
                long c = 0;
                long part1 = n / 3;
                a = part1;
                b = part1;
                c = n - a - b;
                n = c;
                alex += a;
            }
            System.out.println(alex);
        }
    }
}
