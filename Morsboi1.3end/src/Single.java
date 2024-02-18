import java.util.Scanner;

public class Single {
    public static void game(){
        Scanner sc = new Scanner(System.in,"UTF-8");
        System.out.println("Ох,вы играете один.Как мне называть  игрока?");
        Gamers gamer1 = new Gamers();
        Gamers gamer2 = new Gamers();
        gamer1.setname(sc.next());
        gamer1.my_field=Gamers.Clearfield();
        gamer1.opponent_field=Gamers.Clearfield();
        gamer2.my_field=Gamers.Clearfield();
        gamer2.opponent_field=Gamers.Clearfield();
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
        Botmoves.BotAddAllShip(gamer2);
        while (gamer1.score!=56&&gamer2.score!=56){
            Gamers.outmyField(gamer1);
            System.out.println("Вы стреляете " );
            Moves.Shoat(gamer1,gamer2);

            if(gamer1.score==56) {
                System.out.println("Вы победили");
                break;
            }
            Botmoves.BotShoat(gamer2,gamer1);
            if(gamer2.score==56) {
                System.out.println( "Bot победил");
                Console.clear();
                break;

            }

        }
    }
}
