

import java.util.Scanner;


public class CodeForces1822C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i= 0; i < t; i++) {
            long n = sc.nextLong();
            System.out.println(n * n + 2 * n + 2);
        }
    }
}
