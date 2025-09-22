package LeetCodeAndUSACOProblems;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class USACOMakingMexes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res = new ArrayList<>();
        // Fast output
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        Set<Integer> nNumbers = new HashSet<>();
        int nSize = n + 1;
        int zerocount = 0;
        for (int i = 0; i < n; i++) {
            int tkn = Integer.parseInt(st.nextToken());
            list.add(tkn);
            nNumbers.add(tkn);
            if (tkn == 0) zerocount++;
        }
        Collections.sort(list);
        for (int x : list) {
            //mex = x
            //to make there are 3 cases:
            //0<x<N. all numbers below x down to 0 must appear at least once and x does not appear.
            //x = 0. zero cannot appear in the array.
            //x = N. all numbers from 0 to n -1
            if (x == 0) {
                res.add(zerocount);
            }
            else if (x == n) {
                if (nNumbers.size() == nSize) res.add(0);
                else res.add(nSize - nNumbers.size());
            } else {

            }
        }
        out.print(res);
        out.flush();
        out.close();
        br.close();

    }
}
