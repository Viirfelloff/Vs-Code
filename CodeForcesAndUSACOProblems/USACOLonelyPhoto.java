package CodeForcesAndUSACOProblems;

import java.util.*;

public class USACOLonelyPhoto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int lonely = 0;
        for (int i = 0; i < n; i++) {
            int countG = 0;
            int countH = 0;
            if (s.charAt(i) == 'G') countG++;
            else countH++;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == 'G') countG++;
                else countH++;
                if (countG + countH >= 3) {
                    if (countG == 1 || countH == 1) lonely++;
                }
            }
        }
        System.out.println(lonely);
    }
}
