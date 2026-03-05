import java.io.*;
import java.util.*;
public class USACOGuideCSESSumOfThreeValues{
    static class Pair{
        long value;
        int index;
        Pair(long v,int i){value=v;index=i;}
    }
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]in=br.readLine().split(" ");
        int n=Integer.parseInt(in[0]);
        long x=Long.parseLong(in[1]);
        String[]vals=br.readLine().split(" ");
        List<Pair>list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new Pair(Long.parseLong(vals[i]),i));
        list.sort(Comparator.comparingLong(a->a.value));
        for(int i=0;i<n;i++){
            long target=x-list.get(i).value;
            int l=i+1,r=n-1;
            while(l<r){
                long sum=list.get(l).value+list.get(r).value;
                if(sum<target)l++;
                else if(sum>target)r--;
                else{
                    System.out.println((list.get(i).index+1)+" "+(list.get(l).index+1)+" "+(list.get(r).index+1));
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}