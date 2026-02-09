package CodeForcesAndUSACOProblems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcess2047A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> layers = new ArrayList<>();
        int totall = 0;
        for (int k = 1; k <= 100; k++) { // generate up to 100 layers
            int piecesInLayer = (k == 1) ? 1 : 8 * (k - 1);
            totall += piecesInLayer;
            layers.add(totall);
        }
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int total = 0;
            int happy = 0;
            for (int k = 0; k < n; k++) {
                total += sc.nextInt();
                if (layers.contains(total)) happy++;
            }
            System.out.println(happy);
        }
    }
}
