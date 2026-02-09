package CodeForcesAndUSACOProblems;

import java.util.*;
import java.util.stream.Collectors;

public class CodeForces2049A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = sc.nextInt();
            List<Set<Integer>> subarrays = new ArrayList<>();
            List<Integer> sizes = new ArrayList<>();
            for (int start = 0; start < n; start++) {
                for (int end = start; end < n; end++) {
                    int[] sub = Arrays.copyOfRange(arr, start, end + 1);
                    Set<Integer> set = Arrays.stream(arr)  // turn into IntStream
                            .boxed()      // box to Integer
                            .collect(Collectors.toSet()); // collect to Set
                    subarrays.add(set);
                    sizes.add(set.size());
                }
            }
            Collections.sort(sizes);

        }
    }
}
