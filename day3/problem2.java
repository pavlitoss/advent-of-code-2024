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
