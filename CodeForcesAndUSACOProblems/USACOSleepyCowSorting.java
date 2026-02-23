import java.io.*;
import java.util.*;

public class USACOSleepyCowSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("sleepy.out"));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        int ans = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) ans = i;
            else break;
        }
        pr.println(ans);
        pr.flush();
        pr.close();
        br.close();
    }
}
