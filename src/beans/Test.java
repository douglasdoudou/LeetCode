package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static List<int[]> twoSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result.add(new int[]{i,j}) ;
                }
            }
        }
        return result;
    }

    public static List<int[]> twoSum2(int[] nums, int target){
        List<int[]> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result.add(new int[]{map.get(nums[i]),i});
            }else{
                map.put(target - nums[i],i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {2,7,3,5,6,8};
        List<int[]> result = twoSum2(a,9);
        for(int[] aa:result){
            System.out.println(aa[0]+","+aa[1]);
        }
    }
}
