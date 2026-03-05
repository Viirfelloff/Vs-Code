import java.util.*;
public class CodeForces2045C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        //so im starting to think that this is not a 1400 problem.
        //because now we know that its the minimum, the answer is obvious and trivial with some greedy
        Map<Character, List<Integer>> map = new HashMap<>();
        //maybe add -1 to b.length?
        for (int i = 0; i < b.length() - 1; i++) {
            List<Integer> occ;
            if (map.containsKey(b.charAt(i))) occ = map.get(b.charAt(i));
            else occ = new ArrayList<>();
            occ.add(i);
            map.put(b.charAt(i), occ);
        }
        boolean found = false;
        int aidx = -1;
        int bidx = -1;
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                found = true;
                aidx = i;
                List<Integer> idxes = map.get(a.charAt(i));
                for (int j = map.get(a.charAt(i)).size() - 1; j >= 0; j--) {
                    if (idxes.get(j) != b.length() - 1) {
                        bidx = idxes.get(j);
                        break;
                    }
                }
                ans.add(new int[]{aidx, bidx});
            }
        }
        if (found) {
            if (bidx == -1) System.out.println(-1);
            else {
                int min = Integer.MAX_VALUE;
                int[] ref = new int[2];
                for (int[] pair : ans) {
                    int len = pair[0] + b.length() - pair[1];
                    if (len < min) {
                        min = len;
                        ref = new int[]{pair[0], pair[1]};
                    }
                }
                System.out.println(a.substring(0, ref[0] + 1) + b.substring(ref[1] + 1));
            }
        } else System.out.println(-1);
    }
}
