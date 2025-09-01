package LeetCodeAndUSACOProblems;

import java.util.*;
//golly ts long
public class CodeForcesDiv4C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        List<int[]> outer = new ArrayList<>();
        List<int[]> outer2 = new ArrayList<>();
        List<int[]> mid = new ArrayList<>();
        List<int[]> inner1 = new ArrayList<>();
        List<int[]> inner2 = new ArrayList<>();
        List<String> rows = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            for (int i = 1 + counter; i <= 10 - counter; i++) {
                switch (k) {
                    case 0 :
                        outer.add(new int[]{1 + counter, i});
                    case 1 :
                        outer2.add(new int[]{1 + counter, i});
                    case 3 :
                        inner1.add(new int[]{1 + counter, i});
                    case 4 :
                        inner2.add(new int[]{1 + counter, i});
                    case 2 :
                        mid.add(new int[]{1 + counter, i});
                }
            }
            for (int j = 1 + counter; j <= 10 - counter; j++) {
                switch (k) {
                    case 0 :
                        outer.add(new int[]{10 - counter, j});
                    case 1 :
                        outer2.add(new int[]{10 - counter, j});
                    case 3 :
                        inner1.add(new int[]{10 - counter, j});
                    case 4 :
                        inner2.add(new int[]{10 - counter, j});
                    case 2 :
                        mid.add(new int[]{10 - counter, j});
                }
            }
            for (int l = 1 + counter; l <= 10 - counter; l++) {
                switch (k) {
                    case 0 :
                        outer.add(new int[]{1 + counter, l});
                    case 1 :
                        outer2.add(new int[]{1 + counter, l});
                    case 3 :
                        inner1.add(new int[]{1 + counter, l});
                    case 4 :
                        inner2.add(new int[]{1 + counter, l});
                    case 2 :
                        mid.add(new int[]{1 + counter,l});
                }
            }
            for (int b = 1 + counter; b <= 10 - counter; b++) {
                switch (k) {
                    case 0 :
                        outer.add(new int[]{b, 10 - counter});
                    case 1 :
                        outer2.add(new int[]{b, 10 - counter});
                    case 3 :
                        inner1.add(new int[]{b, 10 - counter});
                    case 4 :
                        inner2.add(new int[]{b, 10 - counter});
                    case 2 :
                        mid.add(new int[]{b, 10 - counter});
                }
            }
            counter++;
        }
        for (int v = 0; v < 10; v++) {
            rows.add(sc.next());
        }
        int score = 0;
        for (int m = 1; m <= 10; m++) {
            for (int g = 1; g <= 10; g++) {
                if (rows.get(m - 1).charAt(g - 1) == 'X') {
                    int[] coord = new int[]{m,g};
                    if (outer.contains(coord)) score += 1;
                    if (outer2.contains(coord)) score += 2;
                    if (mid.contains(coord)) score += 3;
                    if (inner1.contains(coord)) score += 4;
                    if (inner2.contains(coord)) score += 5;
                }
            }
        }
        System.out.println(score);
    }
}
