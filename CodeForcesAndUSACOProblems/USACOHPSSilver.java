import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class USACOHPSSilver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("hps.out"));
        int n = Integer.parseInt(br.readLine());
        List<Integer> hpf = new ArrayList<>();
        List<Integer> ppf = new ArrayList<>();
        List<Integer> spf = new ArrayList<>();
        int h = 0;
        int p = 0;
        int s = 0;
        List<String> moves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String move = String.valueOf(br.readLine());
            moves.add(move);
            if (move.equals("H")) h++;
            else if (move.equals("P")) p++;
            else s++;
            hpf.add(h);
            ppf.add(p);
            spf.add(s);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            int c = 0;
            String move;
            if (i == 0) move = "H";
            else if (i == 1) move = "P";
            else move = "S";
            for (int j = 0; j < n; j++) {
                c += res(move, moves.get(j)) ? 1 : 0;
            }
            if (c > max) max = c;
        }
        for (int i = 1; i < n; i++) {
            int pcb = hpf.get(i - 1);
            int scb = ppf.get(i - 1);
            int hcb = spf.get(i - 1);
            int countb = Math.max(Math.max(hcb, pcb), scb);
            int hca = hpf.get(n - 1) - hpf.get(i - 1);
            int pca = ppf.get(n - 1) - ppf.get(i - 1);
            int sca = spf.get(n - 1) - spf.get(i - 1);
            int counta = Math.max(Math.max(hca, pca), sca);
            int total = counta + countb;
            if (total > max) max = total;
        }
        pr.println(max);
        pr.flush();
        pr.close();
        br.close();
    }
    public static boolean res(String a, String b) {
        if (a.equals("H") && b.equals("P")) return false;
        if (a.equals("P") && b.equals("H")) return true;
        if (a.equals("H") && b.equals("S")) return true;
        if (a.equals("S") && b.equals("H")) return false;
        if (a.equals("P") && b.equals("S")) return false;
        if (a.equals("S") && b.equals("P")) return true;
        return false;
    }
}
