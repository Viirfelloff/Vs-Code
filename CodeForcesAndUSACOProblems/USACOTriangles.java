package CodeForcesAndUSACOProblems;
//We got the logic. just learn to use the maxfinder instead of collections.max to save memory.
import java.util.*;
public class USACOTriangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xs.add(sc.nextInt());
            ys.add(sc.nextInt());
        }
        List<Double> areas = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            List<Integer> sameXcoordY = new ArrayList<>();
            List<Integer> sameYcoordX = new ArrayList<>();
            int x1 = xs.get(j);
            int y1 = ys.get(j);
            for (int k = 0; k < n; k++) {
                if (j != k) {
                    int x2 = xs.get(k);
                    int y2 = ys.get(k);
                    if (x1 == x2) {
                        sameXcoordY.add(y2);
                    }
                    if (y1 == y2) {
                        sameYcoordX.add(x2);
                    }
                }
            }
            if (!sameYcoordX.isEmpty() && !sameXcoordY.isEmpty()) {
                int maxDiffY = Math.abs(sameXcoordY.get(0) - y1);
                for (int num : sameXcoordY) {
                    int diffY = Math.abs(num - y1);
                    if (diffY > maxDiffY) {
                        maxDiffY = diffY;
                    }
                }
                //At this point, coords are x1, y1, x1, farthestY. now we need farthestX, y1.
                int maxDiffX = Math.abs(sameYcoordX.get(0) - x1);
                for (int num2 : sameYcoordX) {
                    int diffX = Math.abs(num2 - x1);
                    if (diffX > maxDiffX) {
                        maxDiffX = diffX;
                    }
                }
                //Last coord - farthestX, y1.
                //Calculate Area using maxdiffY and maxdiffX.
                areas.add((maxDiffX * maxDiffY) / 2.0);
            }
        }
        System.out.println((int) (Collections.max(areas) * 2));
    }
}
