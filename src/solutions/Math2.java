package solutions;

import java.util.Scanner;

public class Math2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int i=0;i<n;i++){
            score[i] = in.nextInt();
        }
//        for(int j=0;j<n;j++){
//            System.out.println(score[j]);
//        }
        for(int mm=1;mm<=score.length;mm++){
            int[] result = new int[mm];
            hand(mm,score,100,result);
            System.out.println(result.length);
            for(int j=0;j<result.length;j++){
                System.out.println(result[j]);
            }
            System.out.println("===============");
        }
    }

    private static int[] hand(int num, int[] score, int total, int[] resultArray){
//        double l = (total+0.0)/num;
//
//        for(int i=0;i<score.length;i++){
//            if(score[i]>=l){
//                return score[i]
//            }
//        }
        if(num==1){
            for(int i=0;i<score.length;i++){
                if(score[i]==total){
                    resultArray[0]=score[i];
                    return resultArray;
                }
            }
        }
        double l = (total+0.0)/num;
        int index = 0;
        int max = 0;
        int[] a = new int[score.length];
        for(int i=0;i<score.length;i++){

            if(score[i]>=l){
                resultArray[num-1] = Math.max(score[i],resultArray[num-1]);
                index = i;
            }
        }
        int remain = total - score[num-1];
        score[index]=0;
        return hand(num-1,score,remain,resultArray);

    }
}
