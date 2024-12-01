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

        leftlist.sort(null);
        rightlist.sort(null);
        int result = 0;
        for (int i = 0; i < leftlist.size(); i++) {
            int left = leftlist.get(i);
            int right = rightlist.get(i);
            int dist;
            if(left <= right){
                dist = right - left;
            }else{
                dist = left - right;
            }
            result += dist;
        }
        System.out.println(result);
    }
}