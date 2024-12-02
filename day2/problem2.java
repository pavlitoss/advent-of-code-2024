import java.util.*;
import java.io.*;

class Answer{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> input = new ArrayList<>();
        
        while(sc.hasNext()){
            List<Integer> row = new ArrayList<>();
            String scan = sc.nextLine();
            String[] split = scan.split(" ");
            for (int i = 0; i<split.length; i++){
                row.add(Integer.parseInt(split[i]));
            }
            input.add(row);
        }
        sc.close();

        int safeCounter = 0;
        List<Integer> row1 = new ArrayList<>();
        for (int i = 0; i< input.size(); i++){
            row1 = input.get(i);
            if(checkForIncreasingSafe(row1) == 1 || checkForDecreasingSafe(row1) == 1){
                safeCounter++;
            }else{
                for (int j=0; j<row1.size(); j++){
                    int buffer = row1.get(j);
                    row1.remove(j);
                    //System.out.println("removed element" + j +" "+ row1);
                    if(checkForIncreasingSafe(row1) == 1 || checkForDecreasingSafe(row1) == 1){
                        //System.out.println("Safe row: "+row1);
                        safeCounter++;
                        break;
                    }else{
                        row1.add(j, buffer);
                    }
                }
            }
        }
        System.out.println(safeCounter);
    }

    static int checkForIncreasingSafe(List<Integer> row){
        for (int i = 0; i<row.size()-1; i++){
            if((row.get(i+1) - row.get(i) != 1) && (row.get(i+1) - row.get(i) != 2) && (row.get(i+1) - row.get(i) != 3)){
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