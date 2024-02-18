import java.util.Scanner;

/*Основной модуль здесь игрок выбирает режим игры
Всё просто и понятно полностью готов только с другом на 1 пк и мб инструкцию по игре успел добавить
БАГГ!! при вводе столбца не цифрой всё крашится(
играйте аккуратно*/
// w - ранил k - убил m- мимо после смерти корабля вокруг он закрашивается


public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        boolean start = true;
        while( start) {


                int rezim = Position.givemode();
                if (rezim == 1) {
                    Single.game();
                    continue;
                } else if (rezim == 2) {
                    Cooperative.game();
                    continue;


                } else if (rezim == 3) {
                    System.out.println("До выхода этого прийдётся подождать.....");
                    continue;

                } else if (rezim == 1111) {
                    System.out.println("Вы вошли в режим Admin(он не начинался делаться)");
                    continue;
                } else {
                    System.out.println("Вы ввели некоректный режим игры");
                    continue;
                }


        }




    }
}




