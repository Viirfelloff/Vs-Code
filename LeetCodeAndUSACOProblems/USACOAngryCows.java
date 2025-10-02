import java.io.*;
import java.util.*;

public class USACOAngryCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        int n = Integer.parseInt(br.readLine());
        int[] hay = new int[n];
        for (int i = 0; i < n; i++) {
            hay[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(hay);

        int ans = 0;

        for (int start = 0; start < n; start++) {
            int exploded = 1; // starting bale
            // simulate left
            int radius = 1;
            int left = start - 1;
            int farthest = hay[start];
            while (left >= 0) {
                int newFarthest = -1;
                while (left >= 0 && hay[left] >= farthest - radius) {
                    exploded++;
                    newFarthest = hay[left];
                    left--;
                }
                if (newFarthest == -1) break; // no new bale exploded
                farthest = newFarthest;
                radius++;
            }

            // simulate right
            radius = 1;
            int right = start + 1;
            farthest = hay[start];
            while (right < n) {
                int newFarthest = -1;
                while (right < n && hay[right] <= farthest + radius) {
                    exploded++;
                    newFarthest = hay[right];
                    right++;
                }
                if (newFarthest == -1) break;
                farthest = newFarthest;
                radius++;
            }

            ans = Math.max(ans, exploded);
        }

        out.println(ans);
        out.close();
    }
}
