// import java.util.*;
// import java.io.*;
// import java.util.regex.Pattern;
// import java.util.regex.Matcher;

// class Answer{
//     public static void main(String [] args){
//         Scanner sc = new Scanner(System.in);
//         List<String> input = new ArrayList<>();
//         while(sc.hasNext()){
//             String scan = sc.nextLine();
//             input.add(scan);
//         }
//         sc.close();
//         String newString = String.join(" ",input);
//         boolean doCommand = true;
//         int cumulative = 0;
//         int a ,b;
//         Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
//         Pattern pattern2 = Pattern.compile("do\\(\\)");
//         Pattern pattern3 = Pattern.compile("don't\\(\\)");
//         while(!pattern3.matcher(newString).find() && !pattern2.matcher(newString).find() && !pattern.matcher(newString).find()){
//             Matcher matcher = pattern.matcher(newString);
//             Matcher matcher2 = pattern2.matcher(newString);
//             Matcher matcher3 = pattern3.matcher(newString);
//             if(matcher.find() || matcher2.find() || matcher3.find()){
//                 int starts[] = new int[3];
//                 if(matcher.find()){
//                     starts[0] = matcher.start();
//                 }else{
//                     starts[0] = Integer.MAX_VALUE;
//                 }
//                 if(matcher2.find()){
//                     starts[1] = matcher2.start();
//                 }else{
//                     starts[1] = Integer.MAX_VALUE;
//                 }
//                 if(matcher3.find()){
//                     starts[2] = matcher3.start();
//                 }else{
//                     starts[2] = Integer.MAX_VALUE;
//                 }
//                 Arrays.sort(starts);
//                 if(matcher.find() && starts[0] == matcher.start() && doCommand){
//                     int start = matcher.start();
//                     int end = matcher.end();
//                     String temp = newString.substring(start+4, end-1);
//                     String [] tempArr = temp.split(",");
//                     a = Integer.parseInt(tempArr[0]);
//                     b = Integer.parseInt(tempArr[1]);
//                     cumulative += a*b;
//                     newString =  newString.substring(end);
//                 }
//                 if(matcher2.find() && starts[0] == matcher2.start()){
//                     int end = matcher2.end();
//                     String temp = newString.substring(start+4, end-1);
//                     newString =  newString.substring(end);
//                     cumulative += Integer.parseInt(temp);
//                     doCommand = true;
//                 }
//                 if(matcher3.find() && starts[0] == matcher3.start()){
//                     int end = matcher3.end();
//                     newString =  newString.substring(end);
//                     doCommand = false;
//                 }
//             }
//         }
//         System.out.println(cumulative);
//     }
// }


import java.util.*;
import java.util.regex.*;

class Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            String scan = sc.nextLine();
            input.add(scan);
        }
        sc.close();

        String newString = String.join(" ", input);
        boolean doCommand = true;
        int cumulative = 0;
        int a, b;

        Pattern patternMul = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Pattern patternDo = Pattern.compile("do\\(\\)");
        Pattern patternDont = Pattern.compile("don't\\(\\)");

        while (true) {
            // Match each pattern once
            Matcher matcherMul = patternMul.matcher(newString);
            Matcher matcherDo = patternDo.matcher(newString);
            Matcher matcherDont = patternDont.matcher(newString);

            // Find the next match for each pattern
            boolean hasMul = matcherMul.find();
            boolean hasDo = matcherDo.find();
            boolean hasDont = matcherDont.find();

            // Determine the earliest match
            int mulStart = hasMul ? matcherMul.start() : Integer.MAX_VALUE;
            int doStart = hasDo ? matcherDo.start() : Integer.MAX_VALUE;
            int dontStart = hasDont ? matcherDont.start() : Integer.MAX_VALUE;

            // If no matches are found, exit the loop
            if (mulStart == Integer.MAX_VALUE && doStart == Integer.MAX_VALUE && dontStart == Integer.MAX_VALUE) {
                break;
            }

            // Process the earliest match
            if (mulStart <= doStart && mulStart <= dontStart) {
                // Process "mul(x,y)" if doCommand is true
                if (doCommand) {
                    int end = matcherMul.end();
                    String temp = newString.substring(mulStart + 4, end - 1);
                    String[] tempArr = temp.split(",");
                    a = Integer.parseInt(tempArr[0]);
                    b = Integer.parseInt(tempArr[1]);
                    cumulative += a * b;
                }
                // Update string to exclude processed part
                newString = newString.substring(matcherMul.end());
            } else if (doStart <= dontStart) {
                // Process "do()"
                doCommand = true;
                newString = newString.substring(matcherDo.end());
            } else {
                // Process "don't()"
                doCommand = false;
                newString = newString.substring(matcherDont.end());
            }
        }

        System.out.println(cumulative);
    }
}
