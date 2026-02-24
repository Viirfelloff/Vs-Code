import java.io.*;
import java.util.*;
public class USACOContest2P2 {
    public static void main(String[] args) {
     ;  int nn = sc.nextInt();
        int k = sc.nextInt();
        Map<List<Integer>, Integer> occ = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int z = sc.nextInt() - 1;
            //String key = x + "," + y + "," + z;
            List<Integer> key = Arrays.asList(x,y,z);
            occ.put(key, occ.getOrDefault(key, 0) + 1);
        }
        List<int[]> triples = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        for (Map.Entry<List<Integer>, Integer> entry : occ.entrySet()) {
            List<Integer> s = entry.getKey();
            triples.add(new int[]{s.get(0), s.get(1), s.get(2)});
            weights.add(entry.getValue());
        }
        int ways = 0;
        int max = -1;
        for (int i = 0; i < 1<<nn; i++) {
            String mask = Integer.toBinaryString(i);
            int n = mask.length();
            int score = 0;
            for (int j = 0; j < triples.size(); j++) {
                int[] key = triples.get(j);
                int weight = weights.get(j);
                int idx1 = n - key[0] - 1;
                int idx2 = n - key[1] - 1;
                int idx3 = n - key[2] - 1;
                char c1 = ' ';
                char c2 = ' ';
                char c3 = ' ';
                if (idx1 < 0) c1 = 'O';
                else c1 = mask.charAt(idx1) == '0' ? 'O' : 'M';
                if (idx2 < 0) c2 = 'O';
                else c2 = mask.charAt(idx2) == '0' ? 'O' : 'M';
                if (idx3 < 0) c3 = 'O';
                else c3 = mask.charAt(idx3) == '0' ? 'O' : 'M';
                if (c1 == 'M' && c2 == 'O' && c3 == 'O') score += weight;
            }
            if (score > max) {
                max = score;
                ways = 1;
            }
            else if (score == max) ways++;
        }
        System.out.println(max + " " + ways);
    }
}