package solutions;

import java.util.*;

public class Movie {
    static Map<Character, int[]> charMap = generateChar();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<char[]> movieList = new ArrayList<>();
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            String one = in.next();
            one = one.toLowerCase();
            char[] string = new char[one.length()+1];
            string[0]="-".charAt(0);
            for(int j=1;j<string.length;j++){
                string[j]=one.charAt(j-1);
//                System.out.println(string[j]);
            }
            movieList.add(string);
        }

        countBuShu(movieList);
//        for(Map.Entry<Character,int[]> one:charMap.entrySet()){
//            System.out.println(one.getKey());
//            System.out.println(one.getValue()[0]+" "+one.getValue()[1]);
//        }
    }

    private static Map<Character, int[]> generateChar() {
        Map<Character, int[]> charMap = new HashMap<>();
        int row = 0;
        int column = 1;
        for(char a='a';a<='z';a++){
            if(a=='d'||a=='j'||a=='m'||a=='t'||a=='w')column+=1;
            if(a=='g'||a=='p'){
                row+=1;
                column = 0;
            }
            charMap.put(a,new int[]{row,column});
        }
        charMap.put("-".charAt(0),new int[]{0,0});
        return charMap;
    }

    private static void countBuShu(List<char[]> movieList) {
        for(char[] oneMovie:movieList){
            int start = 0;
            int result = 0;
            while(start<oneMovie.length-1){
                result+=countbbb(oneMovie[start++],oneMovie[start]);
            }
            System.out.println(String.valueOf(result));
        }
    }
    private static int countbbb(char a,char b){
        int[] aint= new int[]{0,0};
        int[] bint=charMap.get(b);
        if(a!='-'){
            aint = charMap.get(a);
        }
        return Math.abs(aint[0]-bint[0])+Math.abs(aint[1]-bint[1]);
    }
}
