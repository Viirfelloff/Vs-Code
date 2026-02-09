package CodeForcesAndUSACOProblems.ContestProblems;

import java.io.*;
import java.util.*;


public class CodeForcesDiv4Round1050C{
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<int[]> intervals = new ArrayList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            intervals.add(new int[]{0,0});
            for (int j = 0; j < n; j++) {
                intervals.add(new int[]{sc.nextInt(), sc.nextInt()});
            }
            long points = 0;
            //before + after calculations
            points += (m - intervals.get(intervals.size() - 1)[0]);
            for (int k = 0; k < intervals.size() - 1; k++) {
                if ((intervals.get(k+1)[0] - intervals.get(k)[0]) % 2 == 0) {
                    if (intervals.get(k+1)[1] == intervals.get(k)[1]) {
                        points += (intervals.get(k+1)[0] - intervals.get(k)[0]);
                    } else {
                        points += (intervals.get(k+1)[0] - intervals.get(k)[0]) - 1;
                    }
                } else {
                    if (intervals.get(k+1)[1] == intervals.get(k)[1]) {
                        points += (intervals.get(k+1)[0] - intervals.get(k)[0]) - 1;
                    } else {
                        points += (intervals.get(k+1)[0] - intervals.get(k)[0]);
                    }
                }
            }
            out.println(points);
        }
        out.close();
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------
}