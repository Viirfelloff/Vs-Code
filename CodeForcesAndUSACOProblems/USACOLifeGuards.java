package CodeForcesAndUSACOProblems;
import java.util.*;
//minimal help so we good
public class USACOLifeGuards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] covered = new boolean[1001];
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int st = start; st < end; st++) {
                covered[st] = true;
            }
            starts.add(start);
            ends.add(end);
        }
        ArrayList<Integer> cover = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            boolean[] mod = new boolean[1001];
            for (int j = 0; j < n; j++) {
                if (k != j) {
                    for (int stt = starts.get(j); stt < ends.get(j); stt++) {
                        mod[stt] = true;
                    }
                }
            }
            int count = 0;
            for (boolean xx : mod) {
                if (xx) count++;
            }
            cover.add(count);
        }
        System.out.println(Collections.max(cover));
    }
}
