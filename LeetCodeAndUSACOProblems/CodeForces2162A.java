import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForces2162A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < n; k++) list.add(sc.nextInt());
            List<Double> maxAverage = new ArrayList<>();
            List<List<Integer>> subarrays = new ArrayList<>();
            for (int start = 0; start < list.size(); start++) {
                for (int end = start; end < list.size(); end++) {
                    List<Integer> sub = new ArrayList<>();
                    for (int k = start; k <= end; k++) {
                        sub.add(list.get(k));
                    }
                    subarrays.add(sub);
                }
            }
            List<Integer> averages = new ArrayList<>();
            for (List<Integer> subarr : subarrays) {
                int sum = 0;
                for (int x: subarr) sum += x;
                averages.add(sum / subarr.size());
            }
            System.out.println(Collections.max(averages));
        }
    }
}
