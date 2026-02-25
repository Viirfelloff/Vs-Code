import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> changes = new ArrayList<>();
            int n = sc.nextInt();
            List<int[]> obs = new ArrayList<>();
            for (int j = 0; j < 2 * n; j++) {
                if (j < n) {
                    changes.add(sc.nextInt());
                } else {
                    obs.add(new int[]{sc.nextInt(), sc.nextInt()});
                }
            }
            boolean val = true;
            for (int j = 0; j < n - 1; j++) {
                int diff = obs.get(j)[1] - obs.get(j + 1)[0];
                if (diff < -1) {
                    val = false;
                    break;
                }
            }
            if (obs.get(0)[0] > 1) System.out.print(-1);
            else if (!val) System.out.print(-1);
            else {
                //try implementing a difference array and then using prefix sums to avoid tle if the approach does not work
                //way more efficient than iterating backwards every time u encounter a diff
                //so first, construct a min needed list. how? go thru and construct a min height list.
                //then iterate through. every time you encounter a diff, go back diff times and increase min by one.
                //after, you have the array. now, iterate through the min needed list. keep count of current ones
                //and also list of neg ones up to that point. if its > 0, then including that point and before,
                //you need that number of 1s. if its satisfied, skip. if not, go thru backwards neg one list and assign 1
                //until satisfied. (this step may also require a diff array)
                List<Integer> minheight = new ArrayList<>();
                int curmin = 0;
                boolean valid = true;
                for (int j = 0; j < n; j++) {
                    int[] obstacle = obs.get(j);
                    int min = obstacle[0];
                    if (curmin > obstacle[1]) {
                        valid = false;
                        break;
                    }
                    if (min > curmin) curmin = min;
                    minheight.add(curmin);
                }
                if (!valid) System.out.print(-1);
                else {
                    boolean v2 = true;
                    List<Integer> minneeded = new ArrayList<>();
                    int f = 0;
                    for (int j = 0; j < n; j++) {
                        if (j == 0) {
                            int diff = Math.abs(minheight.get(j) - f);
                            if (diff > 1) {
                                v2 = false;
                                break;
                            } else if (diff == 1) minneeded.add(1);
                            else minneeded.add(0);
                        } else {
                            int diff = Math.abs(minheight.get(j) - minheight.get(j - 1));
                            if (diff > 0) {
                                if (diff == 1) minneeded.add(minneeded.get(minneeded.size() - 1) + 1);
                                else {
                                    minneeded.add(minheight.get(j));
                                    int idx = minneeded.size() - 2;
                                    for (int k = minheight.get(j) - 1; k > 0; k--) {
                                        if (idx < 0) {
                                            v2 = false;
                                            break;
                                        }
                                        minneeded.set(idx, k);
                                        idx--;
                                    }
                                }
                            } else minneeded.add(minneeded.get(minneeded.size() - 1));
                        }
                    }
                    if (!v2) System.out.print(-1);
                    else if (minneeded.get(0) == 1 && changes.get(0) == 0) System.out.print(-1);
                    else {
                        boolean v3 = true;
                        List<Integer> negones = new ArrayList<>();
                        int curones = 0;
                        for (int j = 0; j < n; j++) {
                            if (changes.get(j) == 1) curones++;
                            else if (changes.get(j) == -1) negones.add(j);
                            if (minneeded.get(j) > 0 && curones < minneeded.get(j)) {
                                int left = minneeded.get(j) - curones;
                                if (left > negones.size()) {
                                    v3 = false;
                                    break;
                                }
                                while (left > 0) {
                                    changes.set(negones.get(negones.size() - 1), 1);
                                    negones.remove(negones.size() - 1);
                                    left--;
                                    curones++;
                                }
                            }
                        }
                        if (!v3) System.out.print(-1);
                        else if (obs.get(0)[1] == 0 && changes.get(0) == 1) System.out.print(-1);
                        else {
                            for (int x : changes) {
                                if (x == -1) System.out.print("0" + " ");
                                else System.out.print(x + " ");
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
