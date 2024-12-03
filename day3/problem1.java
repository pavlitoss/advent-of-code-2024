import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Answer{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while(sc.hasNext()){
            String scan = sc.nextLine();
            input.add(scan);
        }
        sc.close();

        int cumulative = 0;
        int a ,b;
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        int i =0;
        while(i< input.size()){
            //System.out.println("i: "+ i+ " size: "+ input.size());
            Matcher matcher = pattern.matcher(input.get(i));
            if(matcher.find()){
                //System.out.println("found at "+ i);
                int start = matcher.start();
                int end = matcher.end();
                String temp = input.get(i).substring(start+4, end-1);
                String [] tempArr = temp.split(",");
                a = Integer.parseInt(tempArr[0]);
                b = Integer.parseInt(tempArr[1]);
                cumulative += a*b;
                String substring =  input.get(i).substring(end);
                //System.out.println("substring: "+ substring);
                input.add(substring);
                //System.out.println("start: "+ start + " end: "+ end);
            }
            i++;

        }
        System.out.println(cumulative);
    }
}