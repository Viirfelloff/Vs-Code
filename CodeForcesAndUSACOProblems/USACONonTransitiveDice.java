import java.util.Scanner;

public class USACONonTransitiveDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[] a = new int[4];
            int[] b = new int[4];
            for (int n = 0; n < 4; n++) a[n] = sc.nextInt();
            for (int v = 0; v < 4; v++) b[v] = sc.nextInt();
            boolean valid = false;
            outer:
            for (int j = 1; j <= 10; j++) {
                for (int c = 1; c <= 10; c++) {
                    for (int k = 1; k <= 10; k++) {
                        for (int f = 1; f <= 10; f++) {
                            int[] C = new int[]{j, c, k, f};

                            // --- check C beats A ---
                            int cBeatsA = 0;
                            for (int x : C) {
                                for (int y : a) {
                                    if (x > y) cBeatsA++;
                                }
                            }
                            boolean beatsA = cBeatsA >= 9;

                            // --- check C loses to B (B beats C) ---
                            int bBeatsC = 0;
                            for (int x : b) {
                                for (int y : C) {
                                    if (x > y) bBeatsC++;
                                }
                            }
                            boolean losesToB = bBeatsC >= 9;

                            if (beatsA && losesToB) {
                                valid = true;
                                break outer;
                            }

                            // --- check second ordering: B beats A, C beats B, A beats C ---

                            // B beats A
                            int bBeatsA = 0;
                            for (int x : b) {
                                for (int y : a) {
                                    if (x > y) bBeatsA++;
                                }
                            }
                            boolean beatsASecond = bBeatsA >= 9;

                            // C beats B
                            int cBeatsB = 0;
                            for (int x : C) {
                                for (int y : b) {
                                    if (x > y) cBeatsB++;
                                }
                            }
                            boolean beatsB = cBeatsB >= 9;

                            // A beats C
                            int aBeatsC = 0;
                            for (int x : a) {
                                for (int y : C) {
                                    if (x > y) aBeatsC++;
                                }
                            }
                            boolean beatsC = aBeatsC >= 9;

                            if (beatsASecond && beatsB && beatsC) {
                                valid = true;
                                break outer;
                            }

                        }
                    }
                }
            }
            if (valid) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
