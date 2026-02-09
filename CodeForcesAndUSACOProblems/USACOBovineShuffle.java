package CodeForcesAndUSACOProblems;

import java.util.HashMap;
import java.util.Map;
//yo soy el
public class USACOBovineShuffle {
    public static int[] solution (int cows, int[] order, int[] mixed) {
        int[] ordered = new int[cows];
        Map<Integer, Integer> non = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            non.put(order[i], mixed[i]);
        }
        for (int i = 0; i < order.length; i++) {
            ordered[i] = non.get(i + 1);
        }
        return ordered;
    }
    public static void main (String[] args) {
        int[] order = {1,3,4,5,2};
        int[] mixed = {1234567,2222222,3333333,4444444,5555555};
        int[] res = solution(5,order, mixed);
        for (int s : res) {
            System.out.println(s);
        }
    }
}
