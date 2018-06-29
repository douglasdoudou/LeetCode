package solutions;

import java.math.BigDecimal;
import java.util.*;

/**
 * 美团比赛，最多b
 */
@SuppressWarnings("Duplicates")
public class CountPricetwo {
    private static float eight(float[] count, List<Float> notCount, Boolean notCountFirst){
        float result=0;
        for(int i=0;i<count.length;i++){
            if(i==0&&notCountFirst)continue;
            result+=count[i]*0.8;
        }
        for(int i=0;i<notCount.size();i++){
            result += notCount.get(i);
        }
        return result;
    }

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        List<Float> returnList = new ArrayList<>();
        int n = in.nextInt();

        int m = in.nextInt();
        float countMoney = 0;
        Boolean flagB = true;
        List<Float> aCount = new ArrayList<Float>();
        List<Float> aNotCount = new ArrayList<Float>();
        for(int i=0;i<n;i++) {//注意while处理多个case
            float a = in.nextFloat();
            if(in.nextInt()==1){
                aCount.add(a);
                flagB = true;
            }else{
                aNotCount.add(a);
            }
            countMoney += a;
        }
        Boolean flag = false;
        double max = 0.2;
        float maxB = 0;
        Map<Float,Float> returnMap = new HashMap<>();
        for(int i=0;i<m;i++) {//注意while处理多个case
            float b = in.nextFloat();
            float c = in.nextFloat();
            float result = c/b;
            if(!flagB){
                if(result>max&&countMoney>=b&&b>maxB){
                    flag = true;
                    maxB = b;
                }
            }else{
                if(countMoney>=b&&b>maxB){
                    flag = true;
                    maxB = b;
                }
            }
            if(returnMap.containsKey(b)){
                c = Math.max(c,returnMap.get(b));
            }
            returnMap.put(b,c);

            returnList.add(b);
        }
        float[] aCountB = new float[aCount.size()];

        for(int i=0;i<aCount.size();i++){
            aCountB[i] = aCount.get(i);
        }
        int aCountBStart = 0;
        int aCountBEnd = aCountB.length-1;
        if(aCountB.length>0) {
            quickSort(aCountB, aCountBStart, aCountBEnd);
        }else{
            flagB = true;
        }

        float A = eight(aCountB, aNotCount, false);
        float B = countMoney;
        if(flag)B=countMoney-returnMap.get(maxB);
        double rr = A<B?A:B;
        System.out.printf("%.2f",rr);

    }


    public static void quickSort(float[] a,int low,int high){
        int start = low;
        int end = high;
        float key = a[low];
        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                float temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                float temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) quickSort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) quickSort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

}
