import java.util.Scanner;

public class CALICORemixP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int current = 0;
            int curCounter = 1;
            for (char c: s.toCharArray()) {
                if (c == 'T') {
                    current += curCounter;
                    curCounter = 1;
                }
                else curCounter *= 2;
            }
            System.out.println(current);
        }
    }
}