package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class USACOCowCheckups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //for every l,r, count matches and put it into an array.
        //for each int c in the range 0...N, take arr[c]
        //to count matches, only change what is reversed inside.
        //above is to figure out tmrw
        int[] count = new int[n + 1];
        List<Integer> currentList = new ArrayList<>();
        List<Integer> desiredList = new ArrayList<>();
        for (int i = 0; i < n; i++) currentList.add(sc.nextInt());
        for (int j = 0; j < n; j++) desiredList.add(sc.nextInt());
        int matches = 0;
        boolean[] arr = new boolean[n];
        for (int l = 0; l < n; l++) {
            if (Objects.equals(currentList.get(l), desiredList.get(l))) {
                arr[l] = true;
                matches++;
            }
        }
        for (int g = 0; g < n; g++) {
            for (int b = 0; b < n; b++) {
                //somehow in o(1) time reverse, count matches, and do count[newmatches] = count[newmatches] + 1;
            }
        }
    }
}
