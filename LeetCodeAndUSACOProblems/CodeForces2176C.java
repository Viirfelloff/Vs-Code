import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//LETS GO FIRST TRY ONLY ERRORS WERE SORTING AND INCORRECT USE OF INT FOR CS
public class CodeForces2176C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(sc.nextInt());
            //For every k, first take the largest odd number and print. Then keep adding even numbers in descending order.
            // If you run out, then comes the tricky part. U always need the largest odd as a buffer for even numbers.
            // When you have these excess odd, the size does not matter.
            // If there is an even number of excess, they can cancel each other out and sum stays the same.
            //If there is an odd number, you need to sacrifice the smallest even to incorporate another odd and cancel out. So alternate printing between these.
            List<Integer> evens = new ArrayList<>();
            List<Integer> odds = new ArrayList<>();
            for (int x : list) {
                if (x % 2 == 0) evens.add(x);
                else odds.add(x);
            }
            Collections.sort(odds, Collections.reverseOrder());
            Collections.sort(evens, Collections.reverseOrder());
            //above lists are dynamic
            if (odds.isEmpty()) {
                for (int m = 0; m < n; m++) System.out.println(0);
            }
            else if (evens.isEmpty()) {
                int largestOdd = odds.get(0);
                for (int m = 1; m <= n; m++) {
                    if (m % 2 == 0) System.out.println(0);
                    else System.out.println(largestOdd);
                }
            } else {
                int largestOdd = odds.get(0);
                odds.remove(0);
                long cs = 0;
                cs += largestOdd;
                //arjan fuck u
                int k = 0;
                System.out.println(cs);
                k++;
                for (int j = 0; j < evens.size(); j++) {
                    cs += evens.get(j);
                    System.out.println(cs);
                    k++;
                }
                int opsleft = n - k;
                //alternate subbing out an even for an odd and printing og
                for (int m = 1; m <= opsleft; m++) {
                    if (m == opsleft) {
                        //u are not allowed to switch out
                        if (m % 2 == 0) System.out.println(cs);
                        else System.out.println(0);
                    } else {
                        if (m % 2 == 0) {
                            //all cancel out
                            System.out.println(cs);
                        } else {
                            //rest cancel out, u have one left over so u have to sub out smallest even to compensate
                            //does this even work
                            System.out.println(cs - evens.get(evens.size() - 1));
                        }
                    }
                }
            }
        }
    }
}
