import java.io.*;
import java.util.*;
public class USACOWhyDidTheCowCrossTheRoadIISilver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("maxcross.out"));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        int b = Integer.parseInt(in[2]);
        Set<Integer> broken = new HashSet<>();
        for (int j = 0; j < b; j++) broken.add(Integer.parseInt(br.readLine()));
        int[] pf = new int[n];
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            sum += broken.contains(j) ? 1 : 0;
            pf[j - 1] = sum;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= n - k; j++) {
            int value = j == 0 ? pf[j + k - 1] : pf[j + k - 1] - pf[j - 1];
            if (value < min) min = value;
        }
        pr.println(min);
        pr.flush();
        br.close();
        pr.close();
    }
}
