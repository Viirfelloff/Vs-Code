import java.util.Scanner;

public class USACOContest1BronzeP1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long ca = sc.nextLong();
            long cb = sc.nextLong();
            long fa = sc.nextLong();
            long l = 0;
            long r = 1_000_000_000_000_000_000L;;
            long ans = r;
            while (l <= r) {
                long mid = l + (r - l) / 2;
                if (cr(a,b,ca,cb,fa,mid)) {
                    ans = mid;
                    r = mid - 1;
                } else l = mid + 1;
            }
            System.out.println(ans);
        }
    }
    public static boolean cr(long a, long b, long ca, long cb, long fa, long x) {
        long maxK = (b + x) / cb;
        for (long k = Math.max(0,maxK - 1); k < maxK; k++) {
            long exb = k * cb - b;
            if (exb < 0) exb = 0;
            if (exb > x) exb = x;
            long exa = x - exb;
            long ta = a + exa + k * ca;
            if (ta >= fa) return true;
        }
        return false;
    }
}
