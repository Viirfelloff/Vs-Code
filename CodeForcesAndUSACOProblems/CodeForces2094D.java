package CodeForcesAndUSACOProblems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2094D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String p = sc.next();
            String s = sc.next();

            List<String> pBlocks = new ArrayList<>();
            List<String> sBlocks = new ArrayList<>();

            // Build blocks for p
            StringBuilder sb1 = new StringBuilder();
            char last = ' ';
            for (char c : p.toCharArray()) {
                if (c != last && last != ' ') {
                    pBlocks.add(sb1.toString());
                    sb1.setLength(0);
                }
                sb1.append(c);
                last = c;
            }
            if (sb1.length() > 0) pBlocks.add(sb1.toString());

            // Build blocks for s
            StringBuilder sb2 = new StringBuilder();
            char last2 = ' ';
            for (char c : s.toCharArray()) {
                if (c != last2 && last2 != ' ') {
                    sBlocks.add(sb2.toString());
                    sb2.setLength(0);
                }
                sb2.append(c);
                last2 = c;
            }
            if (sb2.length() > 0) sBlocks.add(sb2.toString());

            boolean valid = true;

            // Check block counts first
            if (pBlocks.size() != sBlocks.size()) {
                valid = false;
            } else {
                for (int j = 0; j < pBlocks.size(); j++) {
                    String pb = pBlocks.get(j);
                    String sb = sBlocks.get(j);

                    // must match character
                    if (pb.charAt(0) != sb.charAt(0)) {
                        valid = false;
                        break;
                    }

                    // must match size rule (k or 2k)
                    int lenP = pb.length();
                    int lenS = sb.length();
                    if (!(lenS == lenP || lenS == 2 * lenP)) {
                        valid = false;
                        break;
                    }
                }
            }

            System.out.println(valid ? "YES" : "NO");
        }
    }
}
