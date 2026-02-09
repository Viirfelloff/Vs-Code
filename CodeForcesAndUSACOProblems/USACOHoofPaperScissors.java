package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//cooked with this one
public class USACOHoofPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> cowOne = new ArrayList<>();
        List<Integer> cowTwo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cowOne.add(sc.nextInt());
            cowTwo.add(sc.nextInt());
        }
        List<Integer> wins = new ArrayList<>();
        String one = "";
        String two = "";
        String three = "";
        for (int k = 0; k < 6; k++) {
            int win = 0;
            switch (k) {
                case 0:
                    one = "r";
                    two = "p";
                    three = "s";
                    break;
                case 1:
                    one = "r";
                    two = "s";
                    three = "p";
                    break;
                case 2:
                    one = "p";
                    two = "r";
                    three = "s";
                    break;
                case 3:
                    one = "p";
                    two = "s";
                    three = "r";
                    break;
                case 4:
                    one = "s";
                    two = "p";
                    three = "r";
                    break;
                case 5:
                    one = "s";
                    two = "r";
                    three = "p";
                    break;
            }
            for (int j = 0; j < cowOne.size(); j++) {
                int turn1 = cowOne.get(j);
                int turn2 = cowTwo.get(j);
                String t1;
                String t2;
                if (turn1 == 1) {
                    t1 = one;
                }
                else if (turn1 == 2) {
                    t1 = two;
                } else {
                    t1 = three;
                }
                if (turn2 == 1) {
                    t2 = one;
                }
                else if (turn2 == 2) {
                    t2 = two;
                } else {
                    t2 = three;
                }
                if ((t1.equals("r") && t2.equals("s")) || (t1.equals("s") && t2.equals("p")) || (t1.equals("p") && t2.equals("r"))) {
                    win++;
                }
            }
            wins.add(win);
        }
        System.out.println(Collections.max(wins));
    }
}
