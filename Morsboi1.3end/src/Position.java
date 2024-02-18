import java.util.Scanner;
import java.util.InputMismatchException;


public class Position {

    public static int givepos(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int pos;
            try {
                System.out.println("Введите столбец, в который хотите поставить начало корабля ");
                pos = sc.nextInt();
                if (pos > 16 || pos < 1) {
                    System.out.println("Вы ввели некорректное значение для столбца. Попробуйте ещё раз.");
                    continue;
                }
                return pos;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: вы ввели не число. Попробуйте ещё раз.");
                sc.next();
                System.out.println();
            }
        }
    }
    public static int givedirection(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int pos;
            try {
                System.out.println("Выберите направление корабля: (1 - горизонтальное, 2 - вертикальное) ");
                pos = sc.nextInt();
                if (pos == 1 || pos == 2) {

                    return pos;
                }
                else{
                    System.out.println("Вы ввели некорректное значение для направления корабля. Попробуйте ещё раз.");
                    continue;

                }

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: вы ввели не число. Попробуйте ещё раз.");
                sc.next();
                System.out.println();
            }
        }

    }
    public static int giveposshoat(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int pos;
            try {
                System.out.println("Введите столбец в который будете стрелять:");
                pos = sc.nextInt();
                if (pos > 16 || pos < 1) {
                    System.out.println("Вы ввели некорректное значение для столбца. Попробуйте ещё раз.");
                    continue;
                }
                return pos;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: вы ввели не число. Попробуйте ещё раз.");
                sc.next();
                System.out.println();
            }
        }
    }
    public static int givemode(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int pos;
            try {
                System.out.println("Привет выбери режим игры:\n1.Одиночная игра\n2.Игра с другом \n3.Игра с другом через websocket подключение\n");
                pos = sc.nextInt();

                return pos;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: вы ввели не число. Попробуйте ещё раз.");
                sc.next();
                System.out.println();
            }
        }
    }
    public static boolean Isauto(String str1){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(str1);
            boolean is;
            int number;
            try {
                number = sc.nextInt();
                if (number == 1 ) {

                    return true;
                }
                else if (number==2){
                    return false;

                }
                else {
                    System.out.println("Такого варианта нету.. Попробуйте ещё раз. ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: вы ввели не число. Попробуйте ещё раз.");
                sc.next();
                System.out.println();
            }
        }

    }

}

