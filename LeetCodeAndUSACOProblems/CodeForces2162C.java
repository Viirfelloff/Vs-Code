import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//u failed. ur never getting in to silver, or passing bronze. give up.
public class CodeForces2162C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (a == b) {
                System.out.println(0);
                continue;
            }

            String aa = Long.toBinaryString(a);
            String bb = Long.toBinaryString(b);

            if (aa.length() < bb.length()) {
                System.out.println(-1);
            } else {
                StringBuilder needToXOR = new StringBuilder();
                for (int k = 0; k < aa.length() - bb.length(); k++) {
                    needToXOR.append(aa.charAt(k) == '1' ? '1' : '0');
                }

                StringBuilder sb = new StringBuilder();
                sb.append(aa);
                sb.delete(0, aa.length() - bb.length());
                String newaa = sb.toString();

                for (int j = 0; j < bb.length(); j++) {
                    if (newaa.charAt(j) == '1' && bb.charAt(j) == '1') {
                        needToXOR.append('0');
                    } else if (newaa.charAt(j) == '1' && bb.charAt(j) == '0') {
                        needToXOR.append('1');
                    } else if (newaa.charAt(j) == '0' && bb.charAt(j) == '1') {
                        needToXOR.append('1');
                    } else {
                        needToXOR.append('0');
                    }
                }

                int n = needToXOR.length();
                long currentNumber = 0;
                List<Long> list = new ArrayList<>();

                for (int l = 0; l < n; l++) {
                    if (needToXOR.charAt(l) == '1') {
                        int exp = n - 1 - l;
                        long val = 1L << exp;

                        if (currentNumber == 0 && val > a) {
                            list.clear();
                            break;
                        }

                        if (currentNumber + val > a) {
                            if (currentNumber > 0) list.add(currentNumber);
                            currentNumber = val;
                        } else {
                            currentNumber += val;
                        }
                    }
                }

                if (currentNumber > 0) list.add(currentNumber);

                if (list.isEmpty()) {
                    System.out.println(-1);
                } else {
                    if (list.size() > 100) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.size());
                        for (int idx = 0; idx < list.size(); idx++) {
                            if (idx > 0) System.out.print(" ");
                            System.out.print(list.get(idx));
                        }
                        System.out.println();
                    }
                }
            }
        }
        sc.close();
    }
}
