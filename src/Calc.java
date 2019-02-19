import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    private double a;
    private double b;
    private double sum;

    public void printCalc () {
        char c;
         do {
             Scanner num = new Scanner(System.in);
             System.out.println("Введите 1-е число");
             try {a = num.nextInt();
             }catch (InputMismatchException e){System.out.println("Вы ввели символ, введите число"); }
             finally { System.out.println(num.nextLine()); a = num.nextInt();}
             System.out.println("Введите 2-е число");
             b = num.nextInt();
             System.out.println("Выберите арифметическое действие:");
             this.action();
             System.out.println("Введите любой символ, чтобы продолжить, 'e' чтобы выйти");
             c=num.next().charAt(0);
         } while (c!='e');
    }

    public double sum (double a, double b){
        return a+b;
    }
    public double ded  (double a, double b){
        return a-b;
    }
    public double mult (double a, double b){
        return a*b;
    }
    public double div (double a, double b){
        return a/b;
    }

    private void action (){
        Scanner act = new Scanner(System.in);
        char y = act.nextLine().charAt(0);
        char [] action = {'+','-','*','/'};
        if (y == action[0]){
            System.out.println(this.sum(a,b));
        }
        if (y == action[1]){
            System.out.println(this.ded(a,b));
        }
        if (y == action[2]){
            System.out.println(this.mult(a,b));
        }
        if (y == action[3]){
            System.out.println(this.div(a,b));
        }
    }
}
