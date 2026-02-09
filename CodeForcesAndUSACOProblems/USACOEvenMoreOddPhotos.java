package CodeForcesAndUSACOProblems;

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
        
    }
}
