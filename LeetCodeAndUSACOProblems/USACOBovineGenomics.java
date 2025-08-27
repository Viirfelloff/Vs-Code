package LeetCodeAndUSACOProblems;

import java.util.*;

//understood a hard? are we moving up in life?
//update - ayy we basically solved it ourselves
public class USACOBovineGenomics {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<char[]> spotties = new ArrayList<>();
        List<char[]> plains = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            if (i < n / 2) {
                spotties.add(sc.next().toCharArray());
            } else {
                plains.add(sc.next().toCharArray());
            }
        }
        int tuples = 0;
        for (int j = 0; j < m; j++) {
            for (int v = j + 1; v < m; v++) {
                for (int e = v + 1; e < m; e++) {
                    HashSet<List<Character>> spottuples = new LinkedHashSet<>();
                    HashSet<List<Character>> plaintuples = new LinkedHashSet<>();
                    for (char[] s : spotties) {
                        spottuples.add(Arrays.asList(s[j],s[v],s[e]));
                    }
                    for (char[] ss : plains) {
                        plaintuples.add(Arrays.asList(ss[j],ss[v],ss[e]));
                    }
                    boolean disjoint = true;
                    for (List<Character> c : spottuples) {
                        if (plaintuples.contains(c)) {
                            disjoint = false;
                            break;
                        }
                    }
                    if (disjoint) {
                        tuples++;
                    }
                }
            }
        }
    }
}
