package CodeForcesAndUSACOProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//les go
//lowk hard for a div 3 problem?
public class CodeForcesDiv3A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int h = sc.nextInt();
            int m = sc.nextInt();
            int time = h * 60 + m;
            int total = 1440;
            List<Integer> diffs = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                int times = sc.nextInt() * 60 + sc.nextInt();
                int diff = times - time;
                if (diff < 0) {
                    diffs.add(diff + total);
                } else {
                    diffs.add(diff);
                }
            }
            int hr = (int)(Collections.min(diffs) / 60);
            int min = Collections.min(diffs) % 60;
            System.out.println(hr);
            System.out.println(min);
        }
    }
}
