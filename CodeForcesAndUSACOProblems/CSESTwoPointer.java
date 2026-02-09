package CodeForcesAndUSACOProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CSESTwoPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> easy = new HashSet<>();
        for (int i = 0; i < n; i++) {
            easy.add(sc.nextInt());
        }
        System.out.println(easy.size());
    }
}
