import java.util.Scanner;

public class USACOEvenMoreOddPhotos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int O = 0, E = 0;
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x % 2 == 0) E++;
            else O++;
        }
        int res = 0;
        int parity = 0;
        while (O > 0 || E > 0) {
            if (parity % 2 == 0) {
                if (E > 0) {
                    res++;
                    E--;
                } else if (O >= 2) {
                    res++;
                    O -= 2;
                } else if (O == 1) {
                    res--;
                    break;
                }
            } else {
                if (O > 0) {
                    res++;
                    O--;
                } else break;
            }
            parity++;
        }
        System.out.println(res);
    }
}
