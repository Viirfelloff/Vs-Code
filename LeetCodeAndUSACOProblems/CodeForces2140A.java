import java.util.Scanner;

public class CodeForces2140A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean oneseq = false;
            int seqs = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    if (!oneseq) {
                        oneseq = true;
                    }
                } else {
                    if (oneseq) {
                        oneseq = false;
                        seqs++;
                    }
                }
            }
            System.out.println(seqs);
        }
    }
}
