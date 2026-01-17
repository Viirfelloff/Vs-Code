import java.util.*;

public class USACOWalkingOnAFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        Map<Integer, Integer> lines = new LinkedHashMap<>();
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
        //each of the above arrayLists for each post labeled i returns the sum of traversing between posts. [0] = x sum, [1] = y sums
        //one traverses clockwise, one traverses anticlockwise.
        //build prefix sums
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
        }
    }
}
