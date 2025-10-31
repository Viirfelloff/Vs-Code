import javax.swing.plaf.IconUIResource;
import java.util.*;
//LETS GOOOO WE DID IT OUR FIRST 1200 WITH ZERO HELP
public class CodeForces2137D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> occ = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                occ.add(sc.nextInt());
            }
            Map<Integer, Integer> occoccpre = new HashMap<>();
            int totalElements = 0;
            for (int x: occ) {
                occoccpre.put(x, occoccpre.getOrDefault(x, 0) + 1);
                if (occoccpre.get(x) == x) {
                    totalElements += x;
                    occoccpre.put(x,0);
                }
            }
            if (totalElements != n) {
                System.out.println(-1);
            } else {
                Map<Integer, Integer> occocc = new HashMap<>();
                List<Integer> res = new ArrayList<>();
                int curElement = n + 1;
                Map<Integer, Integer> elementToSolution = new HashMap<>();
                for (int x : occ) {
                    occocc.put(x, occocc.getOrDefault(x, 0) + 1);
                    if (!elementToSolution.containsKey(x)) {
                        curElement--;
                        elementToSolution.put(x, curElement);
                    }
                    else if (occocc.get(x) > x) {
                        curElement--;
                        elementToSolution.put(x, curElement);
                        occocc.put(x, 1);
                    }
                    res.add(elementToSolution.get(x));
                }
                for (int x : res) System.out.println(x);
            }
        }
    }
}
