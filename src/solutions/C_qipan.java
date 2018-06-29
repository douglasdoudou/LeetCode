package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C_qipan {
    private static int[] subResult;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean result = true;
        List<char[]> movieList = new ArrayList<>();
        int n = in.nextInt();
        int addResult = 0;
        int[] alist = new int[n];
        int[] blist = new int[n];
        subResult = new int[n];
        for(int i=0;i<n;i++){
            alist[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            blist[i] = in.nextInt();
            subResult[i] = blist[i]-alist[i];
            addResult += subResult[i];
            if(alist[i]==blist[i]){
                result &=true;
            }else{
                result &=false;
            }
        }
        if(addResult!=0){
            System.out.println(0);
        }
        if(result){
            System.out.println(0);
        }else{
            int finalResult = 0;
            int index = 0;
            while(true){
                for(int j=1;j<subResult.length-index;j++){
                    if(subResult[index]*subResult[index+j]<0&&(index==subResult.length-2||(Math.abs(subResult[index])<Math.abs(subResult[index+j])))){
                        finalResult += indexCount(index,index+j,subResult.length);
                    }
                    if(subResult[index]==0){
                        index += 1;
                        break;
                    }
                }
                if(subResult[subResult.length-1]==0){
                    break;
                }
            }

            System.out.println(finalResult);
        }
    }
    private static int indexCount(int indexOp, int indexSub, int length){
        int abs = Math.min(Math.abs(subResult[indexOp]),Math.abs(subResult[indexSub]));
        if(subResult[indexSub]<subResult[indexOp]){
            sub(indexOp, indexSub,abs);
            return (indexSub-indexOp)*abs;
        }else{
            sub(indexOp, indexSub,abs);
            return (indexSub+indexOp)*abs;
        }
    }
    private static void sub(int indexOp, int indexSub,int abs){
        if(subResult[indexOp]>0){
            subResult[indexOp]-=abs;
            subResult[indexSub]+=abs;
        }else{
            subResult[indexOp]+=abs;
            subResult[indexSub]-=abs;
        }
    }
}
