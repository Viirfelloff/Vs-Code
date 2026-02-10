import java.util.*;

public class CodeForces1667A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextLong());
        List<Long> moves = new ArrayList<>();
        //we consider every index as the 'zero' point.
        //propagate left and right, making increasing negative and positive arrays,
        //respectively. add moves to list and take minimum
        for (int i = 0; i < n; i++) {
            long[] arr = new long[n];
            //for right - left, if the current number > the next to the right, we can ignore.
            //else, the amount you need to decrease is the floor of right / current + 1.
            //or use int division
            //add this number to total moves.
            //for left - right, if current num < next to left, ignore
            //else use the same formula, moves += floor of (left / cur).
            // ex: 7, 2. moves += floor(3.5) + 1, which is 4.
            long dec = 0;
            if (i == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (j == i + 1) {
                        arr[j] = list.get(j);
                        dec++;
                    } else {
                        if (Math.abs(arr[j - 1]) >= list.get(j)) {
                            long times = (arr[j - 1] / list.get(j)) + 1;
                            dec += times;
                            arr[j] = (list.get(j) * times);
                        } else {
                            dec++;
                            arr[j] = list.get(j);
                        }
                    }
                }
            }
            else if (i == n - 1) {
                for (int j = i - 1; j >= 0; j--) {
                    if (j == i - 1) {
                        arr[j] = -list.get(j);
                        dec++;
                    } else {
                        if (list.get(j) <= Math.abs(arr[j + 1])) {
                            long times = (-arr[j + 1] / list.get(j)) + 1;
                            dec += times;
                            arr[j] = -(list.get(j) * times);
                        } else {
                            dec++;
                            arr[j] = -list.get(j);
                        }
                    }
                }
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (j == i - 1) {
                        arr[j] = -list.get(j);
                        dec++;
                    } else {
                        if (list.get(j) <= Math.abs(arr[j + 1])) {
                            long times = (-arr[j + 1] / list.get(j)) + 1;
                            dec += times;
                            arr[j] = -(list.get(j) * times);
                        } else {
                            dec++;
                            arr[j] = -list.get(j);
                        }
                    }
                }
                for (int j = i + 1; j < n; j++) {
                    if (j == i + 1) {
                        arr[j] = list.get(j);
                        dec++;
                    } else {
                        if (Math.abs(arr[j - 1]) >= list.get(j)) {
                            long times = (arr[j - 1] / list.get(j)) + 1;
                            dec += times;
                            arr[j] = (list.get(j) * times);
                        } else {
                            dec++;
                            arr[j] = list.get(j);
                        }
                    }
                }
            }
            moves.add(dec);
        }
        System.out.println(Collections.min(moves));
    }
}
