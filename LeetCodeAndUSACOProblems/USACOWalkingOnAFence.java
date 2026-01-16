package LeetCodeAndUSACOProblems;

import javax.swing.text.MutableAttributeSet;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOWalkingOnAFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        //prefix sum left and right from starting point
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < p; i++) pos.add(new int[]{sc.nextInt(), sc.nextInt()});
        List<int[]> stendpos = new ArrayList<>();
        for (int i = 0; i < n; i++) stendpos.add(new int[]{sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()});
        List<int[]> pfSclock = new ArrayList<>();
        List<int[]> pfSatClock = new ArrayList<>();
        //each of the above arrayLists for each post labeled i returns the sum of traversing between posts. [0] = x sum, [1] = y sums
        //one traverses clockwise, one traverses anticlockwise.
        //build prefix sums
        int curXSum1 = 0;
        int curYSum1 = 0;
        pfSclock.add(new int[]{curXSum1, curYSum1});
        for (int i = 1; i < p; i++) {
            int[] curCoord = pos.get(i);
            int[] coord2 = pos.get(i - 1);
            int xOffset = Math.abs(curCoord[0] - coord2[0]);
            int yOffset = Math.abs(curCoord[1] - coord2[1]);
            curXSum1 += xOffset;
            curYSum1 += yOffset;
            pfSclock.add(new int[]{curXSum1, curYSum1});
        }
        int curXSum2 = 0;
        int curYSum2 = 0;
        pfSatClock.add(new int[]{curXSum2, curYSum2});
        for (int i = p - 1; i > 0; i--) {
            int[] curCoord = pos.get(i);
            int[] coord2;
            if (i == p - 1) {
                coord2 = pos.get(0);
            } else {
                coord2 = pos.get(i + 1);
            }
            int xOffset = Math.abs(curCoord[0] - coord2[0]);
            int yOffset = Math.abs(curCoord[1] - coord2[1]);
            curXSum2 += xOffset;
            curYSum2 += yOffset;
            pfSatClock.add(new int[]{curXSum2, curYSum2});
        }
        //for each point navigate to the nearest post to the sp
        //if it is behind, take dist and add to travel dist later
        //if it is ahead, take dist and subtract from travel dist later
        //then take the sp and get the nearest point. if it is ahead take dist and add later
        //if it is behind the nearest point take dist and subtract later.
        //take two rounded points + offsets and do pfs subtraction for clockwise and anticlockwise.
        //add offsets and take minimum.

    }
}
