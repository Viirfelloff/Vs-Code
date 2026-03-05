import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CodeForces279B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long minutes = sc.nextLong();
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) list.add(sc.nextInt());
        //approach: use 2 pointers, and prefix sum array! yay silver strats!
        long[] pf = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list.get(i);
            pf[i] = sum;
        }
        int p1 = 0;
        int p2 = 0;
        long ans = -1;
        while (p1 < n && p2 < n) {
            long range = p1 == 0 ? pf[p2] : pf[p2] - pf[p1 - 1];
            if (range < minutes) p2++;
            else if (minutes < range) p1++;
            else {
                ans = p2 - p1 + 1;
                break;
            }
        }
        System.out.println(ans);
    }
}
