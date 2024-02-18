import java.util.Scanner;
import java.util.Random;

public class Botmoves {
    public static void BotAddAllShip(Gamers gamer){
        gamer.my_field=BotShip.addbotBattleship_6(gamer);
        gamer.my_field=BotShip.addbotCarrier(gamer);
        gamer.my_field=BotShip.addbotCarrier(gamer);
        gamer.my_field=BotShip.addbotBattleship(gamer);
        gamer.my_field=BotShip.addbotBattleship(gamer);
        gamer.my_field=BotShip.addbotBattleship(gamer);
        gamer.my_field=BotShip.addbotCruiser(gamer);
        gamer.my_field=BotShip.addbotCruiser(gamer);
        gamer.my_field=BotShip.addbotCruiser(gamer);
        gamer.my_field=BotShip.addbotCruiser(gamer);
        gamer.my_field=BotShip.addbotDestroyer(gamer);
        gamer.my_field=BotShip.addbotDestroyer(gamer);
        gamer.my_field=BotShip.addbotDestroyer(gamer);
        gamer.my_field=BotShip.addbotDestroyer(gamer);
        gamer.my_field=BotShip.addbotDestroyer(gamer);
        gamer.my_field=BotShip.addbotSingleShip(gamer);
        gamer.my_field=BotShip.addbotSingleShip(gamer);
        gamer.my_field=BotShip.addbotSingleShip(gamer);
        gamer.my_field=BotShip.addbotSingleShip(gamer);
        gamer.my_field=BotShip.addbotSingleShip(gamer);
        gamer.my_field=BotShip.addbotSingleShip(gamer);


    }
    public static void BotShoat(Gamers gamer,Gamers gamer2){
        String name = gamer.name;
        String[][] opponent_field= gamer.opponent_field;
        String[][] shot_field = gamer2.my_field;
        Random random=new Random();
        Scanner sc = new Scanner(System.in);
        while(true) {
            if (gamer.score==56){
                break;
            }
            int pos2 = random.nextInt(16)+1;
            int pos1 = random.nextInt(16)+1;
            /*это нужно чтобы у бота была логика стрельбы но времени не хватает
            for (int i = 0; i < 17; i++) {
                for (int j = 0; j < 17; j++) {
                    if (opponent_field[i][j]=="w"){
                        while (true){
                            try{
                                int direction = random.nextInt(4)+1;
                                if (direction==1){ //вверх





                                }
                                else if(direction==2){

                                }
                                else if (direction==3){

                                }
                                else {

                                }



                                break;
                            }
                            catch (RuntimeException e){
                                continue;
                            }
                        }
                    }
                }
            }*/



            if(opponent_field[pos1][pos2]=="k"||
                    (opponent_field[pos1][pos2]=="m" ) ||
                    (opponent_field[pos1][pos2]=="w")){

                continue;
            }
            else if(shot_field[pos1][pos2]=="·") {
                gamer2.my_field[pos1][pos2]= "m";
                gamer.opponent_field[pos1][pos2]="m";

                break;

            }
            else{
                if (Moves.Is_kill(pos1,pos2,shot_field)){

                    Moves.Kill(pos1,pos2,shot_field,opponent_field,gamer,gamer2);
                    gamer2.my_field[pos1][pos2]="k";
                    gamer.opponent_field[pos1][pos2]="k";
                    gamer.score= gamer.score+1;
                    continue;
                }
                else{
                    gamer2.my_field[pos1][pos2]="w";
                    gamer.opponent_field[pos1][pos2]="w";

                    gamer.score= gamer.score+1;
                    continue;
                }

            }


        }


    }

}
