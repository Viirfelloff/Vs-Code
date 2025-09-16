package LeetCodeAndUSACOProblems;
import java.io.*;
import java.util.*;

public class USACOGuessTheAnimla {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<String> animal = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        List<List<String>> chars = new ArrayList<>();
        Map<String, Integer> collective = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            animal.add(st.nextToken());
            int kk = Integer.parseInt(st.nextToken());
            k.add(kk);
            List<String> ch = new ArrayList<>();
            for (int j = 0; j < kk; j++) {
                String c = st.nextToken();
                ch.add(c);
                collective.put(c, collective.getOrDefault(c, 0) + 1);
            }
            chars.add(ch);
        }

        List<Integer> yes = new ArrayList<>();
        for (int m = 0; m < n; m++) {
            int ye = 0;
            List<String> chs = chars.get(m);
            chs.sort((a, b) -> collective.get(b) - collective.get(a));
            for (String mm : chs) {
                if (collective.get(mm) > 1) ye += 1;
                else {
                    ye += 1;
                    break;
                }
            }
            yes.add(ye);
        }

        out.println(Collections.max(yes));
        out.close();
    }
}
