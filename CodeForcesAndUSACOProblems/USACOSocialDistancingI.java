import java.io.*;
import java.util.*;

public class USACOSocialDistancingI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("socdist1.out"));
        int N = Integer.parseInt(br.readLine());
        String s = String.valueOf(br.readLine());
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') oneCount++;
        }
        if (oneCount == 0) System.out.println(N);

        for (int j = 0; j < 2; j++) {
            List<int[]> blocks = blocks(s);
            int max = -1;
            int[] maxArr = new int[]{-1};
            for (int[] x : blocks) {
                if (x[1] - x[0] + 1 > max) {
                    max = x[1] - x[0] + 1;
                    maxArr = x;
                }
            }
            int maxD = max;
            int dist = getDist(maxD);
            int minD = Integer.MAX_VALUE;
            int lastOne = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (lastOne != -1) {
                        int d = i - lastOne;
                        if (d < minD) minD = d;
                    }
                    lastOne = i;
                }
            }
            if (dist >= minD) {
                //replace with minD
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.replace(maxArr[0] + minD, maxArr[0] + minD + 1,"1");
                s = sb.toString();
            } else {
                //replace with dist
                StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.replace(maxArr[0] + dist, maxArr[0] + dist + 1, "1");
                s = sb.toString();
            }
        }

        //now, s = final string. compute min D.
        int minD = Integer.MAX_VALUE;
        int lastOne = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (lastOne != -1) {
                    int d = i - lastOne;
                    if (d < minD) minD = d;
                }
                lastOne = i;
            }
        }

        pr.println(minD);
        pr.flush();
        pr.close();
    }

    public static List<int[]> blocks(String s) {
        List<int[]> blocks = new ArrayList<>();
        int st = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && st == -1) {
                st = i; // start of a zero-block
            }
            if (s.charAt(i) == '1' && st != -1) {
                blocks.add(new int[]{st, i - 1}); // end of zero-block
                st = -1;
            }
        }
        if (st != -1) {
            blocks.add(new int[]{st, s.length() - 1}); // add last block if string ends with 0
        }
        return blocks;
    }

    public static int getDist(int size) {
        return (size - 1) / 2;
    }
}
