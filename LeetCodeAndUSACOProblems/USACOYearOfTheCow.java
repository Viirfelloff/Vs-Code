package LeetCodeAndUSACOProblems;
import java.util.*;
//Failed yet again.
public class USACOYearOfTheCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String[]> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(sc.nextLine().split(" "));
        }

        String[] zodiac = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
                "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
        Map<String, Integer> year = new HashMap<>();
        year.put("Bessie", 0);

        while (!input.isEmpty()) {
            Iterator<String[]> it = input.iterator();
            while (it.hasNext()) {
                String[] line = it.next();
                String newCow = line[0];
                String direction = line[3];
                String animal = line[4];
                String reference = line[7];

                if (year.containsKey(reference)) {
                    int refYear = year.get(reference);
                    int refAnimalIdx = Arrays.asList(zodiac).indexOf(getZodiac(refYear, zodiac));
                    int targetAnimalIdx = Arrays.asList(zodiac).indexOf(animal);
                    int diff;
                    if (direction.equals("previous")) {
                        diff = (refAnimalIdx - targetAnimalIdx + 12) % 12;
                        diff = diff == 0 ? -12 : -diff;
                    } else {
                        diff = (targetAnimalIdx - refAnimalIdx + 12) % 12;
                        diff = diff == 0 ? 12 : diff;
                    }
                    year.put(newCow, refYear + diff);
                    it.remove();
                }
            }
        }

        System.out.println(Math.abs(year.get("Elsie")));
    }

    static String getZodiac(int yearOffset, String[] zodiac) {
        return zodiac[(yearOffset % 12 + 12) % 12];
    }
}
