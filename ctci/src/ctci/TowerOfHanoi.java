package ctci;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        M a = new M("A");
        M b = new M("B");
        M c = new M("C");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i>0){
            move(a,b,c,i);
        }
    }
    
    private static void move(M a,M b, M c,int i){
        if(i>0){
            move(a,c,b,i-1); 
            System.out.println("Moving ring "+i+" from "+a.name+" to "+c.name);
            move(b,a,c,i-1);
        }
    }

}

class M extends Stack{
    String name;
    
    M(String name){
        this.name = name;
    }
}