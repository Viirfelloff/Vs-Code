import java.util.Scanner;
//ur so ass
public class CodeForces1941B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            boolean possible = true;

            for (int i = 1; i < n - 1; i++) { // middle elements
                if (a[i-1] > 0) {
                    long x = a[i-1]; // number of operations to reduce left neighbor to 0
                    a[i-1] -= x;        // becomes 0
                    a[i]   -= 2 * x;    // middle decreases by 2*x
                    a[i+1] -= x;        // right neighbor decreases by x

                    if (a[i] < 0 || a[i+1] < 0) {
                        possible = false;
                        break;
                    }
                }
            }

            if (a[n-1] != 0) possible = false; // last element must be zero

            System.out.println(possible ? "YES" : "NO");
        }

        sc.close();
    }
}
