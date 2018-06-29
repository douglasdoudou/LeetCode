package solutions;

/**
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维
 * 数组和一个整数，判断数组中是否含有
 * 该整数
 */
public class Find2DArray {
    public boolean Find(int target, int[][] array){
        int column = 0, row = array.length-1;
        boolean result = false;
        while(column<array[0].length&&row>=0){
            if(array[row][column]>target){
                row--;
                continue;
            }else if(array[row][column]<target){
                column++;
                continue;
            }else{
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Find2DArray find = new Find2DArray();
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println("result:"+find.Find(5,array));
    }
}
