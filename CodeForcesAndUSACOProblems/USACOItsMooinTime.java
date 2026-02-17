import java.util.*;
public class USACOItsMooinTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        String s = sc.next();
        List<Character> alpha = new ArrayList<>();
        for (int i = 0; i < 26; i++) alpha.add((char) ('a' + i));
        if (f == 1) {
            List<String> moo = new ArrayList<>();
            for (int i = 0; i < n - 2; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                sb.append(s.charAt(i + 1));
                sb.append(s.charAt(i + 2));
                if (ismoo(sb.toString())) {
                    char exclude = sb.charAt(0);
                    for (char c : alpha) {
                        if (c != exclude) {
                            StringBuilder newsb = new StringBuilder();
                            newsb.append(sb);
                            newsb.replace(0, 1, String.valueOf(c));
                            moo.add(newsb.toString());
                        }
                    }
                } else {
                    String mo = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    if (mo.charAt(0) != mo.charAt(1) && mo.charAt(1) != mo.charAt(2)) {
                        sb2.append(mo.charAt(0));
                        sb2.append(mo.charAt(1));
                        sb2.append(mo.charAt(1));
                        moo.add(sb2.toString());
                        sb2.setLength(0);
                        sb2.append(mo.charAt(0));
                        sb2.append(mo.charAt(2));
                        sb2.append(mo.charAt(2));
                        moo.add(sb2.toString());
                    }
                    else if (mo.charAt(0) == mo.charAt(1) && mo.charAt(1) == mo.charAt(2)) {
                        for (char c : alpha) {
                            StringBuilder newsb = new StringBuilder();
                            newsb.append(mo);
                            newsb.replace(0, 1, String.valueOf(c));
                            moo.add(newsb.toString());
                        }
                    }
                }
            }
            Collections.sort(moo);
            System.out.println(moo.size());
            for (String ss : moo) System.out.println(ss);
        } else {
            Map<String, Set<Integer>> moos = new HashMap<>();
            Map<String, Set<Integer>> nonmoos = new HashMap<>();
            for (int i = 0; i < n - 2; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                sb.append(s.charAt(i + 1));
                sb.append(s.charAt(i + 2));
                if (ismoo(sb.toString())) {
                    Set<Integer> set;
                    if (moos.containsKey(sb.toString())) {
                        set = moos.get(sb.toString());
                    } else {
                        set = new HashSet<>();
                    }
                    set.add(i);
                    moos.put(sb.toString(), set);
                }
                else {
                    Set<Integer> set;
                    if (nonmoos.containsKey(sb.toString())) {
                        set = nonmoos.get(sb.toString());
                    } else {
                        set = new HashSet<>();
                    }
                    set.add(i);
                    nonmoos.put(sb.toString(), set);
                }
            }
            List<String> moocount = new ArrayList<>();
            for (String moo : moos.keySet()) {
                if (moos.get(moo).size() >= f) moocount.add(moo);
                else {
                    if (f - moos.get(moo).size() == 1) {
                        outer:
                        for (int j = 0; j < 3; j++) {
                            for (char c : alpha) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(moo);
                                sb.replace(j,j + 1, String.valueOf(c));
                                if (nonmoos.containsKey(sb.toString())) {
                                    Set<Integer> firstidx = nonmoos.get(sb.toString());
                                    for (int k : firstidx) {
                                        int idx = k + j;
                                        Set<Integer> fidx = moos.get(moo);
                                        for (int x : fidx) {
                                            if (!(idx == x || idx == x + 1 || idx == x + 2)) {
                                                moocount.add(moo);
                                                break outer;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Collections.sort(moocount);
            System.out.println(moocount.size());
            for (String mooo : moocount) System.out.println(mooo);
        }
    }
    public static boolean ismoo(String s) {
        return s.length() == 3 && (s.charAt(0) != s.charAt(1) && s.charAt(1) == s.charAt(2));
    }
}
