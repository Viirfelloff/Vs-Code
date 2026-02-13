package CodeForcesAndUSACOProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class USACOCowTipping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("cowtip.out"));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            List<Integer> mask = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                mask.add(Integer.parseInt(String.valueOf(s.charAt(j))));
            }
            grid.add(mask);
        }
        HashSet<int[]> set = new HashSet<>();
        for (int j = 0; j < n - 1; j++) {
            if (grid.get(0).get(j) != grid.get(0).get(j + 1)) {

            }
        }
    }
}
