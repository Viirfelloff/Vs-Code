package LeetCodeAndUSACOProblems;


import java.util.*;
//LES GOOOO WE UP WE DID ANOTHER HARD PROBLEM ON OUR OWNNNN
public class USACOGuessTheAnimla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> animal = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        List<List<String>> chars = new ArrayList<>();
        Map<String, Integer> collective = new HashMap<>();
        for (int i = 0; i < n; i++) {
            animal.add(sc.next());
            int kk = sc.nextInt();
            k.add(kk);
            List<String> ch = new ArrayList<>();
            for (int j = 0; j < kk; j++) {
                String c = sc.next();
                ch.add(c);
                collective.put(c, collective.getOrDefault(c,0) + 1);
            }
            chars.add(ch);
        }
        List<Integer> yes = new ArrayList<>();
        for (int m = 0; m < n; m++) {
            String pos = animal.get(m);
            int ye = 0;
            List<String> chs = chars.get(m);
            chs.sort((a,b) -> collective.get(b) - collective.get(a));
            for (String mm : chs) {
                if (collective.get(mm) > 1) ye += 1;
                else {
                    ye += 1;
                    break;
                }
            }
            yes.add(ye);
        }
        System.out.println(Collections.max(yes));
    }
}
