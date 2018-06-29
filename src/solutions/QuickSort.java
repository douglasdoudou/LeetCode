package solutions;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[9];
        int[] b = quickSort(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println();
        for(int i=0;i<b.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static int[] quickSort(int[] targetArray){
        int[] resultArray = targetArray.clone();
        if(resultArray.length>0) {
            quickSort(resultArray, 0 , resultArray.length-1);
        }
        return resultArray;
    }


    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }
}
