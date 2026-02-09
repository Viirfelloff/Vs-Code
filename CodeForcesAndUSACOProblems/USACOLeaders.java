import java.util.*;

public class USACOLeaders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        List<Integer> lists = new ArrayList<>();
        //firstleader
        int firstHIdx = 0;
        int firstGIdx = 0;
        int lastHIdx = 0;
        int lastGIdx = 0;
        for (int i = 0; i < n; i++) {
            lists.add(sc.nextInt());
        }
        int idx = 0;
        for (char c: s.toCharArray()) {
            if (c == 'H') {
                firstHIdx = idx;
                break;
            }
            idx++;
        }
        int idx2 = 0;
        for (char c: s.toCharArray()) {
            if (c == 'G') {
                firstGIdx = idx;
                break;
            }
            idx2++;
        }
        int idx3 = s.length() - 1;
        for (int k = idx3; k >= 0; k--) {
            if (s.charAt(k) == 'G') {
                idx3 = k;
                break;
            }
        }
        int idx4 = s.length() - 1;
        for (int kk = idx3; kk >= 0; kk--) {
            if (s.charAt(kk) == 'H') {
                idx4 = kk;
                break;
            }
        }
        lastGIdx = idx3;
        lastHIdx = idx4;
        Set<Integer> firstLeaders = new HashSet<>();
        if ((lists.get(firstHIdx) - 1) >= lastHIdx) {
            firstLeaders.add(firstHIdx);
        }
        if ((lists.get(firstGIdx) - 1) >= lastGIdx) {
            firstLeaders.add(firstGIdx);
        }
        //secondleaders
        Set<Integer> secondLeaders = new HashSet<>();
        int inc = 0;
        for (int x : lists) {
            int lower = inc;
            int upper = x - 1;
            inc++;
        }
    }
}