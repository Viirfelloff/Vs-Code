package CodeForcesAndUSACOProblems;

import java.util.*;
//we absolutely cooked on this one
public class USACOPhotoshoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(sc.nextInt());
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 1; j <= list.getFirst(); j++) {
            boolean found1 = true;
            boolean found2 = true;
            List<Integer> pos = new ArrayList<>();
            Set<Integer> seen = new HashSet<>();
            pos.add(j);
            int current = list.getFirst() - j;
            pos.add(current);
            for (int k = 1; k < list.size(); k++) {
                current = Math.abs(current - list.get(k));
                pos.add(current);
            }
            //check
            for (int b : pos) {
                if (!(b > 0 && b <= n)) {
                    found1 = false;
                    break;
                }
            }
            for (int c : pos) {
                if (seen.contains(c)) {
                    found2 = false;
                    break;
                } else {
                    seen.add(c);
                }
            }
            if (found1 && found2) {
                result = pos;
                break;
            }
        }
        for (int h : result) System.out.println(h);
    }
}
