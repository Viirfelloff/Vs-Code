package LeetCodeAndUSACOProblems.ContestProblems;
import java.util.*;

public class CodeForcesDiv2ContestA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = (sc.nextInt());
        for (int i = 0; i < t;i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            Set<Integer> occ = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                nums.add(x);
                occ.add(x);
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            List<Integer> lengths = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                //k = number of occurences per element
                int times = k + 1;
                if (times == 1) {
                    lengths.add(occ.size());
                } else {
                    int length = 0;
                    for (int xx : map.keySet()) {
                        if (map.get(xx) >= times) length += times;
                    }
                    lengths.add(length);
                }
            }
            System.out.println(Collections.max(lengths));
        }
    }
}