import java.util.*;

public class CodeForces2171B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            List<Long> nums = new ArrayList<>();
            for (int j = 0; j < n; j++) sc.nextLong();

        }
    }

    public static int getMex(int[] arr) {
        int[] b = Arrays.copyOf(arr, arr.length);
        Arrays.sort(b);
        int curMex = 0;
        for (int j = 0; j < b.length; j++) {
            if (b[j] == curMex) {
                curMex++;
            } else if (b[j] > curMex) {
                return curMex;
            }
        }
        return curMex;
    }
}
