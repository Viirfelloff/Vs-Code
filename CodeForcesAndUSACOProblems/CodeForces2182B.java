import java.util.Scanner;
public class CodeForces2182B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int a1 = a;
            int b1 = b;
            int layers = 0;
            int currentSize = 0;
            boolean white = false;
            while (true) {
                double size = Math.pow(2,currentSize);
                if (white) {
                    if (a >= size) {
                        layers++;
                        a -= (int) size;
                    } else break;
                } else {
                    if (b >= size) {
                        layers++;
                        b -= (int) size;
                    } else break;
                }
                currentSize++;
                white = !white;
            }
            int layers2 = 0;
            int currentSize2 = 0;
            boolean white2 = true;
            while (true) {
                double size = Math.pow(2,currentSize2);
                if (white2) {
                    if (a1 >= size) {
                        layers2++;
                        a1 -= (int) size;
                    } else break;
                } else {
                    if (b1 >= size) {
                        layers2++;
                        b1 -= (int) size;
                    } else break;
                }
                currentSize2++;
                white2 = !white2;
            }
            System.out.println(Math.max(layers, layers2));
        }
    }
}
