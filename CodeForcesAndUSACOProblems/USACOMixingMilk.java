package CodeForcesAndUSACOProblems;
public class USACOMixingMilk {
    public static void solution(int cap1, int cap2, int cap3, int amt1, int amt2, int amt3) {
        for (int i = 0; i < 100; i++) {
            int pour = 0;

            if (i % 3 == 0) { // 1 → 2
                pour = Math.min(amt1, cap2 - amt2);
                amt1 -= pour;
                amt2 += pour;
            } else if (i % 3 == 1) { // 2 → 3
                pour = Math.min(amt2, cap3 - amt3);
                amt2 -= pour;
                amt3 += pour;
            } else { // 3 → 1
                pour = Math.min(amt3, cap1 - amt1);
                amt3 -= pour;
                amt1 += pour;
            }
        }

        System.out.println(amt1);
        System.out.println(amt2);
        System.out.println(amt3);
    }

    public static void main(String[] args) {
        solution(5,7,10,5,0,7);
    }
}
