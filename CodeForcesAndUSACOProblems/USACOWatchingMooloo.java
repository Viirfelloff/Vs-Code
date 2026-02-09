import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOWatchingMooloo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < n; i++) days.add(sc.nextInt());
        long tS = 0;
        int curD = 0;
        int curStartDay = 0;
        boolean extend = false;
        int currentDaysExtended = 0;
        for (int i = 0; i < n; i++) {
            if (!extend) {
                curStartDay = days.get(i);
                currentDaysExtended = 0;
                currentDaysExtended++;
                extend = true;
            } else {
                curD = days.get(i) - curStartDay + 1;
                currentDaysExtended++;
                if (curD >= currentDaysExtended) {
                    extend = false;
                    tS += days.get(i - 1) - curStartDay + 1 + k;
                    i--;
                }
            }
        }
        tS += days.get(n - 1) - curStartDay + 1 + k;
        System.out.println(tS);
    }
}
