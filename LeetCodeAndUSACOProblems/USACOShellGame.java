package LeetCodeAndUSACOProblems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class USACOShellGame {
    public static int solution(int aa, int bb, int cc, int dd, int ee, int ff, int gg, int hh, int ii) {
        int[] arr = new int[3];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
        int points = 0;
        int possible = 1;
        ArrayList<Integer> pp = new ArrayList<>();
        for (int k = 0; k < 3; k++) {
            arr[possible - 1] = 1;
            int temp = arr[aa - 1];
            arr[aa - 1] = arr[bb - 1];
            arr[bb - 1] = temp;
            if (arr[cc - 1] == 1) {
                points++;
            }
            temp = arr[dd - 1];
            arr[dd - 1] = arr[ee - 1];
            arr[ee - 1] = temp;
            if (arr[ff - 1] == 1) {
                points++;
            }
            temp = arr[gg - 1];
            arr[gg - 1] = arr[hh - 1];
            arr[hh - 1] = temp;
            if (arr[ii - 1] == 1) {
                points++;
            }
            possible++;
            pp.add(points);
        }
        return Collections.max(pp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int i = sc.nextInt();
        System.out.println(solution(a,b,c,d,e,f,g,h,i));
    }
}
