import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class USACOSilverPairedUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("pairup.out"));
        int n = Integer.parseInt(br.readLine());
        List<long[]> coords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            coords.add(new long[]{Long.parseLong(in[0]), Long.parseLong(in[1])});
        }
        long max = Long.MIN_VALUE;
        int p1 = 0;
        int p2 = n - 1;
        coords.sort(Comparator.comparingLong(a -> a[1]));
        while (p1 <= p2) {
            long[] coord1 = coords.get(p1);
            long[] coord2 = coords.get(p2);
            //form the max pairs that you can
            long pairs = Math.min(coord1[0], coord2[0]);
            long count1 = coord1[0] - pairs;
            long count2 = coord2[0] - pairs;
            //update each
            coords.set(p1, new long[]{count1, coord1[1]});
            coords.set(p2, new long[]{count2, coord2[1]});
            if (count1 == 0) p1++;
            if (count2 == 0) p2--;
            long sum = coord1[1] + coord2[1];
            if (sum > max) max = sum;
            if (p1 == p2) {
                //we have reached one group, so just pair the rest of these cows w each other
                long[] coord = coords.get(p1);
                long sum2 = 2 * coord[1];
                if (sum2 > max) max = sum2;
                break;
            }
        }
        pr.println(max);
        pr.flush();
        pr.close();
        br.close();
    }
}
