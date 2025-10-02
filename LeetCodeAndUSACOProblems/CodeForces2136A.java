import java.util.Scanner;

public class CodeForces2136A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            int secondHalfA = c - a;
            int secondHalfB = d - b;

            boolean firstHalfOK = (a <= 2*(b+1)) && (b <= 2*(a+1));
            boolean secondHalfOK = (secondHalfA <= 2*(secondHalfB+1)) && (secondHalfB <= 2*(secondHalfA+1));

            if (firstHalfOK && secondHalfOK) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
