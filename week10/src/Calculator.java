import java.util.Scanner;

abstract class Calc{
    protected int a;
    protected int b;

    public void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }

    abstract int calculate();
}

class Add extends Calc{
    int calculate(){
        return a + b;
    }
}

class Sub extends Calc{
    int calculate(){
        return a - b;
    }
}

class Mul extends Calc{
    int calculate(){
        return a * b;
    }
}

class Div extends Calc{
    int calculate(){
        if(b==0){
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        }
        return a / b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = null;

        while(true){
            System.out.print("두 정수와 연산자를 입력하게요 >> ");
            try{
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                String operater = scanner.next();

                switch (operater){
                    case "+":
                        calc = new Add();
                        break;

                    case "-":
                        calc = new Sub();
                        break;

                    case "*":
                        calc = new Mul();
                        break;

                    case "/":
                        calc = new Div();
                        break;

                    default:
                        continue;
                }
                calc.setValue(a, b);
                System.out.println(calc.calculate());
                break;
            } catch(Exception e) {
                System.out.println("피연산자 피연산자 연산자(10 10 +) 순서로 입력하세요.");
                System.out.println("잘못된 연산자입니다.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
