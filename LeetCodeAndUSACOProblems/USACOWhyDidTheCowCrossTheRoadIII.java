package LeetCodeAndUSACOProblems;
//mark as done - no review needed
//logic : loop through sorted starttimes. sim questioning.
//if next arrives earlier, add to the end of previous because of wait time.
//else, just mark time as the starting and sim questioning.
//repeat and you get the answer!

import java.util.*;

public class USACOWhyDidTheCowCrossTheRoadIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> cows = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int duration = sc.nextInt();
            cows.add(new int[]{start, duration});
        }

        // Sort by start time
        cows.sort(Comparator.comparingInt(a -> a[0]));

        int nearestOpen = -1;
        for (int[] cow : cows) {
            int st = cow[0];
            int dur = cow[1];
            if (st > nearestOpen) {
                nearestOpen = st + dur;
            } else {
                nearestOpen += dur;
            }
        }
        System.out.println(nearestOpen);
    }
}
