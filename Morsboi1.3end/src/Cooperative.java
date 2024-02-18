import java.util.Scanner;
//Игра с другом на одном компе всё собрано в этом модуле
public class Cooperative {

    public static void game(){

        Scanner sc = new Scanner(System.in,"UTF-8");
        System.out.println("Ох,вы играете двоём.Как мне называть 1 игрока?");
        Gamers gamer1 = new Gamers();
        Gamers gamer2 = new Gamers();
        gamer1.setname(sc.next());
        gamer1.my_field=Gamers.Clearfield();
        gamer1.opponent_field=Gamers.Clearfield();
        gamer2.my_field=Gamers.Clearfield();
        gamer2.opponent_field=Gamers.Clearfield();
        System.out.println("Как мне называть 2 игрока?");
        gamer2.setname(sc.next());
        gamer1.score=0;
        gamer2.score=0;
        System.out.println("Пусть "+gamer1.name+" раставит свои корабли");

        if (Position.Isauto("Вы хотите расставить корабли вручную или автоматически?(1-вручную,2-автоматически)")){
            Moves.AddAllShip(gamer1);
        }
        else {
            while (true){
                gamer1.my_field=Gamers.Clearfield();
                Botmoves.BotAddAllShip(gamer1);
                Gamers.outmyField(gamer1);

                if (Position.Isauto("Вас устраивает расстановка кораблей(1-да,2-расставить заново)")){
                    break;
                }
                else{
                    continue;
                }

            }
        }

        Console.clear();
        Console.start();
        System.out.println("Пусть "+gamer2.name+" раставит свои корабли");

        if (Position.Isauto("Вы хотите расставить корабли вручную или автоматически?(1-вручную,2-автоматически)")){
            Moves.AddAllShip(gamer2);
        }
        else {
            while (true){
                gamer2.my_field=Gamers.Clearfield();
                Botmoves.BotAddAllShip(gamer2);
                Gamers.outmyField(gamer2);

                if (Position.Isauto("Вас устраивает расстановка кораблей(1-да,2-расставить заново)")){
                    break;
                }
                else{
                    continue;
                }

            }
        }
        Console.clear();
        Console.start();
        while (gamer1.score!=56&&gamer2.score!=56){
            Gamers.outmyField(gamer1);
            System.out.println("Стреляет " + gamer1.name);
            Moves.Shoat(gamer1,gamer2);

            if(gamer1.score==56) {
                System.out.println(gamer1.name + "Победил");
                break;
            }
            Console.clear();
            Console.start();
            Gamers.outmyField(gamer2);
            System.out.println("Стреляет " + gamer2.name);
            Moves.Shoat(gamer2,gamer1);
            if(gamer2.score==56) {
                System.out.println(gamer2.name + "Победил");
                Console.clear();
                break;

            }
            Console.clear();
            Console.start();

        }







    }
}
