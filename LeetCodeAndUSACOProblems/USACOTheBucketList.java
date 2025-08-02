package LeetCodeAndUSACOProblems;

import java.io.IOException;
import java.util.*;

public class USACOTheBucketList {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cowsignal");
        int n = io.nextInt();
        ArrayList<Integer> maxfinder = new ArrayList<>();
        Set<Integer> bucketsbeingused = new HashSet<>();
        Map<int[], Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x =  io.nextInt();
            int y = io.nextInt();
            maxfinder.add(x);
            maxfinder.add(y);
            int z  = io.nextInt();
            map1.put(new int[] {x,y}, z);
        }
        for (int k = 0; k < Collections.max(maxfinder); k++) {
            int bbused = 0;
            for (int[] xx : map1.keySet()) {
                if (k <= xx[1] && k >= xx[0]) {
                    bbused += map1.get(xx);
                }
            }
            bucketsbeingused.add(bbused);
        }
        io.close();
        System.out.println(Collections.max(bucketsbeingused));
    }
}

