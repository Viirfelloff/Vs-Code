package CodeForcesAndUSACOProblems;

import java.util.*;
//Hard Problem les go
public class USACOMilkMeasurement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Map<String, Integer>> map1 = new LinkedHashMap<>();
        Map<String, Integer> outputs = new LinkedHashMap<>();
        String initial = "fuck this";
        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            String cow = sc.next();
            if (i == 0) initial = cow;
            int increment = sc.nextInt();
            Map<String, Integer> map2 = new LinkedHashMap<>();
            map2.put(cow, increment);
            outputs.put(cow, 7);
            map1.put(day, map2);
        }
        ArrayList<Integer> days = new ArrayList<>(map1.keySet());
        Collections.sort(days);

        int changes = 0;

        // Initialize prevLeaders with all cows because initially all have 7 gallons
        Set<String> prevLeaders = new HashSet<>(outputs.keySet());

        for (int k = 0; k < days.size(); k++) {
            int dayy = days.get(k);
            Map.Entry<String, Integer> entry = map1.get(dayy).entrySet().iterator().next();
            String cow = entry.getKey();
            int value = entry.getValue();
            outputs.put(cow, outputs.get(cow) + value);

            int max = Collections.max(outputs.values());
            Set<String> currentLeaders = new HashSet<>();
            for (String c : outputs.keySet()) {
                if (outputs.get(c) == max) {
                    currentLeaders.add(c);
                }
            }

            if (!currentLeaders.equals(prevLeaders)) {
                changes++;
                prevLeaders = new HashSet<>(currentLeaders);
            }
        }

        System.out.println(changes);
    }
}
