package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDivisorNum {
    private List<Float> findDivisors(List<Float> divisors, long number){
        for(int i=1;i<=number;i++){
            if(number%i==0){
                divisors.add(Float.parseFloat((i+"").charAt(0)+""));
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        List<Float> divisors = new ArrayList<>();
        FindDivisorNum findDivisorNum = new FindDivisorNum();
        for(long number=l;number<=r;number++){
            findDivisorNum.findDivisors(divisors,number);
        }
        for(int j=1;j<=9;j++){
            int number = 0;
            for(Float one:divisors){
                if(one==j)number++;
            }
            System.out.println(number);
        }
    }
}
