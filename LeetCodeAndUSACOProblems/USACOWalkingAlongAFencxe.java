package LeetCodeAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOWalkingAlongAFencxe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        List<int[]> coords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coords.add(new int[]{x,y});
        }
        //build 2 element prefix sums
        List<int[]> xS = new ArrayList<>();
        List<int[]> yS = new ArrayList<>();
        int curXSum = 0;
        int curYSum = 0;
        //forward first
        for (int i = 0; i < n; i++) {
            //identify hor or ver shift
            if (i == n - 1) {
                //compare to 0
            } else {
                boolean horz = false;

            }
         }
    }
}
