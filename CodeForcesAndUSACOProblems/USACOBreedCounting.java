import java.io.*;
import java.util.Scanner;

public class USACOBreedCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("bcount.out"));
        String[] ar = br.readLine().split(" ");
        int n = Integer.parseInt(ar[0]);
        int q = Integer.parseInt(ar[1]);
        int[] pfH = new int[n];
        int[] pfG = new int[n];
        int[] pfJ = new int[n];
        int hSum = 0;
        int gSum = 0;
        int jSum = 0;
        for (int i = 0; i < n; i++) {
            int breed = Integer.parseInt(br.readLine());
            if (breed == 1) {
                hSum++;
            } else if (breed == 2) {
                gSum++;
            } else {
                jSum++;
            }
            pfH[i] = hSum;
            pfG[i] = gSum;
            pfJ[i] = jSum;
        }
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int lower = Integer.parseInt(query[0]) - 1;
            int upper = Integer.parseInt(query[1]) - 1;

            int h, g, j;
            if (lower == 0) {
                h = pfH[upper];
                g = pfG[upper];
                j = pfJ[upper];
            } else {
                h = pfH[upper] - pfH[lower - 1];
                g = pfG[upper] - pfG[lower - 1];
                j = pfJ[upper] - pfJ[lower - 1];
            }

            pr.println(h + " " + g + " " + j);
        }
        pr.flush();
        br.close();
        pr.close();
    }
}
