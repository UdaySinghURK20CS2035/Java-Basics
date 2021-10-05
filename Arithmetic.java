/* AIM:
Create a java application that uses multi-threading concept to perform the following.
1. Getting inputs from user by using the thread name called“t1”.
2. Perform addition operation using the thread name called “t2”
3. Perform division operation using the thread name called “t3”
*/
import java.util.Scanner;

class user_input extends Thread{
    int a;
    int b;

    public void run(){
        System.out.println("Running T1 thread");
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number1: ");
         a = s1.nextInt();
        System.out.println("Enter the number2: ");
         b = s1.nextInt();
        try {
            Thread t2 = new Thread(new addition(a,b));
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread t3 = new Thread(new division(a,b));
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
class addition extends Thread{
    int a;
    int b;
    addition(int x, int y){
        this.a = x;
        this.b = y;
    }
    public void run(){
        System.out.println("Thread T2 running");
        System.out.println("Result of Addition is: "+(a+b));
    }
}

class division extends Thread{
    int a;
    int b;
    division(int x, int y){
        this.a = x;
        this.b = y;
    }
    public void run(){
        System.out.println("Thread T3 running");
        System.out.println("Result of Division is: "+(a/b));
    }
}
public class Arithmetic {
    public static void main(String[] args){
        Thread t1 =new Thread(new user_input());
        t1.start();

    }
}
