package LeetCodeAndUSACOProblems;

import java.util.Scanner;
//LES GOOOO ANOTHER HARD PROBLEM FORMULAS FIGURED OUT BY MYSELF
//AND MINIMAL HELP FROM GPT
// AND DEBUGGED BY MYSELF
public class USACOBlockedBillboardII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();
        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();
        int xOverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yOverlap = Math.min(ay2, by2) - Math.max(ay1, by1);
        if ((by2 >= ay2 && by1 <= ay1) && !(bx2 >= ax2 && bx1 <= ax1)) {
            System.out.println(((ax2 - ax1) - xOverlap)*(ay2 - ay1));
        } else if (!(by2 >= ay2 && by1 <= ay1) && (bx2 >= ax2 && bx1 <= ax1)) {
            System.out.println((ax2 - ax1) * ((ay2 - ay1) - yOverlap));
        } else if (!(by2 >= ay2 && by1 <= ay1) && !(bx2 >= ax2 && bx1 <= ax1)) {
            System.out.println((ax2 - ax1) * (ay2 - ay1));
        } else {
            System.out.println(0);
        }
    }
}
