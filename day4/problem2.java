import java.util.*;
import java.io.*;

class Answer{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        List<List<String>> array = new ArrayList<List<String>>();
        
        int j = 0;
        while(sc.hasNext()){
            List<String> temp = new ArrayList<String>();
            String scan = sc.nextLine();
            for (int i=0; i<scan.length(); i++){
               temp.add(String.valueOf(scan.charAt(i))); 
            }
            array.add(new ArrayList<String>(temp));
            j++;
        }

        //System.out.println(array);

        int xmasCount = 0;
        for (int i = 0; i < array.size(); i++){
            for (int k = 0; k < array.get(i).size(); k++){
                if (array.get(i).get(k).equals("A")){ 
                    xmasCount += case1(array,i,k);
                    xmasCount += case2(array,i,k);
                    xmasCount += case3(array,i,k);
                    xmasCount += case4(array,i,k);
                }
            }
        }

        System.out.println(xmasCount);

    }

    static int case1(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (y+1 <maxY && x+1<maxX && array.get(x+1).get(y+1).equals("S")){
            if(y-1 >=0 && x-1>=0 && array.get(x-1).get(y-1).equals("M")){
                if(array.get(x+1).get(y-1).equals("S")){
                    if(array.get(x-1).get(y+1).equals("M")){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    static int case2(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (y+1 <maxY && x+1<maxX && array.get(x+1).get(y+1).equals("M")){
            if(y-1 >=0 && x-1>=0 && array.get(x-1).get(y-1).equals("S")){
                if(array.get(x+1).get(y-1).equals("S")){
                    if(array.get(x-1).get(y+1).equals("M")){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    static int case3(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (y+1 <maxY && x+1<maxX && array.get(x+1).get(y+1).equals("S")){
            if(y-1 >=0 && x-1>=0 && array.get(x-1).get(y-1).equals("M")){
                if(array.get(x+1).get(y-1).equals("M")){
                    if(array.get(x-1).get(y+1).equals("S")){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    static int case4(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (y+1 <maxY && x+1<maxX && array.get(x+1).get(y+1).equals("M")){
            if(y-1 >=0 && x-1>=0 && array.get(x-1).get(y-1).equals("S")){
                if(array.get(x+1).get(y-1).equals("M")){
                    if(array.get(x-1).get(y+1).equals("S")){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}