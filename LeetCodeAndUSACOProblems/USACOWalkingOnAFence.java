import java.util.*;

public class USACOWalkingOnAFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        //key = the constant, int[0] = start, int[1] = end, int[2] = number of the start post (index)
        //end post = index + 1. if it equals p, the index is really zero.
        Map<Integer, int[]> lineXClock = new LinkedHashMap<>();
        Map<Integer, int[]> lineYClock = new LinkedHashMap<>();
        Map<Integer, int[]> lineXAT = new LinkedHashMap<>();
        Map<Integer, int[]> lineYAT = new LinkedHashMap<>();
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pos.add(new int[]{x, y});
        }
        List<int[]> stendpos = new ArrayList<>();
        for (int i = 0; i < n; i++) stendpos.add(new int[]{sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()});
        List<Integer> pfSclock = new ArrayList<>();
        List<Integer> pfSatClock = new ArrayList<>();
        int curSum1 = 0;
        pfSclock.add(curSum1);
        for (int i = 1; i <= p; i++) {
            int[] curCoord = new int[]{0};
            int[] coord2 = new int[]{0};
            if (i == p) {
                curCoord = pos.get(0);
                coord2 = pos.get(p - 1);
            } else {
                curCoord = pos.get(i);
                coord2 = pos.get(i - 1);
            }
            int xOffset = Math.abs(curCoord[0] - coord2[0]);
            int yOffset = Math.abs(curCoord[1] - coord2[1]);
            curSum1 += xOffset + yOffset;
            pfSclock.add(curSum1);
            if (xOffset == 0) {
                lineXClock.put(curCoord[0], new int[]{coord2[1], curCoord[1], i - 1});
            } else {
                lineYClock.put(curCoord[1], new int[]{coord2[0], curCoord[0], i - 1});
            }
        }
        int curSum2 = 0;
        pfSatClock.add(curSum2);
        for (int i = p - 1; i >= 0; i--) {
            int[] curCoord = pos.get(i);
            int[] coord2;
            if (i == p - 1) {
                coord2 = pos.get(0);
            } else {
                coord2 = pos.get(i + 1);
            }
            int xOffset = Math.abs(curCoord[0] - coord2[0]);
            int yOffset = Math.abs(curCoord[1] - coord2[1]);
            curSum2 += xOffset + yOffset;
            pfSatClock.add(curSum2);
            if (xOffset == 0) {
                lineXAT.put(curCoord[0], new int[]{coord2[1], curCoord[1]});
            } else {
                lineYAT.put(curCoord[1], new int[]{coord2[0], curCoord[0]});
            }
        }
        switchAndDelete(pfSclock);
        switchAndDelete(pfSatClock);
        for (int j = 0; j < n; j++) {
            int[] st = new int[]{stendpos.get(j)[0], stendpos.get(j)[1]};
            int[] end = new int[]{stendpos.get(j)[2], stendpos.get(j)[3]};
            int clockDistance = 0;
            int antiClockDistance = 0;

        }
    }
    public static void switchAndDelete(List<Integer> list) {
        //switch last and first
        int temp = list.get(list.size() - 1);
        list.set(list.size() - 1, list.get(0));
        list.set(0, temp);
        list.remove(list.size() - 1);
    }
}
