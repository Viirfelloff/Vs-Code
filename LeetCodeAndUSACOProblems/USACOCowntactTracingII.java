package LeetCodeAndUSACOProblems;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//ahh fail, try agian next time
public class USACOCowntactTracingII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //plan: for each consecutive sequence of 3 or more
        //two 1s at the end are included and treated as one.
        //calculate the miniumum days needed to spread ot the full
        //sequence from the origin. then take that max and count each of the other consecutive based off of that
        //any isolated ones immediately make you count all ones.
        //isolated ones
        List<int[]> intervals = new ArrayList<>();
        List<Integer> sig = new ArrayList<>();
        int onecount = 0;
        for(int i = 0; i < n; i++) {
            int next = sc.nextInt();
            sig.add(next);
            if (next == 1) onecount++;
        }
        int last = -1;
        int inc = 0;
        boolean isolated = false;
        for (int x : sig) {
            if (inc == sig.size() - 1) {
                if (last == 0 && x == 1) {
                    isolated = true;
                    break;
                }
            }
            else if (inc == 0) {
                if (x == 1 && sig.get(inc + 1) == 0) {
                    isolated = true;
                    break;
                }
            } else {
                if (last == 0 && x == 1 && sig.get(inc + 1) == 0) {
                    isolated = true;
                    break;
                }
            }
            inc++;
            last = x;
        }
        if (isolated) {
            System.out.println(onecount);
        } else {
            int res = 0;
            //TODO: implement 1 at end or beginning sequence
            //find each sequence (11 from beginning or end have 0 or n - 1 as min index
            int lastt = -1;
            int count = 0;
            int start = -1;
            int end = -1;
            int incc = 0;
            for (int xx : sig) {
                if ((lastt == -1 || lastt == 0) && xx == 1 && count == 0) {
                    count++;
                    start = incc;
                }
                else if (lastt == 1 && xx == 1) {
                    count++;
                }
                else if (lastt == 1 && xx == 0) {
                    count = 0;
                    end = incc;
                    intervals.add(new int[]{start, end});
                }
                lastt = xx;
                incc++;
            }
            if (count != 0) {
                intervals.add(new int[]{start, sig.size() - 1});
            }
            List<Integer> spreadTimes = new ArrayList<>();
            for (int[] yy : intervals) {
                if ((yy[1] - yy[0]) % 2 == 0) {
                    spreadTimes.add((yy[1] - yy[0]) / 2);
                } else {
                    spreadTimes.add((yy[1] - yy[0] - 1) / 2);
                }
            }
            int avg = Collections.min(spreadTimes);
            for (int[] nn : intervals) {
                int length = (nn[1] - nn[0]) + 1;
                res += (length - 2 * avg);
            }
            System.out.println(res);
        }
    }
}
