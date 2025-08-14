package LeetCodeAndUSACOProblems;
import java.util.*;
//les gooo we did it. chat gpt gaslighting me once again
public class USACOCircularBarn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> rooms = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            rooms.add(next);
            sum += next;
        }
        List<Integer> lengths = new ArrayList<>();
        //J: room to start in
        for (int j = 0; j < rooms.size(); j++) {
            int total = sum;
            int dist = 0;
            int iterations = 0;
            int index = j;
            while (iterations < rooms.size()) {
                dist += total - rooms.get(index);
                total -= rooms.get(index);
                if (index == rooms.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
                iterations++;
            }
            lengths.add(dist);
        }
        System.out.println(Collections.min(lengths));
    }
}
