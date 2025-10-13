import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2056A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<int[]> coords = new ArrayList<>();
            for (int j = 0; j < n; j++) coords.add(new int[]{sc.nextInt(), sc.nextInt()});
            int total = m*4;
            int currentx1 = 0;
            int currenty1 = 0;
            int currentx2 = m;
            int currenty2 = m;
            for (int k = 1; k < n; k++) {
                int newx1 = currentx1 + coords.get(k)[0];
                int newx2 = currentx2 + coords.get(k)[0];
                int newy1 = currenty1 + coords.get(k)[1];
                int newy2 = currenty2 + coords.get(k)[1];
                int x_overlap = Math.max(0, Math.min(currentx2, newx2) - Math.max(currentx1, newx1));
                int y_overlap = Math.max(0, Math.min(currenty2, newy2) - Math.max(currenty1, newy1));
                total += 4*m - 2*(x_overlap + y_overlap);
                currentx1 += coords.get(k)[0];
                currentx2 += coords.get(k)[0];
                currenty1 += coords.get(k)[1];
                currenty2 += coords.get(k)[1];
            }
            System.out.println(total);
        }
    }
}
