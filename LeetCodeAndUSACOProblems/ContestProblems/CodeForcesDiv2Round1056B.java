

import java.util.Scanner;

public class CodeForcesDiv2Round1056B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int winner = sc.nextInt();
            int losers = 0;
            int matches = 0;
            while (!(winner == 1 && losers == 1)) {
                int winnersToDrop = 0;

                // Winners bracket
                if (winner >= 2) {
                    matches += winner / 2;
                    if (winner % 2 == 0) {
                        winnersToDrop = winner / 2;
                        winner = winner / 2;
                    } else {
                        winnersToDrop = (winner - 1) / 2;
                        winner = (winner - 1) / 2 + 1;
                    }
                }

                // Losers bracket
                if (losers >= 2) {
                    matches += losers / 2;
                    if (losers % 2 == 0) {
                        losers = losers / 2;
                    } else {
                        losers = (losers - 1) / 2 + 1;
                    }
                }

                // Add the losers from winners bracket
                losers += winnersToDrop;
            }

            matches++; // Final match
            System.out.println(matches);
        }
    }
}
