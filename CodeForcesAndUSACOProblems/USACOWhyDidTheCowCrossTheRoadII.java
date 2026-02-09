package CodeForcesAndUSACOProblems;
import java.util.*;
//we get the idea..
public class USACOWhyDidTheCowCrossTheRoadII {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();  // length 52
        Map<Character, int[]> map1 = new LinkedHashMap<>();
        char[] alpha = new char[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char) ('A' + i);
        }
        for (int j = 0; j < 26; j++) {
            char A = alpha[j];
            int start = -1;
            int end = -1;
            for (int k = 0; k < 52; k++) {
                if (s.charAt(k) == A) {
                    if (start == -1) {
                        start = k;
                    } else {
                        end = k;
                        break;  // no need to continue since each char appears exactly twice
                    }
                }
            }
            map1.put(A, new int[]{start, end});
        }
        int inc1 = 0;
        for (char xx : map1.keySet()) {
            int inc2 = 0;
            for (char xy : map1.keySet()) {
                if (inc1 != inc2) {
                    int start1 = map1.get(xx)[0];
                    int end1 = map1.get(xx)[1];
                    int start2 = map1.get(xy)[0];
                    int end2 = map1.get(xy)[1];
                    if ((start1 < start2 && start2 < end1 && end1 < end2) || (start2 < start1 && start1 < end2 && end2 < end1)) {
                        count++;
                    }
                }
                inc2++;
            }
            inc1++;
        }
        System.out.println(count / 2);
    }
}
