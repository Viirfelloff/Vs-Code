import java.util.*;

public class CodeForces1993B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            int firstOddIndex = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 1) {
                    firstOddIndex = i;
                    break;
                }
            }
            if (firstOddIndex == -1 || firstOddIndex == 0) {
                System.out.println(0);
                continue;
            }
            int evenCount = 0;
            for (long x : a) {
                if (x % 2 == 0) evenCount++;
            }
            System.out.println(evenCount + firstOddIndex);
        }
    }
}
