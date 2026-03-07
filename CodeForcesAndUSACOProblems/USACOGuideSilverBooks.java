import java.util.Scanner;
public class USACOGuideSilverBooks {
    //2 pointers are lowk aura
    //sliding window for this one
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] pf = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextLong();
            pf[i] = sum;
        }
        if (n == 1) System.out.println(pf[0] <= k ? 1 : 0);
        else {
            int max = Integer.MIN_VALUE;
            int p1 = 0;
            int p2 = 0;
            while (p1 < n && p2 < n) {
                long nextRange = p1 == 0 ? pf[p2] : pf[p2] - pf[p1 - 1];
                if (nextRange > k) p1++;
                else {
                    int len = p2 - p1 + 1;
                    if (len > max) max = len;
                    p2++;
                }
            }
            System.out.println(max);
        }
    }
}
