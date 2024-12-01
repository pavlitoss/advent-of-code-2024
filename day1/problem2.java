import java.util.*;
import java.io.*;

class Answer{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> leftlist = new ArrayList<>();
        List<Integer> rightlist = new ArrayList<>();
        while(sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            leftlist.add(n1);
            rightlist.add(n2);
        }
        sc.close();
        // for (int i = 0; i< leftlist.size(); i++){
        //     System.out.println(leftlist.get(i));
        // }
        // System.out.println("----------------------------");
        // for (int i = 0; i< rightlist.size(); i++){
        //     System.out.println(rightlist.get(i));
        // }
        HashMap<Integer, Integer> appearances = new HashMap<Integer,Integer>();
        for (int i = 0; i<leftlist.size(); i++){
            if (!appearances.containsKey(leftlist.get(i))){
                //System.out.println("Found new key: "+leftlist.get(i));
                int number = calcApps(leftlist.get(i),rightlist);
                appearances.put(leftlist.get(i), number);
            }
        }
        int res=0;
        for (int i = 0; i<leftlist.size(); i++){
            //System.out.println(appearances.get(leftlist.get(i)));
            res+= (appearances.get(leftlist.get(i)) * leftlist.get(i));
        }
        System.out.println(res);
        
    }

    static int calcApps(int a, List<Integer> b){
        int counter =0;
        for (int i = 0; i<b.size(); i++){
            if(a == b.get(i)){
                counter++;
            }
        }
        return counter;
    }
}