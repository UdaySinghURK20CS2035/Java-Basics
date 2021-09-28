package pkg1;

interface MathsOperable {
    double add();

    double sub();

    double div();

    double mul();
}
abstract class calculator {
    double num1;
    double num2;

    calculator(double x, double y) {
        this.num1 = x;
        this.num2 = y;
    }

}

public class Interface extends calculator implements MathsOperable{

    public Interface(double x, double y){
        super(x,y);
    }

    public double add() {
        return (num1+num2);
    }
    public double sub() {
        return (num1 - num2);
    }
    public double div() {
        try {
            return (num1/num2);
        }
        catch (Exception e){
            throw e;
        }

    }
    public double mul() {
        return (num1 * num2);
    }

}