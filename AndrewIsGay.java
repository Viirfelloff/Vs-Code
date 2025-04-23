import java.util.Scanner;
public class AndrewIsGay {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who would u like to describe?");
        String person = scanner.nextLine();
        scanner.close();
        describeAndrew(1);
    }
    public static void describeAndrew(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Im so majestic");
        }
    }
}
