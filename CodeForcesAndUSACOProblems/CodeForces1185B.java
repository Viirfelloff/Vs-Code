import java.util.*;

public class CodeForces1185B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();

            List<String> A = getBlocks(a);
            List<String> B = getBlocks(b);

            boolean ok = true;

            if (A.size() != B.size()) {
                ok = false;
            } else {
                for (int i = 0; i < A.size(); i++) {
                    if (A.get(i).charAt(0) != B.get(i).charAt(0)) {
                        ok = false;
                        break;
                    }
                    if (A.get(i).length() > B.get(i).length()) {
                        ok = false;
                        break;
                    }
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }

    private static List<String> getBlocks(String s) {
        List<String> blocks = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        char last = '/';
        for (char c : s.toCharArray()) {
            if (c != last && sb.length() > 0) {
                blocks.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(c);
            last = c;
        }
        blocks.add(sb.toString()); // last block!
        return blocks;
    }
}
