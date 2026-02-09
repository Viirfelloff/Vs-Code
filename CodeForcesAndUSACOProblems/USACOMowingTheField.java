package CodeForcesAndUSACOProblems;

import java.util.*;

public class USACOMowingTheField {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int y = 0;
        Map<String, Integer> visited = new HashMap<>();
        ArrayList<Integer> maxTimes = new ArrayList<>();
        visited.put("00", 0);
        int time = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                StringBuilder sb = new StringBuilder();
                switch (s) {
                    case "N" -> {
                        y++;
                    }
                    case "S" -> {
                        y--;
                    }
                    case "E" -> {
                        x++;
                    }
                    case "W" -> {
                        x--;
                    }
                }
                sb.append(x);
                sb.append(",");
                sb.append(y);
                time++;
                if (visited.containsKey(sb.toString()) && !sb.toString().equals("00")) {
                    maxTimes.add(time - visited.get(sb.toString()));
                    sb.setLength(0);

                }
                visited.put(sb.toString(), time);
            }
        }
        if (maxTimes.isEmpty()) System.out.println(-1);
        else System.out.println(Collections.min(maxTimes));
    }
}
