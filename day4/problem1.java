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
                if (array.get(i).get(k).equals("X")){
                    //System.out.println("X found at: " + i + " " + k); 
                    xmasCount += checkRight(array,i,k);
                    xmasCount += checkLeft(array,i,k);
                    xmasCount += checkUp(array,i,k);
                    xmasCount += checkDown(array,i,k);
                    xmasCount += checkDownRight(array,i,k);
                    xmasCount += checkUpRight(array,i,k);
                    xmasCount += checkUpLeft(array,i,k);
                    xmasCount += checkDownLeft(array,i,k);
                }
            }
        }

        System.out.println(xmasCount);

    }

    static int checkRight(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (y+1 <maxY && array.get(x).get(y+1).equals("M")){
            if(y+2 <maxY && array.get(x).get(y+2).equals("A")){
                if(y+3 <maxY && array.get(x).get(y+3).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkLeft(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (y-1 >= 0 && array.get(x).get(y-1).equals("M")){
            if(y-2 >= 0 && array.get(x).get(y-2).equals("A")){
                if(y-3 >= 0 && array.get(x).get(y-3).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkUp(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (x-1 >=0 && array.get(x-1).get(y) != null && array.get(x-1).get(y).equals("M")){
            if(x-2>=0 && array.get(x-2).get(y) != null && array.get(x-2).get(y).equals("A")){
                if(x-3>=0 && array.get(x-3).get(y) != null && array.get(x-3).get(y).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkDown(List<List<String>> array,int x,int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if (x+1<maxX && array.get(x+1).get(y) != null && array.get(x+1).get(y).equals("M")){
            if(x+2<maxX && array.get(x+2).get(y) != null && array.get(x+2).get(y).equals("A")){
                if(x+3<maxX && array.get(x+3).get(y) != null && array.get(x+3).get(y).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkDownRight(List<List<String>> array, int x, int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if(x+1<maxX && y+1<maxY && array.get(x+1).get(y+1).equals("M")){
            if(x+2<maxX && y+2<maxY && array.get(x+2).get(y+2).equals("A")){
                if(x+3<maxX && y+3<maxY && array.get(x+3).get(y+3).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkUpRight(List<List<String>> array, int x, int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if(x-1>=0 && y+1<maxY && array.get(x-1).get(y+1).equals("M")){
            if(x-2>=0 && y+2<maxY && array.get(x-2).get(y+2).equals("A")){
                if(x-3>=0 && y+3<maxY && array.get(x-3).get(y+3).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkUpLeft(List<List<String>> array, int x, int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if(x-1>=0 && y-1>=0 && array.get(x-1).get(y-1).equals("M")){
            if(x-2>=0 && y-2>=0 && array.get(x-2).get(y-2).equals("A")){
                if(x-3>=0 && y-3>=0 && array.get(x-3).get(y-3).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }

    static int checkDownLeft(List<List<String>> array, int x, int y){
        int maxX = array.size();
        int maxY = array.get(0).size();
        if(x+1<maxX && y-1>=0 && array.get(x+1).get(y-1).equals("M")){
            if(x+2<maxX && y-2>=0 && array.get(x+2).get(y-2).equals("A")){
                if(x+3<maxX && y-3>=0 && array.get(x+3).get(y-3).equals("S")){
                    return 1;
                }
            }
        }
        return 0;
    }
}