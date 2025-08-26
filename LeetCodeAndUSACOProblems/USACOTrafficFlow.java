package LeetCodeAndUSACOProblems;
import java.util.*;
//BRO FINALLY FUCK THIS FUCKASS PROBLEM
public class USACOTrafficFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> types = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            types.add(s);
            intervals.add(new int[]{x,y});
        }
        List<String> mergedtypes = new ArrayList<>();
        List<int[]> mergedintervals = new ArrayList<>();
        String last = "";
        int laston = -1;
        int lastoff = -1;
        int idx = 0;
        for (int h = 0; h < n; h++) {
            String ss = types.get(h);
            int on = intervals.get(h)[0];
            int off = intervals.get(h)[1];
            if (ss.equals("none") && !mergedtypes.isEmpty() && mergedtypes.get(mergedtypes.size() - 1).equals("none")) {
                // merge into the last "none"
                int[] prev = mergedintervals.get(mergedintervals.size() - 1);
                prev[0] = Math.max(prev[0], on);
                prev[1] = Math.min(prev[1], off);
            } else {
                mergedtypes.add(ss);
                mergedintervals.add(new int[]{on, off});
            }
        }
        boolean one = false;
        if (mergedtypes.size() == 1) {
            System.out.println(mergedtypes.get(0));
            System.out.println(Arrays.toString(mergedintervals.get(0)));
        }
        //pick furthest and build up to get after
        if (!one) {
            int furth = -1;
            for (int m = mergedintervals.size() - 1; m >= 0; m--) {
                if (mergedtypes.get(m).equals("none")) {
                    furth = m;
                    break;
                }
            }
            boolean two = false;
            int[] currentfurthest = mergedintervals.get(furth).clone();
            if (furth == mergedintervals.size() - 1) two = true;
            if (!two) {
                for (int l = furth + 1; l < mergedtypes.size(); l++) {
                    if (mergedtypes.get(l).equals("on")) {
                        currentfurthest[0] += mergedintervals.get(l)[0];
                        currentfurthest[1] += mergedintervals.get(l)[1];
                    } else {
                        currentfurthest[0] -= mergedintervals.get(l)[1];
                        currentfurthest[1] -= mergedintervals.get(l)[0];
                    }
                }
            }
            boolean three = false;
            //backwards!
            int clos = -1;
            for (int p = 0; p < mergedintervals.size(); p++) {
                if (mergedtypes.get(p).equals("none")) {
                    clos = p;
                    break;
                }
            }
            int[] currentclosesest = mergedintervals.get(clos).clone();
            if (clos == 0) {
                three = true;
            }
            if (!three) {
                for (int q = clos - 1; q >= 0; q--) {
                    if (mergedtypes.get(q).equals("off")) {
                        currentclosesest[0] += mergedintervals.get(q)[0];
                        currentclosesest[1] += mergedintervals.get(q)[1];
                    } else {
                        currentclosesest[0] -= mergedintervals.get(q)[1];
                        currentclosesest[1] -= mergedintervals.get(q)[0];
                    }
                }
            }
            if (currentfurthest[0] < 0) {
                currentfurthest[0] = 0;
            }
            if (currentfurthest[1] < 0) {
                currentfurthest[1] = 0;
            }
            if (currentclosesest[0] < 0) {
                currentclosesest[0] = 0;
            }
            if (currentclosesest[1] < 0) {
                currentclosesest[1] = 0;
            }
            for (int e = 0; e < mergedintervals.size(); e++) {
                System.out.println(mergedtypes.get(e));
                System.out.println(Arrays.toString(mergedintervals.get(e)));
            }
            for (int k : currentclosesest) {
                System.out.println(k);
            }
            for (int z : currentfurthest) {
                System.out.println(z);
            }
        }
    }
}
