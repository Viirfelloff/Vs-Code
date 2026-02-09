import java.util.Scanner;
//absolute fucking fail, u suck and ur never getting good
public class CodeForces2113B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long w = sc.nextLong();
            long h = sc.nextLong();
            long sq1x = sc.nextLong();
            long sq1y = sc.nextLong();
            long sq2x = sc.nextLong();
            long sq2y = sc.nextLong();
            long xDiff = (sq1x - sq2x);
            long yDiff = (sq1y - sq2y);
            boolean x = (sq1x != sq2x) && (xDiff % a == 0);
            boolean y = (sq1y != sq2y) && (yDiff % b == 0);
            boolean comb = (x || y);
            if (comb) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
