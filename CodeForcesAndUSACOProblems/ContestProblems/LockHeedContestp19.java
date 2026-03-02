import java.util.Scanner;
public class LockHeedContestp19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            while (s.contains("(")) {
                //process is remove last open, opens will always be preceded by a number
                //take string inside the last open and current closed and repeat by taht number
                //j changes by the number of extra characters you append - 3.
                //number of extra characters is current characters * (number - 1).
                //new approach: use while loop because apparently heap space means too much memory????
                int openidx = s.lastIndexOf('(');
                int closeidx = s.indexOf(')', openidx);
                int start = openidx - 1;
                while (start >= 0 && Character.isDigit(s.charAt(start))) {
                    start--;
                }
                start++;
                int number = Integer.parseInt(s.substring(start, openidx));
                String segment = s.substring(openidx + 1, closeidx);
                StringBuilder expanded = new StringBuilder();
                for (int j = 0; j < number; j++) {
                    expanded.append(segment);
                }
                s = s.substring(0, start) + expanded.toString() + s.substring(closeidx + 1);
            }
            System.out.println(s);
        }
    }
}