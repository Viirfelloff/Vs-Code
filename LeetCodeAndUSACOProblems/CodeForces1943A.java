import java.util.*;
//CHANGE IMPLEMENTAITON 2/5 TO INCLUDE THE REMOVING EARLIER VALUES BEFORE ALICE GETS TO THEM IDEA
//THIS ALLOWS FOR AC, THIS IS INCOMPLETE APPROACH.
public class CodeForces1943A {
    public static void main(String[] args) {
        //IDEA FOR FULL SOLVE: so we want to remove a value before she gets to it.
        //the idea here maybe then is to try to remove each before she can 'get' to it
        //use this and the single removal idea, take the min.
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
            Set<Integer> imp = new HashSet<>();
            for (int x : list) {
                if (x < mex) imp.add(x);
            }
            List<Integer> impList = new ArrayList<>(imp);
            Collections.sort(impList);
            int ans = -1;
            if (mex == 0) System.out.println(0);
            else if (mex == 1) System.out.println(1);
            else {
                boolean valid = true;
                for (int j = 0; j < imp.size(); j++) {
                    if (impList.get(j) != 0) {
                        if (map.get(impList.get(j)) == 1) {
                            ans = impList.get(j);
                            valid = false;
                            break;
                        }
                    }
                }
                if (!valid) System.out.println(ans);
                else System.out.println(mex);
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
