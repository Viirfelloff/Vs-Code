package LeetCodeAndUSACOProblems;
import java.util.*;
//alr we good
public class USACOBlockGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Character> alpha = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            alpha.add((char)('a' + j));
        }
        int[] res = new int[26];
        List<String> fronts = new ArrayList<>();
        List<String> backs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fronts.add(sc.next());
            backs.add(sc.next());
        }
        for (int k = 0; k < fronts.size(); k++) {
            Map<Character, Integer> map1 = new LinkedHashMap<>();
            Map<Character, Integer> map2 = new LinkedHashMap<>();
            for (char c : fronts.get(k).toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
            for (char cc : backs.get(k).toCharArray()) {
                map2.put(cc, map2.getOrDefault(cc, 0) + 1);
            }
            Map<Character, Integer> linked = new LinkedHashMap<>();
            for (char cccc : map2.keySet()) {
                linked.put(cccc, map2.get(cccc));
            }
            for (char ccc : map1.keySet()) {
                if (linked.containsKey(ccc)) {
                    linked.put(ccc, Math.max(linked.get(ccc), map1.get(ccc)));
                } else {
                    linked.put(ccc, map1.get(ccc));
                }
            }
            for (char e : linked.keySet()) {
                res[alpha.indexOf(e)] = res[alpha.indexOf(e)] + linked.get(e);
            }
        }
        for (int b : res) {
            System.out.println(b);
        }
    }
}
