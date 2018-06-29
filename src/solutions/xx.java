package solutions;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class xx {


    public boolean solution(int n, int k){
        boolean f=false;
        Random random=new Random();
        int t=random.nextInt(n)+1;
        int[] day=new int[k];
        Scanner s=new Scanner(System.in);
        for(int i=0;i<k;i++){
            day[i]=s.nextInt();
        }
        int t1=t;
        int t2=t;
        for(int i=0;i<day.length;i++){
            if(t1==1){
                t1=t1+1;
                if(k==t1){
                    f=true;
                    break;
                }
            }
            else if(t2==n){
                t2=t2-1;
                if(k==t2){
                    f=true;
                    break;
                }
            }
            else{
                t1=t1+1;
                t2=t2-1;
                if(k==t1||k==t2){
                    f=true;
                    break;
                }

            }
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        boolean f=new xx().solution(n,k);
        System.out.println(f);

    }

}