package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Cococola {
    private static double pleasure(double m, double n, int[][] mean, int[] k){
        double result = 0;
        for(int i=0;i<k.length;i++){
            int meiMean = mean[i][0];
            int tuanMean = mean[i][1];
            double meiPleasure = k[i]*m/n*meiMean;
            double tuanPleasure = k[i]*(n-m)/n*tuanMean;
            result += meiPleasure+tuanPleasure;
        }
        return result;
    }

//    private static double mean()
    public static void main(String[] args) {
//        double[][] mean = new double[][]{{1,4},{2,3},{3,2}};
//        double a = pleasure(4,10,mean,new double[]{3,4,3});
//        System.out.println(a);
        List<double[]> means = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] mean = new int[k][2];
        for(int i=0;i<k;i++){
            mean[i][0] = in.nextInt();
            mean[i][1] = in.nextInt();
        }
        List<int[]> results = new ArrayList<>();
        int[] first = new int[k];
        first[0]=k;
        for(int i=1;i<k;i++){
            first[i] = 0;
        }
        results.add(first);
        cut(first,0, results);
        double result = 0;
        int[] finalResult = new int[k];
        List<int[]> resultList = new ArrayList<>();
        Boolean flag =false;
        for(int[] a:results){
           double temp = pleasure(m,n,mean,a);
           if(temp>result){
               result = temp;
               finalResult = a;
           }
           if(temp==result){
               flag = true;
               resultList.add(a);
           }
        }
//        if(flag){
//            resultList.add(finalResult);
//            finalResult = sort(resultList);
//        }
        print(finalResult);
    }

    private static int[] sort(List<int[]> resultList) {
        int index = 0;
        int[] m = new int[resultList.size()];
        for(int i=0;i<resultList.get(0).length;i++){
            for(int j=0;j<resultList.size();j++){
                m[j] = resultList.get(i)[j];
            }
            index = sortList(m);
            if(index == -1){
                continue;
            }else break;
        }
        return resultList.get(index);
    }

    private static int sortList(int[] m) {
        if(m.length==0){
            return -1;
        }
        int a = m[0];
        int index = 0;
        for(int i=1;i<m.length;i++){
            if(m[i]<a)index=i;
        }
        return index;
    }

    private static void print(int[] a){
        for(int i=0;i<a.length;i++){
            if(i==a.length-1){
                System.out.print(a[i]);
            }else{
                System.out.print(a[i]+" ");
            }
        }
    }
    /**
     * index从0开始
     * @param a
     * @param index
     */
    private static int[][] cut(int[] a,int index, List<int[]> results){
        int[][] result = new int[a[index]][a.length];
        for(int row=0;row<a[index];row++){
            for(int column=0;column<a.length;column++){
                result[row][column] = a[column];
            }
        }
        for(int i=1;i<=a[index];i++){
            result[i-1][index] = a[index]-i;
            result[i-1][index+1] = i;
        }
        for(int[] aa:result){
            results.add(aa);
            if(index<a.length-2){
                cut(aa,index+1,results);
            }
        }
        return result;

    }
}
