import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//review
public class USACOPromotionCouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int btos = 0;
        int stog = 0;
        int gtopl = 0;
        List<Integer> bronze = new ArrayList<>();
        List<Integer> silver = new ArrayList<>();
        List<Integer> gold = new ArrayList<>();
        List<Integer> plat = new ArrayList<>();
        List<List<Integer>> ranks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int init = sc.nextInt();
            int end = sc.nextInt();
            switch (i) {
                case 0:
                    bronze.add(init);
                    bronze.add(end);
                    break;
                case 1:
                    silver.add(init);
                    silver.add(end);
                    break;
                case 2:
                    gold.add(init);
                    gold.add(end);
                    break;
                case 3:
                    plat.add(init);
                    plat.add(end);
                    break;
            }
        }
        ranks.add(bronze);
        ranks.add(silver);
        ranks.add(gold);
        ranks.add(plat);
        int inc = 0;
        for (List<Integer> quers : ranks) {
            int start = quers.get(0);
            int end = quers.get(quers.size() - 1);
            if (inc == 1) {
                btos += end - start;
            }
            else if (inc == 2) {
                btos += end - start;
                stog += end - start;
            }
            else if (inc == 3) {
                btos += end - start;
                stog += end - start;
                gtopl += end - start;
            }
            inc++;
        }
        pr.println(btos);
        pr.println(stog);
        pr.println(gtopl);
    }
}
