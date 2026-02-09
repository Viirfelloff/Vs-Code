package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv4CBishop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                String row = sc.next();
                rows.add(row);
            }
            int row = 0;
            int col = 0;
            for (int m = 0; m < rows.size(); m++) {
                boolean found2 = false;
                for (int b = 0; b < rows.get(m).length(); b++) {
                    int r = m + 1;
                    int c = b + 1;
                    if (b > 0 && m > 0 && b < 7 && r < 7) {
                        if (rows.get(m - 1).charAt(b - 1) == '#' && rows.get(m - 1).charAt(b + 1) == '#' && rows.get(m + 1).charAt(b - 1) == '#' && rows.get(m + 1).charAt(b + 1) == '#') {
                            found2 = true;
                            row = r;
                            col = c;
                        }
                    }
                }
                if (found2) break;
            }
            System.out.println(row + " " + col);
        }
    }
}
