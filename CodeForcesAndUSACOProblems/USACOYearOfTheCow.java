import java.util.*;
public class USACOYearOfTheCow {
    public static void main(String[] args) {
        //golly bro finally ts stupid ass problem
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String[]> instr = new ArrayList<>();
        for (int i = 0; i < n; i++) instr.add(sc.nextLine().split(" "));
        String[] zodiac = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
                "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
        Map<String, Integer> yeartoidx = new HashMap<>();
        for (int i = 0; i < 12; i++) yeartoidx.put(zodiac[i], i);
        List<String> chain = new ArrayList<>();
        chain.add("Elsie");
        while (true) {
            for (int i = 0; i < n; i++) {
                if (instr.get(i)[0].equals(chain.get(chain.size() - 1))) {
                    chain.add(instr.get(i)[7]);
                    break;
                }
            }
            if (chain.get(chain.size() - 1).equals("Bessie")) break;
        }
        int pointer = chain.size() - 1;
        int pointer2 = chain.size() - 2;
        int cumulative = 0;
        String currentyear = "Ox";
        while (true) {
            String targetEnd = chain.get(pointer);
            if (targetEnd.equals("Elsie")) {
                System.out.println(Math.abs(cumulative));
                break;
            }
            String targetStart = chain.get(pointer2);
            String[] target = new String[8];
            for (int i = 0; i < instr.size(); i++) {
                String[] in = instr.get(i);
                if (in[7].equals(targetEnd) && in[0].equals(targetStart)) {
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
            pointer--;
            pointer2--;
        }
    }
}
