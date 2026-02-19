import java.util.*;
public class USACOYearOfTheCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String[]> instr = new ArrayList<>();
        for (int i = 0; i < n; i++) instr.add(sc.nextLine().split(" "));
        String[] zodiac = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
                "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
        Map<String, Integer> yeartoidx = new HashMap<>();
        for (int i = 0; i < 12; i++) yeartoidx.put(zodiac[i], i);
        String targetEnd = "Bessie";
        int cumulative = 0;
        String currentyear = "Ox";
        while (true) {
            String[] target = new String[8];
            for (int i = 0; i < instr.size(); i++) {
                String[] in = instr.get(i);
                if (in[7].equals(targetEnd)) {
                    target = in;
                    break;
                }
            }
            int x = yeartoidx.get(currentyear);
            int y = yeartoidx.get(target[4]);
            String dir = target[3];
            int dist;
            if (dir.equals("previous")) {
                if (y < x) dist = -(x - y);
                else dist = -((12 - y) + x);
            } else {
                if (y > x) dist = y - x;
                else dist = (12 - x) + y;
            }
            cumulative += dist;
            currentyear = target[4];
            targetEnd = target[0];
            if (targetEnd.equals("Elsie")) {
                System.out.println(Math.abs(cumulative));
                break;
            }
        }
    }
}
