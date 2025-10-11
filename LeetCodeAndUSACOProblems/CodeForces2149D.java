

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2149D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            int aCost;
            int bCost;
            List<Integer> As = new ArrayList<>();
            List<Integer> Bs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'a') As.add(j);
                else Bs.add(j);
            }

            // Step 1: a calculations
            if (As.size() <= 1) {
                aCost = 0;
            } else if (As.size() % 2 == 0) {
                int movesA1 = 0;
                int movesA2 = 0;
                int medianA1 = As.size() / 2;
                int medianA2 = As.size() / 2 - 1;
                // <-- FIX: initialize to neighbor indices, not median itself
                int leftA1 = medianA1 - 1;
                int rightA1 = medianA1 + 1;
                int leftA2 = medianA2 - 1;
                int rightA2 = medianA2 + 1;
                int rightRemaining1 = As.size() - 1 - medianA1;
                int leftRemaining1 = medianA1;
                int rightRemaining2 = As.size() - 1 - medianA2;
                int leftRemaining2 = medianA2;

                int inc = medianA1 + 1;
                while (rightRemaining1 > 0) {
                    movesA1 += Math.abs(As.get(rightA1) - (As.get(medianA1) - medianA1 + inc));
                    inc++;
                    rightA1++;
                    rightRemaining1--;
                }
                int inc2 = medianA1 - 1;
                while (leftRemaining1 > 0) {
                    movesA1 += Math.abs(As.get(leftA1) - (As.get(medianA1) - medianA1 + inc2));
                    inc2--;
                    leftA1--;
                    leftRemaining1--;
                }

                int inc3 = medianA2 + 1;
                while (rightRemaining2 > 0) {
                    movesA2 += Math.abs(As.get(rightA2) - (As.get(medianA2) - medianA2 + inc3));
                    inc3++;
                    rightA2++;
                    rightRemaining2--;
                }
                int inc4 = medianA2 - 1;
                while (leftRemaining2 > 0) {
                    movesA2 += Math.abs(As.get(leftA2) - (As.get(medianA2) - medianA2 + inc4));
                    inc4--;
                    leftA2--;
                    leftRemaining2--;
                }
                aCost = Math.min(movesA1, movesA2);
            } else {
                int movesA = 0;
                int medianA = As.size() / 2;
                // <-- FIX: start pointers at neighbors
                int leftA = medianA - 1;
                int rightA = medianA + 1;
                int rightRemaining = As.size() - 1 - medianA;
                int leftRemaining = medianA;

                int inc = medianA + 1;
                while (rightRemaining > 0) {
                    movesA += Math.abs(As.get(rightA) - (As.get(medianA) - medianA + inc));
                    inc++;
                    rightA++;
                    rightRemaining--;
                }
                int inc2 = medianA - 1;
                while (leftRemaining > 0) {
                    movesA += Math.abs(As.get(leftA) - (As.get(medianA) - medianA + inc2));
                    inc2--;
                    leftA--;
                    leftRemaining--;
                }
                aCost = movesA;
            }

            // Step 2: b calculations
            if (Bs.size() <= 1) {
                bCost = 0;
            } else if (Bs.size() % 2 == 0) {
                int movesB1 = 0;
                int movesB2 = 0;
                int medianB1 = Bs.size() / 2;
                int medianB2 = Bs.size() / 2 - 1;
                // <-- FIX: initialize neighbor pointers
                int leftB1 = medianB1 - 1;
                int rightB1 = medianB1 + 1;
                int leftB2 = medianB2 - 1;
                int rightB2 = medianB2 + 1;
                int rightRemaining1 = Bs.size() - 1 - medianB1;
                int leftRemaining1 = medianB1;
                int rightRemaining2 = Bs.size() - 1 - medianB2;
                int leftRemaining2 = medianB2;

                int inc = medianB1 + 1;
                while (rightRemaining1 > 0) {
                    movesB1 += Math.abs(Bs.get(rightB1) - (Bs.get(medianB1) - medianB1 + inc));
                    inc++;
                    rightB1++;
                    rightRemaining1--;
                }
                int inc2 = medianB1 - 1;
                while (leftRemaining1 > 0) {
                    movesB1 += Math.abs(Bs.get(leftB1) - (Bs.get(medianB1) - medianB1 + inc2));
                    inc2--;
                    leftB1--;
                    leftRemaining1--;
                }

                int inc3 = medianB2 + 1;
                while (rightRemaining2 > 0) {
                    movesB2 += Math.abs(Bs.get(rightB2) - (Bs.get(medianB2) - medianB2 + inc3));
                    inc3++;
                    rightB2++;
                    rightRemaining2--;
                }
                int inc4 = medianB2 - 1;
                while (leftRemaining2 > 0) {
                    movesB2 += Math.abs(Bs.get(leftB2) - (Bs.get(medianB2) - medianB2 + inc4));
                    inc4--;
                    leftB2--;
                    leftRemaining2--;
                }
                bCost = Math.min(movesB1, movesB2);
            } else {
                int movesB = 0;
                int medianB = Bs.size() / 2;
                // <-- FIX: neighbor pointers
                int leftB = medianB - 1;
                int rightB = medianB + 1;
                int rightRemaining = Bs.size() - 1 - medianB;
                int leftRemaining = medianB;

                int inc = medianB + 1;
                while (rightRemaining > 0) {
                    movesB += Math.abs(Bs.get(rightB) - (Bs.get(medianB) - medianB + inc));
                    inc++;
                    rightB++;
                    rightRemaining--;
                }
                int inc2 = medianB - 1;
                while (leftRemaining > 0) {
                    movesB += Math.abs(Bs.get(leftB) - (Bs.get(medianB) - medianB + inc2));
                    inc2--;
                    leftB--;
                    leftRemaining--;
                }
                bCost = movesB;
            }

            System.out.println(Math.min(aCost, bCost));
        }
    }
}
