package LeetCodeAndUSACOProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//hard problems getting too easy for me bro
//finish implementation on 10/2: simulate new explosion interval
//consider each pos and simulate.
public class USACOAngryCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int inc = 0;
        for (int x : list) {
            int bales = 0;
            int radius = 1;
            int left = inc - 1;
            int right = inc + 1;
            if (left >= 0 && right < list.size()) {
                while (left > 0 && right < list.size()) {
                    if (radius == 1) {
                        if (x + 1 >= list.get(right)) {
                            bales++;
                        }
                        else if (x - 1 <= list.get(left)) {
                            bales++;
                        } else {
                            break;
                        }
                    } else {
                        if (list.get(left) - radius <= list.get(left - 1)) {
                            bales++;
                        }
                        else if (list.get(right) + radius >= list.get(right + 1)) {
                            bales++;
                        } else {
                            break;
                        }
                    }
                    left--;
                    right++;
                    radius++;
                }
            }
            else if (left >= 0) {
                while (left >= 0) {
                    if (radius == 1) {
                        if (list.get(x) - radius <= list.get(left)) {
                            bales++;
                        }
                    } else {

                    }
                    left--;
                    radius++;
                }
            } else {
                while (right < list.size()) {
                    if (radius == 1) {

                    } else {

                    }
                    right++;
                    radius++;
                }
            }
            inc++;
        }
        out.println(ans);
        out.close();
    }
}
