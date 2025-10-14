import java.util.Scanner;
public class CodeForces1857B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            // fix: read as string instead of long
            String s = sc.next();
            int n = s.length();
            char[] digits = s.toCharArray();

            String maxValStr = s; // store max as string (instead of long)

            // simulate rounding from right to left
            for (int k = n - 1; k > 0; k--) {
                if (digits[k] >= '5') {
                    int pos = k - 1;
                    digits[pos] += 1;

                    // handle carry for 9s
                    while (pos > 0 && digits[pos] > '9') {
                        digits[pos] = '0';
                        digits[pos - 1] += 1;
                        pos--;
                    }

                    if (digits[0] > '9') {
                        digits[0] = '1';
                        // expand array by one digit
                        StringBuilder sb = new StringBuilder("1");
                        for (int z = 0; z < n; z++) sb.append('0');
                        maxValStr = sb.toString();
                        break;
                    }

                    // set lower digits to '0'
                    for (int j = k; j < n; j++) digits[j] = '0';
                } else {
                    // digits[k] < 5 → just set lower digits to '0'
                    for (int j = k; j < n; j++) digits[j] = '0';
                }

                String valStr = new String(digits);
                if (compare(valStr, maxValStr) > 0) maxValStr = valStr;
            }

            System.out.println(maxValStr);
        }
    }

    // helper: compares two numeric strings
    static int compare(String a, String b) {
        if (a.length() != b.length()) return a.length() - b.length();
        return a.compareTo(b);
    }
}
