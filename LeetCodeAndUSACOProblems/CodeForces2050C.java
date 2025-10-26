import java.util.Scanner;

public class CodeForces2050C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next(); // read as string (since up to 10^5 digits)
            int sum = 0, count2 = 0, count3 = 0;

            for (char c : s.toCharArray()) {
                int d = c - '0';
                sum += d;
                if (d == 2) count2++;
                else if (d == 3) count3++;
            }

            sum %= 9;
            boolean valid = false;

            // try replacing up to 8 of each
            for (int x = 0; x <= Math.min(8, count2); x++) {
                for (int y = 0; y <= Math.min(8, count3); y++) {
                    int newSum = (sum + 2 * x + 6 * y) % 9;
                    if (newSum == 0) {
                        valid = true;
                        break;
                    }
                }
                if (valid) break;
            }

            System.out.println(valid ? "YES" : "NO");
        }
    }
}
