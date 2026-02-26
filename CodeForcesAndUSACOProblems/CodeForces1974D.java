import java.util.*;
public class CodeForces1974D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String instr = sc.next();
            char[] ans = new char[n];
            List<Integer> we = new ArrayList<>();
            List<Integer> es = new ArrayList<>();
            List<Integer> nt = new ArrayList<>();
            List<Integer> st = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (instr.charAt(j) == 'W') we.add(j);
                else if (instr.charAt(j) == 'E') es.add(j);
                else if (instr.charAt(j) == 'S') st.add(j);
                else nt.add(j);
            }
            List<int[]> pairs = new ArrayList<>();
            Set<Integer> usedforpairs = new HashSet<>();
            boolean valid = true;
            if (nt.size() >= st.size()) {
                for (int j = 0; j < st.size(); j++) {
                    pairs.add(new int[]{nt.get(j), st.get(j)});
                    usedforpairs.add(nt.get(j));
                    usedforpairs.add(st.get(j));
                }
                if ((nt.size() - st.size()) % 2 != 0) valid = false;
            } else {
                for (int j = 0; j < nt.size(); j++) {
                    pairs.add(new int[]{nt.get(j), st.get(j)});
                    usedforpairs.add(nt.get(j));
                    usedforpairs.add(st.get(j));
                }
                if ((st.size() - nt.size()) % 2 != 0) valid = false;
            }
            if (es.size() >= we.size()) {
                for (int j = 0; j < we.size(); j++) {
                    pairs.add(new int[]{es.get(j), we.get(j)});
                    usedforpairs.add(es.get(j));
                    usedforpairs.add(we.get(j));
                }
                if ((es.size() - we.size()) % 2 != 0) valid = false;
            } else {
                for (int j = 0; j < es.size(); j++) {
                    pairs.add(new int[]{es.get(j), we.get(j)});
                    usedforpairs.add(es.get(j));
                    usedforpairs.add(we.get(j));
                }
                if ((we.size() - es.size()) % 2 != 0) valid = false;
            }
            if (!valid) System.out.println("NO");
            else {
                if (pairs.size() == 1 && n == 2) System.out.println("NO");
                else {
                    boolean r = true;
                    for (int[] pair : pairs) {
                        ans[pair[0]] = r ? 'R' : 'H';
                        ans[pair[1]] = r ? 'R' : 'H';
                        r = !r;
                    }
                    List<Integer> nleft = new ArrayList<>();
                    List<Integer> sleft = new ArrayList<>();
                    List<Integer> eleft = new ArrayList<>();
                    List<Integer> wleft = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        if (!usedforpairs.contains(j)) {
                            char c = instr.charAt(j);
                            switch (c) {
                                case 'W':
                                    wleft.add(j);
                                    break;
                                case 'E':
                                    eleft.add(j);
                                    break;
                                case 'N':
                                    nleft.add(j);
                                    break;
                                case 'S':
                                    sleft.add(j);
                                    break;
                            }
                        }
                    }
                    boolean alt = true;
                    for (int j = 0; j < nleft.size(); j++) {
                        ans[nleft.get(j)] = alt ? 'R' : 'H';
                        alt = !alt;
                    }
                    for (int j = 0; j < sleft.size(); j++) {
                        ans[sleft.get(j)] = alt ? 'R' : 'H';
                        alt = !alt;
                    }
                    for (int j = 0; j < eleft.size(); j++) {
                        ans[eleft.get(j)] = alt ? 'R' : 'H';
                        alt = !alt;
                    }
                    for (int j = 0; j < wleft.size(); j++) {
                        ans[wleft.get(j)] = alt ? 'R' : 'H';
                        alt = !alt;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (char c : ans) sb.append(c);
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
