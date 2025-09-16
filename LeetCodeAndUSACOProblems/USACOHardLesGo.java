package LeetCodeAndUSACOProblems;
import java.io.*;
import java.util.*;

public class USACOHardLesGo {
    public static void main(String[] args) throws IOException {
        // File input
        BufferedReader br = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

        String s = br.readLine().trim();  // S
        String m = br.readLine().trim();  // T

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= m.length()) {
                boolean match = true;
                for (int i = 0; i < m.length(); i++) {
                    if (sb.charAt(sb.length() - m.length() + i) != m.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.delete(sb.length() - m.length(), sb.length());
                }
            }
        }

        out.println(sb.toString());
        out.close();
        br.close();
    }
}
