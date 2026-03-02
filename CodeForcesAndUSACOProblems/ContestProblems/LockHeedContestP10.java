import java.util.*;
public class LockHeedContestP10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strawswirl = Arrays.asList("strawberry", "blueberry");
        List<String> banburst = Arrays.asList("banana", "kiwi", "orange");
        List<String> troptango = Arrays.asList("kiwi", "orange", "mango", "blueberry");
        List<String> mangmedley = Arrays.asList("mango", "strawberry", "blueberry", "banana");
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String[] ingred = sc.nextLine().split("\\|");
            List<String> ingredients = new ArrayList<>(Arrays.asList(ingred));
            String smoothie = sc.nextLine();
            boolean valid = switch (smoothie) {
                case "strawberry swirl" -> new HashSet<>(ingredients).containsAll(strawswirl);
                case "banana burst" -> new HashSet<>(ingredients).containsAll(banburst);
                case "tropical tango" -> new HashSet<>(ingredients).containsAll(troptango);
                default -> new HashSet<>(ingredients).containsAll(mangmedley);
            };
            System.out.println(valid ? "YES" : "NO");
        }
    }
}
