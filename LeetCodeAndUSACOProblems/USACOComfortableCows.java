package LeetCodeAndUSACOProblems;

import java.util.*;
//continue 9/2
public class USACOComfortableCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair<Integer, Integer>> occupied = new ArrayList<>();
        Map<Pair<Integer, Integer>,Integer> comfortable = new HashMap<>();
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            int newcount = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair<Integer, Integer> p = new Pair<>(x,y);
            if (occupied.contains(new Pair<>(x -1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y + 1))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y - 1))) {
                newcount++;
            }
            if (newcount == 3) c++;
            occupied.add(p);
            //coords = (x - 1, y)
            int leftCount = 0;
            if (occupied.contains(new Pair<>(x - 2,y))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x - 1 + 1,y))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x - 1,y + 1))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x - 1,y - 1))) {
                leftCount++;
            }
            if (leftCount == 3) c++;
            //coords = (x + 1, y)
            int rightCount = 0;
            if (occupied.contains(new Pair<>(x -1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y + 1))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y - 1))) {
                newcount++;
            }
            //coords = (x, y+ 1)
            int upCount = 0;
            if (occupied.contains(new Pair<>(x -1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y + 1))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y - 1))) {
                newcount++;
            }
            //coords = (x, y - 1)
            int downCount = 0;
            if (occupied.contains(new Pair<>(x -1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y + 1))) {
                newcount++;
            }
            if (occupied.contains(new Pair<>(x,y - 1))) {
                newcount++;
            }
        }
    }
}
