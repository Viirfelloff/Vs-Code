import java.util.Scanner;

public class CodeForces2117B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int currentMax = n;
            int[] res = new int[n];
            if (n % 2 == 0) {
                int left = n/2-1;
                int right = left + 1;
                int inc = 0;
                while (currentMax >= 1) {
                    if (inc % 2 == 0 && left >= 0) {
                        res[left] = currentMax;
                        left--;
                    } else if (inc % 2 != 0 && right <= n - 1) {
                        res[right] = currentMax;
                        right++;
                    }
                    currentMax--;
                    inc++;
                }
            } else {
                int left = n / 2 - 1;
                int right = n / 2 + 1;
                int inc = 0;
                res[n / 2] = currentMax;
                currentMax--;
                while (currentMax >= 1) {
                    if (inc % 2 == 0 && left >= 0) {
                        res[left] = currentMax;
                        left--;
                    } else if (inc % 2 != 0 && right <= n - 1) {
                        res[right] = currentMax;
                        right++;
                    }
                    currentMax--;
                    inc++;
                }
            }
            for (int x : res) System.out.println(x);
        }
    }
}
