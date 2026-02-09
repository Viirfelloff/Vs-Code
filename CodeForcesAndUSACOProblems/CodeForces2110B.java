package CodeForcesAndUSACOProblems;

import java.util.*;

//Yooo b problem
public class CodeForces2110B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list1 = new ArrayList<>();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            list1.add(sc.next());
        }
        for (String ss : list1) {
            Map<Integer, Integer> map1 = new HashMap<>();
            List<Integer> open = new ArrayList<>();
            int inc = 0;
            for (char c : ss.toCharArray()) {
                if (c == '(') open.add(inc);
                else {
                    map1.put(open.getLast(), inc);
                    open.remove(open.getLast());
                }
                inc++;
            }
            if (map1.get(0) == ss.length() - 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
