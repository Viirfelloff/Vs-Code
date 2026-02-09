package CodeForcesAndUSACOProblems;

import java.util.Scanner;

public class USACOSquarePasture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int xx1 = sc.nextInt();
        int yy1 = sc.nextInt();
        int xx2 = sc.nextInt();
        int yy2 = sc.nextInt();
        int BBX1 = Math.min(x1, xx1);
        int BBY1 = Math.min(y1, yy1);
        int BBX2 = Math.max(x2, xx2);
        int BBY2 = Math.max(y2, yy2);
        int width = BBY2 - BBY1;
        int length = BBX2 - BBX1;
        int val = Math.max(width, length);
        System.out.println(val * val);
    }
}
