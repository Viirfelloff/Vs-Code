package CodeForcesAndUSACOProblems;

import java.util.*;

public class CodeForces2187A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            Map<Long, List<Integer>> occ = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                if (occ.containsKey(x)) {
                    List<Integer> listt = occ.get(x);
                    listt.add(j);
                    occ.put(x,listt);
                } else {
                    List<Integer> listt = new ArrayList<>();
                    listt.add(j);
                    occ.put(x,listt);
                }
                list.add(x);
            }
            //idea: this is really scuffed but take all the numbers and search in ascenidng order
            //then, for each number, see the number in the sequence it is farthest away from.
            //using min and max for the above. if it is already in the desired spot,
            //add to list and swap. then change array. if not, we need to swap something else for it
            //so that number in the spot rn and the desired number swap + into place swap have to maximize k.
            //to do this, if they have the same farthest away number, leave it. if not, do some compromise idk.
            //then perform both swaps. keep a list of in palce and not in palce.
            //if u deisre a number and it is in place, u need to perform 3 swaps to put it back afterward.
            //this should be the best strategy
            Set<Long> inPlace = new HashSet<>();
            long min = Collections.min(list);
            long max = Collections.max(list);
            List<Long> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            for (long x : sorted) {
                long farthest = Math.max(Math.abs(x - min), Math.abs(x - max)) == Math.abs(x - max) ? max : min;
                if (inPlace.contains(x)) {

                } else {
                    inPlace.add(x);
                }
            }
        }
    }
}
