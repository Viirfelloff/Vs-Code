import java.io.*;
import java.util.ArrayList;
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

        pr.flush();
        pr.close();
        br.close();
    }
}
