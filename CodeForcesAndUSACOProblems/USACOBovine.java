package CodeForcesAndUSACOProblems;
import java.io.*;
import java.util.*;

public class USACOBovine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> spotty = new ArrayList<>();
        ArrayList<String> plain = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            if (i < n) {
                spotty.add(br.readLine());
            } else {
                plain.add(br.readLine());
            }
        }
        //K = row to be examined (for matches), aka the kth element of each sequence.
        int potentialspots = 0;
        for (int k = 0; k < m; k++) {
            Set<Character> spotset = new LinkedHashSet<>();
            Set<Character> plainset = new LinkedHashSet<>();
            for (int j = 0; j < n; j++) {
                spotset.add(spotty.get(j).charAt(k));
                plainset.add(plain.get(j).charAt(k));
            }
            int diffcount = 0;
            for (char x : spotset) {
                if (!plainset.contains(x)) {
                    diffcount++;
                }
            }
            if (diffcount == spotset.size()) {
                potentialspots++;
            }
        }
        pr.println(potentialspots);
        br.close();
        pr.close();
    }
}
