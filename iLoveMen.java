// gay ahh class
import java.util.Scanner;
public class iLoveMen {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the gay club");
        System.out.println("how many times would u like to suck dick?");
        String timeswanted = scanner.nextLine();
        scanner.close();
        int realtimes = Integer.parseInt(timeswanted);
        suckdick(realtimes);
    }
    public static void suckdick(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Go");
        }
    }
}
