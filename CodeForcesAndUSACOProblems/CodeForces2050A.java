import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForces2050A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<String> words = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                words.add(sc.next());
            }
            int wordCounter = 0;
            int charCounter = 0;
            for (String s : words) {
                if (charCounter + s.length() > m) {
                    break;
                } else {
                    charCounter += s.length();
                    wordCounter++;
                }
            }
            System.out.println(wordCounter);
        }
    }
}
