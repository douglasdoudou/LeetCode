package solutions;

import java.math.BigDecimal;
import java.util.*;

/**
 * 美团比赛
 */
public class CountPrice {
    private static float eight(float[] count, List<Float> not_count, Boolean not_count_first){
        float result=0;
        for(int i=0;i<count.length;i++){
            if(i==0&&not_count_first)continue;
            result+=count[i]*0.8;
        }
        for(int i=0;i<not_count.size();i++){
            result += not_count.get(i);
        }
        return result;
    }

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        List<Float> manjianlist = new ArrayList<>();
        int n = in.nextInt();

        int m = in.nextInt();
        float countMoney = 0;
        Boolean flag_b = false;
        List<Float> a_count = new ArrayList<Float>();
        List<Float> a_not_count = new ArrayList<Float>();
        for(int i=0;i<n;i++) {//注意while处理多个case
            float a = in.nextFloat();
            if(in.nextInt()==1){
                a_count.add(a);
                flag_b = true;
            }else{
                a_not_count.add(a);
            }
            countMoney += a;
        }
        Boolean flag = false;
        double max = 0.2;
        float max_b = 0;
        Map<Float,Float> manjian = new HashMap<>();
        for(int i=0;i<m;i++) {//注意while处理多个case
            float b = in.nextFloat();
            float c = in.nextFloat();
            float result = c/b;
            if(flag_b){
                if(result>max&&countMoney>=b&&b>max_b){
                    flag = true;
                    max_b = b;
                }
            }else{
                if(countMoney>=b&&b>max_b){
                    flag = true;
                    max_b = b;
                }
            }
            if(manjian.containsKey(b)){
                c = Math.max(c,manjian.get(b));
            }
            manjian.put(b,c);

            manjianlist.add(b);
        }
        float[] a_count_b = new float[a_count.size()];

        for(int i=0;i<a_count.size();i++){
            a_count_b[i] = a_count.get(i);
        }
        int a_count_b_start = 0;
        int a_count_b_end = a_count_b.length-1;
        if(a_count_b.length>0) {
            quickSort(a_count_b, a_count_b_start, a_count_b_end);
        }else{
            flag_b = true;
        }

        float A = eight(a_count_b, a_not_count, false);
        float B = countMoney;
        if(flag)B=countMoney-manjian.get(max_b);
        if(flag_b)B=countMoney-manjian.get(max_b);
//
//        if(a_not_count.size()>0){
//            A = A - itertorManjian(manjian,A);
//        }
        double rr = A<B?A:B;
        System.out.printf("%.2f",rr);

    }

    public static float itertorManjian(Map<Float,Float> manjian,float countMoney){
        float max_b = 0;
        double max = 0.2;
        for(Map.Entry<Float,Float> one:manjian.entrySet()){
            float b = one.getKey();
            float c = one.getValue();
            float result = c/b;
            if(result>max&&b>=countMoney){
                max = result;
                max_b = b;
            }
        }
        return max_b==0?0:manjian.get(max_b);
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
