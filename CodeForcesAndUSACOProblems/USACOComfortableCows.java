package CodeForcesAndUSACOProblems;

import java.util.*;
//AHHHH WE GOT IT LETS FUCKING GO NEW HARDEST
public class USACOComfortableCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Pair<Integer, Integer>> occupied = new HashSet<>();
        Map<Pair<Integer, Integer>,Integer> comfortable = new HashMap<>();
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            int newcount = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair<Integer, Integer> p = new Pair<>(x,y);
            occupied.add(p);
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
            if (newcount == 3) {
                c++;
                comfortable.put(new Pair<>(x,y), 1);
            } else {
                comfortable.put(new Pair<>(x,y),0);
            }
            //coords = (x - 1, y)
            int leftCount = 0;
            if (occupied.contains(new Pair<>(x - 2,y))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x,y))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x - 1,y + 1))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x - 1,y - 1))) {
                leftCount++;
            }
            if (occupied.contains(new Pair<>(x - 1,y))) {
                if (leftCount == 3) {
                    if (comfortable.get(new Pair<>(x - 1,y)) == 0) {
                        c++;
                        comfortable.put(new Pair<>(x - 1,y), 1);
                    }
                    else c = c;
                } else {
                    if (comfortable.get(new Pair<>(x - 1,y)) == 0) c = c;
                    else {
                        c--;
                        comfortable.put(new Pair<>(x - 1,y), 0);
                    }
                }
            }
            //coords = (x + 1, y)
            int rightCount = 0;
            if (occupied.contains(new Pair<>(x,y))) {
                rightCount++;
            }
            if (occupied.contains(new Pair<>(x + 2,y))) {
                rightCount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y + 1))) {
                rightCount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y - 1))) {
                rightCount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y))) {
                if (rightCount == 3) {
                    if (comfortable.get(new Pair<>(x + 1,y)) == 0) {
                        c++;
                        comfortable.put(new Pair<>(x + 1,y), 1);
                    }
                    else c = c;
                } else {
                    if (comfortable.get(new Pair<>(x + 1,y)) == 0) c = c;
                    else {
                        c--;
                        comfortable.put(new Pair<>(x + 1,y), 0);
                    }
                }
            }
            //coords = (x, y+ 1)
            int upCount = 0;
            if (occupied.contains(new Pair<>(x - 1,y + 1))) {
                upCount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y + 1))) {
                upCount++;
            }
            if (occupied.contains(new Pair<>(x,y + 2))) {
                upCount++;
            }
            if (occupied.contains(new Pair<>(x,y))) {
                upCount++;
            }
            if (occupied.contains(new Pair<>(x,y + 1))) {
                if (upCount == 3) {
                    if (comfortable.get(new Pair<>(x, y + 1)) == 0) {
                        c++;
                        comfortable.put(new Pair<>(x, y + 1), 1);
                    }
                    else c = c;
                } else {
                    if (comfortable.get(new Pair<>(x,y + 1)) == 0) c = c;
                    else {
                        c--;
                        comfortable.put(new Pair<>(x, y + 1), 0);
                    }
                }
            }
            //coords = (x, y - 1)
            int downCount = 0;
            if (occupied.contains(new Pair<>(x - 1,y - 1))) {
                downCount++;
            }
            if (occupied.contains(new Pair<>(x + 1,y - 1))) {
                downCount++;
            }
            if (occupied.contains(new Pair<>(x,y))) {
                downCount++;
            }
            if (occupied.contains(new Pair<>(x,y - 2))) {
                downCount++;
            }
            if (occupied.contains(new Pair<>(x,y - 1))) {
                if (downCount == 3) {
                    if (comfortable.get(new Pair<>(x, y - 1)) == 0) {
                        c++;
                        comfortable.put(new Pair<>(x, y - 1), 1);
                    }
                    else c = c;
                } else {
                    if (comfortable.get(new Pair<>(x, y - 1)) == 0) c = c;
                    else {
                        c--;
                        comfortable.put(new Pair<>(x, y - 1), 0);
                    }
                }
            }
            res.add(c);
        }
        for (int xxx : res) System.out.println(xxx);
    }
}
