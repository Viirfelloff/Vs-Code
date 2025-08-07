package LeetCodeAndUSACOProblems;

import java.lang.reflect.Array;
import java.util.*;

//les go normal problem all by myself
public class USACOCowGymnastics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list2.add(x);
            }
            list1.add(list2);
        }
        Map<List<Integer>, Integer> map1 = new HashMap<>();
        for (int m = 0; m < n; m++) {
            for (int l = m + 1; l < n; l++) {
                map1.put(Arrays.asList(list1.getFirst().get(l), list1.getFirst().get(m)), 0);
            }
        }
        for (int iii = 1; iii < k; iii++) {
            for (List<Integer> fuckts : map1.keySet()) {
                if (list1.get(iii).indexOf(fuckts.get(0)) > list1.get(iii).indexOf(fuckts.get(1))) {
                    map1.put(fuckts, map1.get(fuckts) + 1);
                }
            }
        }
        int validPairs = 0;
        for (int yyyy : map1.values()) {
            if (yyyy == k - 1) validPairs++;
        }
        System.out.println(validPairs);
    }
}
