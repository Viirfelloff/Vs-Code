import java.util.Scanner;

public class CodeForces2169B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            //left = latest left
            //right = earliest right
            boolean asterisk = true;
            int left = Integer.MIN_VALUE;
            int right = Integer.MAX_VALUE;
            int lefts = 0;
            int rights = 0;
            int earliestAst = Integer.MAX_VALUE;
            int latestAst = Integer.MIN_VALUE;
            int asts = 0;
            boolean a = true;
            boolean r = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '*') asterisk = false;
                if (s.charAt(j) == '<') {
                    left = j;
                    lefts++;
                }
                if (s.charAt(j) == '>' && r) {
                    right = j;
                    r = false;
                }
                if (s.charAt(j) == '>') rights++;
                if (s.charAt(j) == '*' && a) {
                    earliestAst = j;
                    a = false;
                }
                if (s.charAt(j) == '*') latestAst = j;
                if (s.charAt(j) == '*') asts++;
            }
            if (asterisk && s.length() > 1) System.out.println(-1);
            else if (asterisk && s.length() == 1) System.out.println(1);
            else if (left > right) System.out.println(-1);
            else {
                boolean p1 = false;
                char last = s.charAt(0);
                for (int j = 1; j < s.length(); j++) {
                    if (last == '*' && s.charAt(j) == '*') {
                        p1 = true;
                        break;
                    }
                    last = s.charAt(j);
                }
                if (p1) {
                    System.out.println(-1);
                } else {
                    boolean p2 = latestAst > right;
                    boolean p3 = earliestAst < left;
                    if (p2 || p3) System.out.println(-1);
                    else {
                        if (lefts + rights != s.length()) {
                            System.out.println(Math.max(lefts + 1, rights + 1));
                        } else {
                            System.out.println(Math.max(lefts,rights));
                        }
                    }
                }
            }
        }
    }
}
