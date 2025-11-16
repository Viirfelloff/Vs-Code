import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USACOTrainingGateWayP1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("ride.out"));
        String a = String.valueOf(br.readLine());
        String b = String.valueOf(br.readLine());
        List<Character> alpha = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            alpha.add((char)('A' + i));
        }
        int sum1 = 0;
        int sum2 = 0;
        for (char c: a.toCharArray()) sum1 += alpha.indexOf(c);
        for (char c: b.toCharArray()) sum2 += alpha.indexOf(c);
        if (sum1 % 47 == sum2 % 47) pr.print("GO");
        else pr.print("STAY");
        pr.flush();
        br.close();
    }
}
