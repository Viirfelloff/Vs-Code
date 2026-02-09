package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesDiv4B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = 0;
            int y = 0;
            List<int[]> visited = new ArrayList<>();
            visited.add(new int[]{x,y});
            String s = sc.next();
            for (char c : s.toCharArray()) {
                if (c == 'U') {
                    y++;
                }
                else if (c == 'D') {
                    y--;
                }
                else if (c == 'L') {
                    x--;
                } else {
                    x++;
                }
                visited.add(new int[]{x,y});
            }
            boolean found = false;
            for (int[] pos : visited) {
                if (pos[0] == 1 && pos[1] == 1) {
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "YES" : "NO");
        }
    }
}
