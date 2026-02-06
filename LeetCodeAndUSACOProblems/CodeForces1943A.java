import java.util.*;
public class CodeForces1943A {
    //alice saves smallest such that occ = 1.
    //then bob deletes the next one. this is the result.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                list.add(x);
                map.put(x, map.getOrDefault(x,0) + 1);
            }
            int mex = getMex(list);
            Set<Integer> lessThanMEX = new HashSet<>();
            for (int x : list) {
                if (x < mex) lessThanMEX.add(x);
            }
            List<Integer> lessThanMEXList = new ArrayList<>(lessThanMEX);
            Collections.sort(lessThanMEXList);
            if (mex == 0) System.out.println(0);
            else if (mex == 1) System.out.println(1);
            else {
                int oneFreq = 0;
                for (int x : lessThanMEXList) {
                    if (map.get(x) == 1) oneFreq++;
                }
                if (oneFreq == 0 || oneFreq == 1) System.out.println(mex);
                else {
                    boolean first = false;
                    int ans = -1;
                    for (int x : lessThanMEXList) {
                        if (map.get(x) == 1 && !first) first = true;
                        else if (map.get(x) == 1 && first) {
                            ans = x;
                            break;
                        }
                    }
                    System.out.println(ans);
                }
            }
        }
    }
    public static int getMex(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i < set.size(); i++) {
            if (!set.contains(i)) return i;
        }
        return set.size();
    }
}
