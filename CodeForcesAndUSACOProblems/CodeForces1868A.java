import java.util.*;

public class CodeForces1868A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            if (m == 1) {
                System.out.println(0);
                for (int j = 0; j < n; j++) System.out.println(0);
            } else {
                if (n >= m) {
                    System.out.println(m);
                    grid[0][0] = (m - 1);
                    for (int j = 0; j < m - 1; j++) grid[0][j + 1] = j;
                    int[] standard = grid[0].clone();
                    if (m >= 2) {
                        //decrease filling
                        int upperLim = 1; //number u need to start at inclusive
                        //top row should have upperLim
                        for (int col = 2; col < m; col++) {
                            int current = upperLim;
                            for (int j = 0; j < upperLim + 1; j++) {
                                grid[j][col] = current;
                                current--;
                            }
                            upperLim++;
                        }
                    }
                    int offset = 1;
                    for (int row = 1; row < n; row++) {
                        if (offset >= m - 1) grid[row] = standard;
                        else {
                            //fixed pattern logic
                            int pointer = 0;
                            for (int j = m - 1 - offset; j < m; j++) {
                                grid[row][pointer] = j;
                                pointer++;
                            }
                        }
                        offset++;
                    }
                    printGrid(grid);
                } else {
                    System.out.println(n + 1);
                    grid[0][0] = (m - 1);
                    for (int j = 0; j < m - 1; j++) grid[0][j + 1] = j;
                    int[] standard = grid[0].clone();
                    if (m >= 2) {
                        //decrease filling
                        int upperLim = 1; //number u need to start at inclusive
                        //top row should have upperLim
                        for (int col = 2; col < m; col++) {
                            int current = upperLim;
                            for (int j = 0; j < upperLim + 1  && j < n; j++) {
                                grid[j][col] = current;
                                current--;
                            }
                            upperLim++;
                        }
                    }
                    int offset = 1;
                    for (int row = 1; row < n; row++) {
                        if (offset >= m - 1) grid[row] = standard;
                        else {
                            //fixed pattern logic
                            int pointer = 0;
                            for (int j = m - 1 - offset; j < m; j++) {
                                grid[row][pointer] = j;
                                pointer++;
                            }
                        }
                        offset++;
                    }
                    printGrid(grid);
                }
            }
        }
    }
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
