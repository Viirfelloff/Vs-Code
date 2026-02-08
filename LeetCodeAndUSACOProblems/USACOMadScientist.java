import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class USACOMadScientist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pr = new PrintWriter(new FileWriter("breedflip.out"));
        int n = Integer.parseInt(br.readLine());
        String wanted = br.readLine();
        String current = br.readLine();
        //identify blocks
        List<Integer> bitmask = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (wanted.charAt(i) != current.charAt(i)) bitmask.add(1);
            else bitmask.add(0);
        }
        pr.println(getBlocks(bitmask));
        pr.flush();
        pr.close();
        br.close();
    }
    public static int getBlocks(List<Integer> bits) {
        // Convert the list of bits into a string
        StringBuilder sb = new StringBuilder();
        for (int bit : bits) {
            sb.append(bit);
        }
        String bitString = sb.toString();

        // Split the string by "0"
        String[] blocks = bitString.split("0+"); // "0+" handles consecutive zeros

        int count = 0;
        for (String block : blocks) {
            if (!block.isEmpty()) count++; // only count non-empty strings
        }
        return count;
    }
}
