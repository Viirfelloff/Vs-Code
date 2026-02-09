import java.util.Arrays;
import java.util.Scanner;

public class CodeForcesWarmup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();
        long curX = 0;
        long tilesX = 0;
        long curY = 0;
        long tilesY = 0;
        while (curX <= m) {
            curX += a;
            tilesX++;
        }
        while (curY <= n) {
            curY += a;
            tilesY++;
        }
        
    }
}
