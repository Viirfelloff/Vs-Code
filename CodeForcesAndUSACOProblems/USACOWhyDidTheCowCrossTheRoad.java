package CodeForcesAndUSACOProblems;

import java.util.*;

public class USACOWhyDidTheCowCrossTheRoad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> ids = new LinkedHashSet<>();
        List<Integer> nums = new ArrayList<>();
        List<Integer> sides = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int side = sc.nextInt();
            ids.add(id);
            nums.add(id);
            sides.add(side);
        }
        int crosses = 0;
        Map<Integer, Integer> lastStates = new LinkedHashMap<>();
        for (int x : ids) {
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j) == x) {
                    if (!lastStates.containsKey(x)) {
                        lastStates.put(x, sides.get(j));
                    } else {
                        if (lastStates.get(x) != sides.get(j)) {
                            crosses++;
                        }
                        lastStates.put(x, sides.get(j));
                    }
                }
            }
        }
        System.out.println(crosses);
    }
}
