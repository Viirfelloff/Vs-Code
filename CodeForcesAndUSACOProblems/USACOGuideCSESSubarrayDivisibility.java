import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class USACOGuideCSESSubarrayDivisibility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        long[] pf = new long[n];
        long sum = 0;
        for (int j = 0; j < n; j++) {
            sum += Long.parseLong(in[j]);
            pf[j] = sum;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        for (long x : pf) {
            long mod = ((x % n) + n) % n;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        long res = 0;
        for (long x : map.keySet()) {
            long freq = map.get(x);
            res += (freq * (freq - 1L)) / 2;
        }
        System.out.println(res);
    }
}
