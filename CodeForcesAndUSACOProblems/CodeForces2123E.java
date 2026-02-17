import java.util.*;
public class CodeForces2123E {
    public static void main(String[] args) {
        //your apporoach is completely incorrect and horribly implemented.
        //kill yourself
        //anyways how we should think about it is, for each element, store the possible Ks.
        //create a map of the upper bound of k that you can afford per element
        //precompute an array that stores the result as a result of this.
        //then access that array for each k and print result.
        //how do we store the possible k's?
        //for each element to become the mex, we need all the elements before
        //as well as removing that element
        //anything otherwise and also duplicates of contributing elements are buffers.
        //the remove count plus buffers is the max K you can afford.
        //IMPLEMENT 2/17.
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
                list.add(x);
            }
            int curMex = getMex(list);
            Collections.sort(list);
            Set<Integer> set = new HashSet<>(list);
            int buffers = 0;
            int contribute = 0;
            for (int x : list) {
                if (x < curMex) {
                    contribute++;
                }
            }
            for (int x : set) {
                if (x < curMex) {
                    buffers += freq.get(x) - 1;
                }
            }
            buffers += n - contribute;
            Map<Integer, Integer> toremoveformex = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (list.get(j) < curMex) {
                    if (list.get(j) == 0) {
                        toremoveformex.put(list.get(j), freq.get(list.get(j)));
                    } else toremoveformex.put(list.get(j), freq.get(list.get(j)));
                }
            }
            for (int k = 0; k <= n; k++) {
                if (k == 0 || k == n) System.out.print(1 + " ");
                else {
                    int mex = 0;
                    int inc = 0;
                    for (int x : set) {
                        if (x < curMex) if (k >= toremoveformex.get(x) && (buffers) >= k - toremoveformex.get(x)) mex++;
                    }
                    if (buffers >= k) mex++;
                    System.out.print(mex + " ");
                }
            }
            System.out.println();
        }
    }
    public static int getMex(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int j = 0; j < set.size(); j++) {
            if (!set.contains(j)) return j;
        }
        return set.size();
    }
}
