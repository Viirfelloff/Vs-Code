import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces1375B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Long>> grid = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                List<Long> list = new ArrayList<>();
                for (int k = 0; k < m; k++) {
                    list.add(sc.nextLong());
                }
                grid.add(list);
            }
            boolean k = true;
            for (int b = 0; b < n; b++) {
                for (int g = 0; g < m; g++) {
                    if (grid.get(b).get(g) >= 4) {
                        k = false;
                        break;
                    }
                }
            }
            if (k) System.out.println("NO");
            boolean valid = true;
            for (int h = 0; h < n; h++) {
                for (int b = 0; b < m; b++) {
                    boolean val = checkValidity(grid, h, b);
                    if (!val) {
                        valid = false;
                        break;
                    } else {
                        grid = updGrid(grid, grid.get(h).get(b));
                    }
                }
            }
            if (valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean checkValidity(List<List<Long>> grid, int i, int j) {
        long cells = 4;
        boolean firstOrLastCol = (j == grid.get(0).size() - 1) || (j == 0);
        boolean firstOrLastRow = (i == grid.size() - 1) || (i == 0);
        if (grid.size() == 1 && grid.get(0).size() == 1) cells = 0;
        //last case: 1 row or 1 col
        if (grid.size() == 1) {
            if (firstOrLastCol) {
                cells = 1;
            } else {
                cells = 2;
            }
        }
        if (grid.get(0).size() == 1) {
            if (firstOrLastRow) {
                cells = 1;
            } else {
                cells = 2;
            }
        }
        //method to check neighboring cells
        if (firstOrLastRow && !firstOrLastCol) cells = 3;
        else if (!firstOrLastRow && firstOrLastCol) cells = 3;
        else if (firstOrLastCol && firstOrLastRow) cells = 2;
        long num = grid.get(i).get(j);
        boolean p1 = num <= cells;
        //part 2 = it has <= K numbers > 0 neighboring it
        int neighboringG0 = 0;
        if (inBounds(grid, i, j - 1)) {
            if (grid.get(i).get(j - 1) > 0) neighboringG0++;
        }
        if (inBounds(grid, i - 1, j)) {
            if (grid.get(i - 1).get(j) > 0) neighboringG0++;
        }
        if (inBounds(grid, i, j + 1)) {
            if (grid.get(i).get(j + 1) > 0) neighboringG0++;
        }
        if (inBounds(grid, i + 1, j)) {
            if (grid.get(i + 1).get(j) > 0) neighboringG0++;
        }
        boolean p2 = neighboringG0 <= num;
        return p2 && p1;
    }
    public static List<List<Long>> updGrid(List<List<Long>> grid, long k) {
        //somehow update so that other numbers do not get affected
        //for now just randomly update, hope that it does not affect other numbers
        //step 1: check if each of the neighboring cells have other cells that are > 0 - this will affect
        //this is only for cells you have checked already
        //if both do not work, transition to cells not checked yet. future iterations will fix them.
        boolean topPossible = true;
        boolean bottomPossible = true;
        return grid;
    }
    public static boolean inBounds(List<List<Long>> grid, int i, int j) {
        int lower = 0;
        int upper = grid.size() - 1;
        int upperJ = grid.get(0).size() - 1;
        int lowerJ = 0;
        return ((lower <= i) && (i <= upper)) && ((lowerJ <= j) && (j <= upperJ));
    }
}
