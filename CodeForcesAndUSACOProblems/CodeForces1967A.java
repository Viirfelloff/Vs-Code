import java.util.*;
public class CodeForces1967A {
    //I FUCKING HATE THIS PROBLEM. IT WILL FOREVER BE MY MOST DISLIKED PROBLEM OF ALL TIME.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //to start, distrubute k.
            //do this by adding it to the min number to increase to the next number.
            //if all numbers become equal, then distribute it evenly using mod operations
            //the result will be n * (min of counts) - n + 1.
            //edge case: n = 1.
            //HOWEVER, leftovers pose a huge problem.
            //we can repeat the sequence in whatever order we want. when we have leftover numbers, we can layer them on both sides.
            //this can only help if the numbers are ordered in a certain way.
            //making sure adding on elements is effective is not worth it.
            //so, if we place the element that runs out first at the end of the sequence, then it will be exposed.
            //this will allow us to use the extras to make exactly n - 1 more subarrays at the end.
            //at the beginning, this will force us to put it at the end, leading to no gain in the beginning from addig on.
            //if this is reversed, same observation holds.
            //note: this will never be the case if all counts are the same.
            //so the final process is distribute k, determine base count, and manipulate if any extras are present.
            int n = sc.nextInt();
            long k = sc.nextLong();
            List<Long> list = new ArrayList<>();
            Map<Long, List<Integer>> freq = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long x = sc.nextLong();
                list.add(x);
                List<Integer> occ;
                if (!freq.containsKey(x)) occ = new ArrayList<>();
                else occ = freq.get(x);
                occ.add(j);
                freq.put(x, occ);
            }
            if (n == 1) System.out.println(list.get(0) + k);
            else {
                Set<Long> set = new HashSet<>(list);
                List<Long> sorted = new ArrayList<>(set);
                Collections.sort(sorted);
                while (k != 0 && sorted.size() != 1) {
                    long min = sorted.get(0);
                    long next = sorted.get(1);
                    List<Integer> occ = freq.get(min);
                    List<Integer> occ1 = new ArrayList<>(occ);
                    List<Integer> occ2 = freq.get(next);
                    long inc = next - min;
                    for (int j = 0; j < occ.size(); j++) {
                        occ1.remove(Integer.valueOf(occ.get(j)));
                        long add = Math.min(inc, k);
                        list.set(occ.get(j), list.get(occ.get(j)) + add);
                        k -= add;
                        if (add == inc) {
                            occ2.add(occ.get(j));
                        }
                        if (k == 0) break;
                    }
                    sorted.remove(0);
                    if (!occ1.isEmpty()) freq.put(min, occ1);
                    else freq.remove(min);
                    if (!occ2.isEmpty()) freq.put(next, occ2);
                    else freq.remove(next);
                }
                if (sorted.size() == 1 && k != 0) {
                    long mod = k % n;
                    long multiple = (k - mod) / n;
                    for (int j = 0; j < n; j++) {
                        List<Integer> old = freq.get(list.get(j));
                        old.remove(Integer.valueOf(j));
                        freq.put(list.get(j), old);
                        if (old.isEmpty()) freq.remove(list.get(j));
                        list.set(j, list.get(j) + (multiple));
                        List<Integer> occ;
                        if (!freq.containsKey(list.get(j))) occ = new ArrayList<>();
                        else occ = freq.get(list.get(j));
                        occ.add(j);
                        freq.put(list.get(j), occ);
                    }
                    for (int j = 0; j < mod; j++) {
                        List<Integer> old = freq.get(list.get(j));
                        old.remove(Integer.valueOf(j));
                        freq.put(list.get(j), old);
                        if (old.isEmpty()) freq.remove(list.get(j));
                        list.set(j, list.get(j) + 1);
                        List<Integer> occ;
                        if (!freq.containsKey(list.get(j))) occ = new ArrayList<>();
                        else occ = freq.get(list.get(j));
                        occ.add(j);
                        freq.put(list.get(j), occ);
                    }
                }
                long min = Integer.MAX_VALUE;
                long max = Integer.MIN_VALUE;
                for (long x : list) {
                    if (x < min) min = x;
                    if (x > max) max = x;
                }
                int nonmin = 0;
                for (long x : list) if (x != min) nonmin++;
                System.out.println(min == max ? n * min - n + 1 : n * min - n + 1 + nonmin);
            }
        }
    }
}
