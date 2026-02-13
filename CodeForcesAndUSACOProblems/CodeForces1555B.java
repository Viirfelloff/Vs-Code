import java.util.Scanner;
public class CodeForces1555B {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[] bottomleft = new int[]{sc.nextInt(), sc.nextInt()};
            int[] topright = new int[]{sc.nextInt(), sc.nextInt()};
            int widthinsert = sc.nextInt();
            int heighinsert = sc.nextInt();
            //check if possible to make room x or make room y
            int leftx = bottomleft[0];
            int rightx = w - topright[0];
            int x = Math.max(leftx, rightx);
            int lowery = bottomleft[1];
            int uppery = h - topright[1];
            int y = Math.max(lowery, uppery);
            if (widthinsert <= x || heighinsert <= y) System.out.println(0);
            else {
                //take min of ycost and xcost
                int ycost = heighinsert - y;
                int xcost = widthinsert - x;
                boolean xvalid = (bottomleft[0] - xcost >= 0 && bottomleft[0] + xcost <= w) && (topright[0] - xcost >= 0 && topright[0] + xcost <= w);
                boolean yvalid = (bottomleft[1] - ycost >= 0 && bottomleft[1] + ycost <= h) && (topright[1] - ycost >= 0 && topright[1] + ycost <= h);
                if (xvalid && yvalid) System.out.println(Math.min(ycost, xcost));
                else if (!yvalid && xvalid) System.out.println(xcost);
                else if (!xvalid && yvalid) System.out.println(ycost);
                else System.out.println(-1);
            }
        }
    }
}
