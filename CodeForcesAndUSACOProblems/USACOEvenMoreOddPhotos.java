import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOEvenMoreOddPhotos {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());
        //remember - group to alternate between even and odd.
        //extra evens can be ignored because they do not change parity.
        //even groups can be achieved through an even number of odds or one even.
        //odd groups can be achieved through odd numbers of odds.
        //if you have any number of extra evens, ignore and go w current groups.
        //to get the extra odds, alternate, constructing groups of evens and odds
        //for an even group immediately look for one even. odds are 1 odd.
        //if you run out of odds, end and print the groups
        //if you run out of evens, the extra odds will change the parity of anything you combine them with.
        //take each group of odds, and add them together to obtain evens.
        //adding these will make no difference.
        //if you have an odd number of extra odds, this operation will leave one odd remaining.
        //to resolve this, take 2 cases. you have ran out of evens, so the last group you formed was odd.
        //you have to then, have an equal amount of odd and even groups. so you cannot change the parity of any one group.
        //we cannot add or change groups, so we have to subtract groups
        //let's try subtracting one group. it can be shown that this is the most optimal.
        //combine an even and an odd group from the beginning to maintain order.
        //even + odd = odd. we then add this extra to our new group. it becomes even.
        //the last group we formed was odd, so we can append this new even and be done!!!!!
        int evens = 0;
        int odds = 0;
        for (int x : list) {
            if (x % 2 == 0) evens++;
            else odds++;
        }
        int groups = 0;
        int parity = 0;
        while (evens != 0 || odds != 0) {
            if (evens == 0) {
                groups++;
                if (odds % 2 == 0) break;
                else {
                    groups--;
                    break;
                }
            }
            if (odds == 0) {
                groups++;
                break;
            }
            if (evens != 0 && odds != 0) {
                if (parity % 2 == 0) {
                    evens--;
                } else {
                    odds--;
                }
                groups++;
            }
            parity++;
        }
        System.out.println(groups);
    }
}
