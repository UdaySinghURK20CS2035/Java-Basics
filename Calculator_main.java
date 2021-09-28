import pkg1.Interface;


import java.util.Scanner;

class addition_thread extends Thread {
    double a;
    double b;

    addition_thread(double x, double y) {
        this.a = x;
        this.b = y;
    }
    public synchronized void run() {
        Interface intr = new Interface(a, b);
        System.out.println("The result is: "+intr.add());
    }
}

class subtraction_thread extends Thread {
    double a;
    double b;

    subtraction_thread(double x, double y) {
        this.a = x;
        this.b = y;
    }

    public synchronized void run() {
        Interface intr = new Interface(a, b);
        System.out.println("The result is: "+intr.sub());
    }
}

class Multiplication_thread extends Thread {
        double a;
        double b;

        Multiplication_thread(double x, double y) {
            a = x;
            b = y;
        }

        public synchronized void run() {
            Interface intr = new Interface(a, b);
            System.out.println("The result is: "+intr.mul());
        }
    }
class Division_thread extends Thread {
        double a;
        double b;

        Division_thread(double x, double y) {
            a = x;
            b = y;
        }

        public synchronized void run() {
            Interface intr = new Interface(a, b);
            System.out.println("The result is: "+intr.div());
        }
}

enum calculate{
    add,
    subtract,
    multiply,
    divide,
}


public class Calculator_main {
    static calculate s4;
    Calculator_main(calculate s){
        s4 = s;
    }

    public static void main(String[] args) throws Exception {
        Scanner s1 = new Scanner(System.in);
        while (true) {
            System.out.println("1.For Arithmetic operations");
            System.out.println("2.Exit");
            System.out.println("Enter you choice:");
            int choice = s1.nextInt();
            if (choice == 1) {
                System.out.println("Enter any two numbers: ");
                double a = s1.nextDouble();
                double b = s1.nextDouble();
                System.out.println("What do you want to perform?");
                System.out.println("add, subtract, multiply, divide");
                System.out.println("Enter your choice");
                String ch = s1.next();
                Calculator_main cal = new Calculator_main(calculate.valueOf(ch));
                switch (s4) {
                    case add -> {
                        Thread add_thread = new Thread(new addition_thread(a, b));
                        add_thread.start();
                        add_thread.join();
                    }
                    case subtract -> {
                        Thread sub_thread = new Thread(new subtraction_thread(a, b));
                        sub_thread.start();
                        sub_thread.join();
                    }
                    case multiply -> {
                        Thread mult_thread = new Thread(new Multiplication_thread(a, b));
                        mult_thread.start();
                        mult_thread.join();
                    }
                    case divide -> {
                        Thread div_thread = new Thread(new Division_thread(a, b));
                        div_thread.start();
                        div_thread.join();
                    }
                }
            }
             else if (choice == 2) {
                System.out.println("Terminating Program...");
                System.out.println("Program Terminated!...");
                break;
            } else {
                System.out.println("Wrong choice !");
            }
        }
    }
}
