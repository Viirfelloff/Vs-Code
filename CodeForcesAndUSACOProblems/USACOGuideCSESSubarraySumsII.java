import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class USACOGuideCSESSubarraySumsII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Long> pf = new ArrayList<>();
        long sum = 0;
        for (int j = 0; j < n; j++) {
            long xx = Long.parseLong(st.nextToken());
            sum += xx;
            pf.add(sum);
        }
        Map<Long, Integer> seen = new HashMap<>();
        long count = 0;
        for (int j = 0; j < n; j++) {
            if (seen.containsKey(pf.get(j) - x)) count += seen.get(pf.get(j) - x);
            seen.put(pf.get(j), seen.getOrDefault(pf.get(j), 0) + 1);
        }
        if (seen.containsKey(x)) count += seen.get(x);
        System.out.println(count);
    }
}
