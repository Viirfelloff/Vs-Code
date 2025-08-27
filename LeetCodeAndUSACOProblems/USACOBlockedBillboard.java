package LeetCodeAndUSACOProblems;

import java.util.Scanner;
//lowk failed but at least we learned formulas
public class USACOBlockedBillboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b1x1 = sc.nextInt();
        int b1y1 = sc.nextInt();
        int b1x2 = sc.nextInt();
        int b1y2 = sc.nextInt();
        int b2x1 = sc.nextInt();
        int b2y1 = sc.nextInt();
        int b2x2 = sc.nextInt();
        int b2y2 = sc.nextInt();
        int tx1 = sc.nextInt();
        int ty1 = sc.nextInt();
        int tx2 = sc.nextInt();
        int ty2 = sc.nextInt();
        //check for truck and b1 overlaps
        int blocked = 0;
        int overlapX1 = Math.max(0, Math.min(tx2,b1x2) - Math.max(tx1, b1x1));
        int overlapY1 = Math.max(0, Math.min(ty2, b1y2) - Math.max(ty1, b1y1));
        blocked += (overlapX1 * overlapY1);
        int overlapX2 = Math.max(0, Math.min(tx2,b2x2) - Math.max(tx1, b2x1));
        int overlapY2 = Math.max(0, Math.min(ty2, b2y2) - Math.max(ty1, b2y1));
        blocked += (overlapX2 * overlapY2);
        int area1 = (b1y2 - b1y1) * (b1x2 - b1x1);
        int area2 = (b2y2 - b2y1) * (b2x2 - b2x1);
        System.out.println((area1 + area2) - blocked);
    }
}
