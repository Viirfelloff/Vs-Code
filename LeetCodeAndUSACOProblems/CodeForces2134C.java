import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//YOOO NO WAY WHAT THE FUCK THIS ACTUALLY WORKED FIRST TRY
//GREEDY IS FINALLY COMING THROUGH LES GOOOOOOOOOOOOOOOOOO
//FIRST DIV 2 C THIS IS INSANE I COUDLNT EVNE SOLVE B BEFORE
public class CodeForces2134C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Long> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextLong());
            long curCount = 0;
            for (int k = 0; k < n; k++) {
                if ((k + 1) % 2 == 0) {
                    if (k == n - 1) {
                        //left has to be == list.get(k)
                        if (list.get(k - 1) > list.get(k)) {
                            curCount += list.get(k - 1) - list.get(k);
                            list.set(k - 1, list.get(k));
                        }
                    } else {
                        if (list.get(k - 1) + list.get(k + 1) > list.get(k)) {
                            //fix right first
                            // if not enough to get ==, fix left.
                            //idea = even has to be == sum of odd, take min moves to do so.
                            //start with fixing by decrementing right
                            //if this works, move on. if not enough, decrement left.
                            //this should be in o(n) time.
                            //decrementing to the right first creates opportunities for
                            //other elements to get fixed. decrementing does not affect any other pairs.
                            if (list.get(k - 1) > list.get(k)) {
                                //right fix not enough
                                //set right to zero, and then fix left
                                curCount += list.get(k + 1);
                                list.set(k + 1, 0L);
                                curCount += list.get(k - 1) - list.get(k);
                                list.set(k - 1, list.get(k));
                            } else {
                                //right fix is enough
                                long temp = list.get(k + 1);
                                list.set(k + 1, list.get(k) - list.get(k - 1));
                                curCount += Math.abs(temp - list.get(k + 1));
                            }
                        }
                    }
                }
            }
            System.out.println(curCount);
        }
    }
}
