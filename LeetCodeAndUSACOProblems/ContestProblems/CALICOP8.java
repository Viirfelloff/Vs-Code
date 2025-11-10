import java.util.Scanner;

public class CALICOP8 {

    // Expand the string by replacing each 'O' with the string itself, n times
    public static String expandString(String s, int n) {
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'O') {
                    sb.append(s); // replace O with the string itself
                } else {
                    sb.append(c);
                }
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            String expanded = expandString(s, 2);
            int currentLayer = 0;
            int count = 0;
            for (char c : expanded.toCharArray()) {
                if (c == '(') currentLayer++;
                else if (c == ')') currentLayer--;
                else if (c == '|') {
                    if (currentLayer == k) count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
