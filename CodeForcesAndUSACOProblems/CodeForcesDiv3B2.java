package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv3B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> order = new ArrayList<>();
            int n = sc.nextInt();
            int[] seats = new int[n];
            boolean followed = true;
            for (int k = 0; k < n; k++) {
                int seat = sc.nextInt() - 1;
                order.add(seat);
                if (k == 0) {
                    seats[seat] = 1;
                } else if (k == n - 1) {
                    followed = true;
                } else {
                    if (seat == 0) {
                        if (seats[seat + 1] != 1) {
                            followed = false;
                            break;
                        } else {
                            seats[seat] = 1;
                        }
                    }
                    else if (seat == n - 1) {
                        if (seats[seat - 1] != 1) {
                            followed = false;
                            break;
                        } else {
                            seats[seat] = 1;
                        }
                    } else {
                        if (seats[seat - 1] != 1 && seats[seat + 1] != 1) {
                            followed = false;
                            break;
                        } else {
                            seats[seat] = 1;
                        }
                    }
                }
            }
            if (followed) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
