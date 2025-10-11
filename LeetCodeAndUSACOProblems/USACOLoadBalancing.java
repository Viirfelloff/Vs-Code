

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class USACOLoadBalancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("balancing.out"));
        String data = br.readLine();
        String[] dat = data.split(" ");
        int n = Integer.parseInt(dat[0]);
        int b = Integer.parseInt(dat[1]);
        List<int[]> pos = new ArrayList<>();
        int bestM = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            pos.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }
        List<Integer> xPos = new ArrayList<>();
        List<Integer> yPos = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            xPos.add(pos.get(j)[0] + 1);
            xPos.add(pos.get(j)[0] - 1);
            yPos.add(pos.get(j)[1] + 1);
            yPos.add(pos.get(j)[1] - 1);
        }
        for (int k = 0; k < xPos.size(); k++) {
            for (int l = 0; l < yPos.size(); l++) {
                int x = xPos.get(k);
                int y = yPos.get(l);
                // coordinates of fence = xpos.get(k), ypos.get(l)
                int sW = 0;
                int nW = 0;
                int nE = 0;
                int sE = 0;
                for (int[] position : pos) {
                    int a = position[0];
                    int bb = position[1];
                    if (a < x && bb < y) sW++;
                    if (a < x && bb > y) nW++;
                    if (a > x && bb > y) nE++;
                    if (a > x && bb < y) sE++;
                }
                int M = Math.max(Math.max(nE, nW), Math.max(sW, sE));
                bestM = Math.min(bestM, M);
            }
        }
        pw.print(bestM);
        br.close();
        pw.flush();
        pw.close();
    }
}
