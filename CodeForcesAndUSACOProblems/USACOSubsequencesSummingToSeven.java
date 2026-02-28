import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class USACOSubsequencesSummingToSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("div7.out"));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        long[] pf = new long[n];
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(br.readLine());
            pf[i] = sum;
        }
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long range = i == 0 ? pf[j] : pf[i - 1] - pf[j];
                if (range % 7 == 0) {
                    if (j - i + 1 > maxLength) maxLength = j - i + 1;
                }
            }
        }
        pr.println(maxLength);
        pr.flush();
        pr.close();
        br.close();
    }
}
