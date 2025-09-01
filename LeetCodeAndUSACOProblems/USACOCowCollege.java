package LeetCodeAndUSACOProblems;

import java.util.*;
//good solution - 8/12, although there is a minor optimization strat that
//you almost got! good job tho.
public class USACOCowCollege {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> tuitions = new ArrayList<>();
        for (int i =0; i < n; i++) {
            tuitions.add(sc.nextInt());
        }
        Collections.sort(tuitions);
        int lastTuiton = 0;
        int lastPrice = 0;
        for (int x : tuitions) {
            int tuition = 0;
            for (int y : tuitions) {
                if (y >= x) tuition += x;
            }
            if (tuition <= lastTuiton) {
                break;
            }
            lastPrice = x;
            lastTuiton = tuition;
        }
        System.out.println(lastTuiton);
        System.out.println(lastPrice);
    }
}
