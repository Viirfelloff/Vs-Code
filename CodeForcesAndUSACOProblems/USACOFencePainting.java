package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
//10 mins. we him bro. getting too good at this shit. - 7/5
//also derived TIDE and TDSE today. we locked beyond comprehension.
public class USACOFencePainting {
    public static int solution (int A, int B, int C, int D) {
        Set<Integer> set = new HashSet<>();
        int counter = A;
        for (int i = 0; i < (B-A) + 1; i++) {
            set.add(counter);
            counter++;
        }
        int counter2 = C;
        for (int k = 0; k < (D-C) + 1; k++) {
            set.add(counter2);
            counter2++;
        }
        ArrayList<Integer> comparison = new ArrayList<>(set);
        Collections.sort(comparison);
        return comparison.getLast() - comparison.getFirst();
    }
    public static void main (String[] args) {
        System.out.println(solution(7,10,4,8));
    }
}
