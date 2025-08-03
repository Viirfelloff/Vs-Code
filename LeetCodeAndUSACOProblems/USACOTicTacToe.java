package LeetCodeAndUSACOProblems;

import java.util.*;

//Are we cooking?
public class USACOTicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> board = new ArrayList<>();
        for (int i=0;i<3;i++) {
            board.add(sc.next());
        }
        //Check Rows, Columns, and Diagonals for Single Pair Match or Doubles
        int onePlayerWins = 0;
        int twoPlayerWins = 0;
        for (String x : board) {
            if (x.charAt(0) == x.charAt(1) && x.charAt(1) == x.charAt(2)) {
                onePlayerWins++;
            } else {
                Set<Character> set1 = new HashSet<>();
                set1.add(x.charAt(0));
                set1.add(x.charAt(1));
                set1.add(x.charAt(2));
                if (set1.size() == 2) {
                    twoPlayerWins++;
                }
            }
        }
        for (int k = 0; k < board.size(); k++) {
            if (board.get(0).charAt(k) == board.get(1).charAt(k) && board.get(1).charAt(k) == board.get(2).charAt(k)) {
                onePlayerWins++;
            } else {
                Set<Character> set2 = new HashSet<>();
                set2.add(board.get(0).charAt(k));
                set2.add(board.get(1).charAt(k));
                set2.add(board.get(2).charAt(k));
                if (set2.size() == 2) twoPlayerWins++;
            }
        }
        if (board.get(0).charAt(0) == board.get(1).charAt(1) && board.get(1).charAt(1) == board.get(2).charAt(2)) {
            onePlayerWins++;
        } else {
            Set<Character> diag1 = new HashSet<>();
            diag1.add(board.get(0).charAt(0));
            diag1.add(board.get(1).charAt(1));
            diag1.add(board.get(2).charAt(2));
            if (diag1.size() == 2) twoPlayerWins++;
        }

        if (board.get(0).charAt(2) == board.get(1).charAt(1) && board.get(1).charAt(1) == board.get(2).charAt(0)) {
            onePlayerWins++;
        } else {
            Set<Character> diag2 = new HashSet<>();
            diag2.add(board.get(0).charAt(2));
            diag2.add(board.get(1).charAt(1));
            diag2.add(board.get(2).charAt(0));
            if (diag2.size() == 2) twoPlayerWins++;
        }
        System.out.println(onePlayerWins);
        System.out.println(twoPlayerWins);
    }
}
