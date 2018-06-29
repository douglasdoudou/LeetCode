package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cococola2 {
    public static void main(String[] args) {
//        int n = 100,k=4;
//        int[][] first = new int[k][n+1];
//        for(int i=0;i<k;i++){
//            for(int j=0;j<=100;j++){
//                first[i][j]=j;
//            }
//        }
//        for(int a=0;a<n;a++){
//            for(int i=0;i<first.length;i++){
//                for(int j=0;j<first[0].length;j++){
//                    System.out.print(first[i][j]+" ");
//                }
//                System.out.println();
//            }
//        }
        List<int[]> results = new ArrayList<>();
//        int max = 4;
//        int[] a = {max,0,0,0};
//        int index = 0;
//        int[][] result = new int[max][a.length];
//        for(int row=0;row<max;row++){
//            for(int column=0;column<a.length;column++){
//                result[row][column] = 0;
//            }
//        }
//        results.add(a);
//        for(int i=0;i<max;i++){
//            int[] aCopy = new int[a.length];
//            for(int j=0;j<a.length;j++){
//                result[]
//            }
//        }
        int[][] a_result = cut(new int[]{10,0,0,0,0,0,0,0,0},0, results);
        for(int[] aaa:results){
            print(aaa);
        }
    }

    /**
     * index从0开始
     * @param a
     * @param index
     */
    private static int[][] cut(int[] a,int index, List<int[]> results){
//        System.out.println("要分割的一维数组：");
//        print(a);
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
//        System.out.println("结果：");
//        print(result);
        return result;

    }
    private static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private  static void print(int[][] a){
        System.out.println("=============二维数组============");
        for(int[] aa:a){
            print(aa);
        }
        System.out.println("=============二维数组============");
    }
}
