import java.util.*;
import java.io.*;

class Answer{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> input = new ArrayList<>();
        
        while(sc.hasNext()){
            List<Integer> row = new ArrayList<>();
            String scan = sc.nextLine();
            //System.out.println(scan);
            String[] split = scan.split(" ");
            //System.out.println(split.length);
            for (int i = 0; i<split.length; i++){
                row.add(Integer.parseInt(split[i]));
            }
            //System.out.println(row);
            input.add(row);
        }
        sc.close();
        //System.out.println("Size: "+input.size());

        // for(int i = 0; i<input.size(); i++){
        //     for (int j = 0; j<input.get(i).size(); j++){
        //         System.out.print(input.get(i).get(j)+" ");
        //     }
        //     System.out.println("-----------------");
        // }

        int safeCounter = 0;
        //System.out.println("Size: "+input.size());
        List<Integer> row1 = new ArrayList<>();
        for (int i = 0; i< input.size(); i++){
            //System.out.println("Row: "+i + " "+input.get(i));
            row1 = input.get(i);
            safeCounter += checkForIncreasingSafe(row1);
            safeCounter += checkForDecreasingSafe(row1);
            //System.out.println("Safe counter: "+safeCounter);
        }
        System.out.println(safeCounter);
    }

    static int checkForIncreasingSafe(List<Integer> row){
        for (int i = 0; i<row.size()-1; i++){
            if((row.get(i+1) - row.get(i) != 1) && (row.get(i+1) - row.get(i) != 2) && (row.get(i+1) - row.get(i) != 3)){
                //System.out.println("Not safe: "+row.get(i)+" "+row.get(i+1));
                return 0;
            }
        }
        return 1;
    }

    static int checkForDecreasingSafe(List<Integer> row){
        for (int i = 0; i<row.size()-1; i++){
            if((row.get(i) - row.get(i+1) != 1) && (row.get(i) - row.get(i+1) != 2) && (row.get(i) - row.get(i+1) != 3)){
                return 0;
            }
        }
        return 1;
    }
}