import java.util.Scanner;
//Модуль который отвечат за основные действия.Добавление всех кораблей пользователем.Стрельба пользователей.
//Проверка убит или ранен корабль.Закраска убитого корабля.
//Алгоритм очень большой и стрвнный.Обьяснять подробно очень долго.В некоторых местах есть получение лишних данных
//Место равно стоило бы эквивалентность использовать.Но никто не идеален.
public class Moves {
    public static void AddAllShip(Gamers gamer){
        String name = gamer.name;
        System.out.println("Пусть " + name + " добавит свои корбали:");
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addBattleship_6(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addCarrier(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addCarrier(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addBattleship(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addBattleship(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addBattleship(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addCruiser(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addCruiser(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addCruiser(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addCruiser(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addDestroyer(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addDestroyer(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addDestroyer(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addDestroyer(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addDestroyer(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addSingleShip(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addSingleShip(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addSingleShip(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addSingleShip(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addSingleShip(gamer);
        Gamers.outmyField(gamer);
        gamer.my_field=AddShip.addSingleShip(gamer);
        Gamers.outmyField(gamer);


    }


    public static void Shoat(Gamers gamer,Gamers gamer2){
        String name = gamer.name;
        String[][] opponent_field= gamer.opponent_field;
        String[][] shot_field = gamer2.my_field;
        Scanner sc = new Scanner(System.in);
        while(true) {
            if (gamer.score==56){
                break;
            }
            Gamers.outopponentField(gamer);
            System.out.println("Введите строку в которную будете стрелять:");
            String pos1str = sc.next().toUpperCase();
            int pos2 = Position.giveposshoat();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int pos1 = -1;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(pos1str)) {
                    pos1 = i + 1;
                    break;
                }
            }
            if(pos1==-1){
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;

            }



            if(opponent_field[pos1][pos2]=="k"||
                    (opponent_field[pos1][pos2]=="m" ) ||
                    (opponent_field[pos1][pos2]=="w")){
                System.out.println(name + " Вы сюда уже стреляли.Выстерлите в другое место.");
                continue;
            }
            else if(shot_field[pos1][pos2]=="·") {
                gamer2.my_field[pos1][pos2]= "m";
                gamer.opponent_field[pos1][pos2]="m";
                System.out.println(name + " Вы выстрелили мимо");
                break;

            }
            else{
                if (Is_kill(pos1,pos2,shot_field)){
                System.out.println(name + " Вы убили корабль.Выстрелите ещё раз.");
                    Kill(pos1,pos2,shot_field,opponent_field,gamer,gamer2);
                    gamer2.my_field[pos1][pos2]="k";
                    gamer.opponent_field[pos1][pos2]="k";
                    gamer.score= gamer.score+1;
                continue;
            }
                else{
                gamer2.my_field[pos1][pos2]="w";
                gamer.opponent_field[pos1][pos2]="w";
                System.out.println(name + " Вы попали,корабль ранен, выстрелите ещё раз.");
                    gamer.score= gamer.score+1;
                continue;
            }

            }


        }


    }

    public static boolean Is_kill(int pos1,int pos2,String[][] field){
        boolean y;
        y=false;
        String data = field[pos1][pos2];
        int dataint = Integer.parseInt(data);
        int data1 = 1;
        int x,step;


        if(pos1+dataint>16){
            x = 16 - pos1;
        }
        else{
            x=dataint-1;
        }
        step =1;
        while(x>0){
            if (field[pos1+step][pos2]=="w") {
                data1=data1+1;
                step++;
            }
            else {
                break;
            }
            x=x-1;
        }


        if(pos1-dataint<1){
            x = pos1-1;
        }
        else{
            x=dataint-1;
        }
        step =1;
        while(x>0){
            if (field[pos1-step][pos2]=="w") {
                data1=data1+1;
                step++;
            }
            else {
                break;
            }
            x=x-1;

        }


        if(pos2-dataint<1){
            x = pos2-1;
        }
        else{
            x=dataint-1;
        }
        step =1;
        while(x>0) {
            if (field[pos1][pos2 - step] == "w") {
                data1 = data1 + 1;
                step++;
            } else {
                break;
            }
            x = x - 1;
        }


        if(pos2+dataint>16){
            x = 16 - pos2;
        }
        else{
            x=dataint-1;
        }
        step =1;
        while(x>0){
            if (field[pos1][pos2+step]=="w") {
                data1=data1+1;
                step++;
            }
            else {
                break;
            }
            x=x-1;
        }



        if (dataint==data1){
            y=true;
        }
        return y;
    }

    public static void Kill(int pos1,int pos2,String[][] field,String field2[][],Gamers gamer,Gamers gamer2) {
        String[][] shoatfield = gamer.opponent_field;
        String[][] myshoatfield = gamer2.my_field;
        String data = field[pos1][pos2];
        int dataint = Integer.parseInt(data);
        int x, step;
        int data1 = 1;
        if (pos1 + dataint > 16) {
            x = 16 - pos1;
        } else {
            x = dataint - 1;
        }
        step = 1;
        while (x > 0) {
            if (field[pos1 + step][pos2] == "w") {
                data1 = data1 + 1;
                if (pos1 + step == 1 && pos2 == 16) {
                    shoatfield[pos1 + step][pos2] = "k";
                    myshoatfield[pos1 + step][pos2] = "k";
                    shoatfield[pos1 + step][pos2 - 1] = "m";
                    myshoatfield[pos1 + step][pos2 - 1] = "m";

                }
                if (pos1 + step == 16 && pos2 != 16 && pos2 != 1) {
                    shoatfield[pos1 + step][pos2] = "k";
                    myshoatfield[pos1 + step][pos2] = "k";
                    shoatfield[pos1 + step][pos2 - 1] = "m";
                    myshoatfield[pos1 + step][pos2 - 1] = "m";
                    shoatfield[pos1 + step][pos2 + 1] = "m";
                    myshoatfield[pos1 + step][pos2 + 1] = "m";
                }
                if (pos1 + step != 16 && pos2 != 16 && pos2 != 1) {
                    shoatfield[pos1 + step][pos2] = "k";
                    myshoatfield[pos1 + step][pos2] = "k";
                    shoatfield[pos1 + step][pos2 - 1] = "m";
                    myshoatfield[pos1 + step][pos2 - 1] = "m";
                    shoatfield[pos1 + step][pos2 + 1] = "m";
                    myshoatfield[pos1 + step][pos2 + 1] = "m";
                    if (myshoatfield[pos1 + step + 1][pos2] != "w") {
                        shoatfield[pos1 + step + 1][pos2] = "m";
                        myshoatfield[pos1 + step + 1][pos2] = "m";
                        shoatfield[pos1 + step + 1][pos2 + 1] = "m";
                        myshoatfield[pos1 + step + 1][pos2 + 1] = "m";
                        shoatfield[pos1 + step + 1][pos2 - 1] = "m";
                        myshoatfield[pos1 + step + 1][pos2 - 1] = "m";

                    }
                }
                if (pos1 + step == 16 && pos2 == 1) {
                    shoatfield[pos1 + step][pos2] = "k";
                    myshoatfield[pos1 + step][pos2] = "k";
                    shoatfield[pos1 + step][pos2 + 1] = "m";
                    myshoatfield[pos1 + step][pos2 + 1] = "m";

                }
                if (pos1+step!=16&&pos2==1){
                    shoatfield[pos1 + step][pos2 + 1] = "m";
                    myshoatfield[pos1 + step][pos2 + 1] = "m";
                    shoatfield[pos1 + step][pos2 ] = "k";
                    myshoatfield[pos1 + step][pos2 ] = "k";
                    if(myshoatfield[pos1 + step + 1][pos2] != "w"){
                        shoatfield[pos1 + step + 1][pos2] = "m";
                        myshoatfield[pos1 + step + 1][pos2] = "m";
                        shoatfield[pos1 + step + 1][pos2+1] = "m";
                        myshoatfield[pos1 + step + 1][pos2+1] = "m";

                    }

                }
                if (pos1+step!=16&&pos2==16) {
                    shoatfield[pos1 + step][pos2 - 1] = "m";
                    myshoatfield[pos1 + step][pos2 - 1] = "m";
                    shoatfield[pos1 + step][pos2] = "k";
                    myshoatfield[pos1 + step][pos2] = "k";
                    if (myshoatfield[pos1 + step + 1][pos2] != "w") {
                        shoatfield[pos1 + step + 1][pos2] = "m";
                        myshoatfield[pos1 + step + 1][pos2] = "m";
                        shoatfield[pos1 + step + 1][pos2 -1] = "m";
                        myshoatfield[pos1 + step + 1][pos2 - 1] = "m";


                    }
                }

                step++;
            } else {
                break;
            }
            x = x - 1;
        }


        if (pos1 - dataint < 1) {
            x = pos1 - 1;
        } else {
            x = dataint - 1;
        }
        step = 1;
        while (x > 0) {
            if (field[pos1 - step][pos2] == "w") {
                data1 = data1 + 1;
                if (pos1 - step == 1 && pos2 == 16) {
                    shoatfield[pos1 - step][pos2] = "k";
                    myshoatfield[pos1 - step][pos2] = "k";
                    shoatfield[pos1 - step][pos2 - 1] = "m";
                    myshoatfield[pos1 - step][pos2 - 1] = "m";

                }
                if (pos1 - step == 1 && pos2 != 16 && pos2 != 1) {
                    shoatfield[pos1 - step][pos2] = "k";
                    myshoatfield[pos1 - step][pos2] = "k";
                    shoatfield[pos1 - step][pos2 - 1] = "m";
                    myshoatfield[pos1 - step][pos2 - 1] = "m";
                    shoatfield[pos1 - step][pos2 + 1] = "m";
                    myshoatfield[pos1 - step][pos2 + 1] = "m";
                }
                if (pos1 - step != 1 && pos2 != 16 && pos2 != 1) {
                    shoatfield[pos1 - step][pos2] = "k";
                    myshoatfield[pos1 - step][pos2] = "k";
                    shoatfield[pos1 - step][pos2 - 1] = "m";
                    myshoatfield[pos1 - step][pos2 - 1] = "m";
                    shoatfield[pos1 - step][pos2 + 1] = "m";
                    myshoatfield[pos1 - step][pos2 + 1] = "m";
                    if (myshoatfield[pos1 - step - 1][pos2] != "w") {
                        shoatfield[pos1 - step - 1][pos2] = "m";
                        myshoatfield[pos1 - step - 1][pos2] = "m";
                        shoatfield[pos1 - step - 1][pos2 + 1] = "m";
                        myshoatfield[pos1 - step - 1][pos2 + 1] = "m";
                        shoatfield[pos1 - step - 1][pos2 - 1] = "m";
                        myshoatfield[pos1 - step - 1][pos2 - 1] = "m";

                    }
                }
                if (pos1 - step == 1 && pos2 == 1) {
                    shoatfield[pos1 - step][pos2] = "k";
                    myshoatfield[pos1 - step][pos2] = "k";
                    shoatfield[pos1 - step][pos2 + 1] = "m";
                    myshoatfield[pos1 - step][pos2 + 1] = "m";

                }
                if (pos1-step!=1&&pos2==1){
                    shoatfield[pos1 - step][pos2 + 1] = "m";
                    myshoatfield[pos1 - step][pos2 + 1] = "m";
                    shoatfield[pos1 - step][pos2 ] = "k";
                    myshoatfield[pos1 - step][pos2 ] = "k";
                    if(myshoatfield[pos1 - step - 1][pos2] != "w"){
                        shoatfield[pos1 - step - 1][pos2] = "m";
                        myshoatfield[pos1 - step - 1][pos2] = "m";
                        shoatfield[pos1 - step - 1][pos2+1] = "m";
                        myshoatfield[pos1 - step - 1][pos2+1] = "m";

                    }

                }
                if (pos1-step!=1&&pos2==16) {
                    shoatfield[pos1 - step][pos2 - 1] = "m";
                    myshoatfield[pos1 - step][pos2 - 1] = "m";
                    shoatfield[pos1 - step][pos2] = "k";
                    myshoatfield[pos1 - step][pos2] = "k";
                    if (myshoatfield[pos1 - step - 1][pos2] != "w") {
                        shoatfield[pos1 - step - 1][pos2] = "m";
                        myshoatfield[pos1 - step - 1][pos2] = "m";
                        shoatfield[pos1 - step - 1][pos2 -1] = "m";
                        myshoatfield[pos1 - step - 1][pos2 - 1] = "m";


                    }
                }

                step++;
            } else {
                break;
            }
            x = x - 1;

        }


        if (pos2 - dataint < 1) {
            x = pos2 - 1;
        } else {
            x = dataint - 1;
        }
        step = 1;
        while (x > 0) {
            if (field[pos1][pos2 - step] == "w") {
                data1 = data1 + 1;
                if (pos1  == 16 && pos2 -step == 1) {
                    shoatfield[pos1][pos2-step] = "k";
                    myshoatfield[pos1][pos2-step] = "k";
                    shoatfield[pos1 - 1][pos2 - step] = "m";
                    myshoatfield[pos1 - 1][pos2 - step] = "m";

                }
                if (pos2-step == 1 && pos1 != 16 && pos1 != 1) {
                    shoatfield[pos1][pos2-step] = "k";
                    myshoatfield[pos1 ][pos2-step] = "k";
                    shoatfield[pos1 -1][pos2 - step] = "m";
                    myshoatfield[pos1 - 1][pos2 - step] = "m";
                    shoatfield[pos1 +1][pos2 - step] = "m";
                    myshoatfield[pos1 +1][pos2 - step] = "m";
                }
                if (pos2 - step != 1 && pos1 != 16 && pos1 != 1) {
                    shoatfield[pos1][pos2-step] = "k";
                    myshoatfield[pos1 ][pos2-step] = "k";
                    shoatfield[pos1 - 1][pos2 - step] = "m";
                    myshoatfield[pos1 - 1][pos2 - step] = "m";
                    shoatfield[pos1 +1 ][pos2 - step] = "m";
                    myshoatfield[pos1 +1][pos2 - step] = "m";
                    if (myshoatfield[pos1][pos2-step -1] != "w") {
                        shoatfield[pos1][pos2-step -1]   = "m";
                        myshoatfield[pos1][pos2-step -1] = "m";
                        shoatfield[pos1+1][pos2-step -1] = "m";
                        myshoatfield[pos1+1][pos2-step -1] = "m";
                        shoatfield[pos1  - 1][pos2-step -1] = "m";
                        myshoatfield[pos1  - 1][pos2-step -1] = "m";

                    }
                }
                if (pos2 - step == 1 && pos1 == 1) {
                    shoatfield[pos1 ][pos2 - step] = "k";
                    myshoatfield[pos1 ][pos2-step] = "k";
                    shoatfield[pos1 +1][pos2 - step] = "m";
                    myshoatfield[pos1 +1][pos2 - step] = "m";

                }
                if (pos2-step!=1&&pos1==1){
                    shoatfield[pos1 +1][pos2 -step] = "m";
                    myshoatfield[pos1 + 1][pos2 - step] = "m";
                    shoatfield[pos1][pos2 - step] = "k";
                    myshoatfield[pos1 ][pos2-step ] = "k";
                    if(myshoatfield[pos1 ][pos2- step - 1] != "w"){
                        shoatfield[pos1][pos2- step - 1] = "m";
                        myshoatfield[pos1 ][pos2- step - 1] = "m";
                        shoatfield[pos1 + 1][pos2- step - 1] = "m";
                        myshoatfield[pos1 + 1][pos2- step - 1] = "m";

                    }

                }
                if (pos2-step!=1&&pos1==16) {
                    shoatfield[pos1 - 1][pos2 - step] = "m";
                    myshoatfield[pos1 - 1][pos2 - step] = "m";
                    shoatfield[pos1 ][pos2-step] = "k";
                    myshoatfield[pos1 ][pos2-step] = "k";
                    if (myshoatfield[pos1 ][pos2 - step - 1] != "w") {
                        shoatfield[pos1][pos2- step - 1] = "m";
                        myshoatfield[pos1][pos2- step - 1] = "m";
                        shoatfield[pos1  - 1][pos2 - step - 1] = "m";
                        myshoatfield[pos1  - 1][pos2 - step - 1] = "m";


                    }
                }

                    step++;

                } else {
                    break;
                }
                x = x - 1;
            }


            if (pos2 + dataint > 16) {
                x = 16 - pos2;
            } else {
                x = dataint - 1;
            }
            step = 1;
            while (x > 0) {
                if (field[pos1][pos2 + step] == "w") {
                    data1 = data1 + 1;
                    if (pos2 + step == 1 && pos1 == 16) {
                        shoatfield[pos1][pos2+step] = "k";
                        myshoatfield[pos1 ][pos2 + step] = "k";
                        shoatfield[pos1 -1][pos2 + step] = "m";
                        myshoatfield[pos1 -1][pos2 + step] = "m";

                    }
                    if (pos2 + step == 16 && pos1 != 16 && pos1 != 1) {
                        shoatfield[pos1 ][pos2+ step] = "k";
                        myshoatfield[pos1 ][pos2+ step] = "k";
                        shoatfield[pos1 - 1][pos2 + step] = "m";
                        myshoatfield[pos1 - 1][pos2 + step] = "m";
                        shoatfield[pos1 + 1][pos2 + step] = "m";
                        myshoatfield[pos1 + 1][pos2 + step] = "m";
                    }
                    if (pos2 + step != 16 && pos1 != 16 && pos1 != 1) {
                        shoatfield[pos1 ][pos2+ step] = "k";
                        myshoatfield[pos1 ][pos2+ step] = "k";
                        shoatfield[pos1 - 1][pos2 + step] = "m";
                        myshoatfield[pos1 - 1][pos2 + step] = "m";
                        shoatfield[pos1 + 1][pos2 + step] = "m";
                        myshoatfield[pos1 + 1][pos2 + step] = "m";
                        if (myshoatfield[pos1 ][pos2 + step + 1] != "w") {
                            shoatfield[pos1 ][pos2+ step + 1] = "m";
                            myshoatfield[pos1 ][pos2+ step + 1] = "m";
                            shoatfield[pos1 + 1][pos2 + step + 1] = "m";
                            myshoatfield[pos1 + 1][pos2 + step + 1] = "m";
                            shoatfield[pos1 -1][pos2 + step + 1] = "m";
                            myshoatfield[pos1 - 1][pos2 + step + 1] = "m";

                        }
                    }
                    if (pos2 + step == 16 && pos1 == 1) {
                        shoatfield[pos1 ][pos2+ step] = "k";
                        myshoatfield[pos1 ][pos2+ step] = "k";
                        shoatfield[pos1 + 1][pos2 + step] = "m";
                        myshoatfield[pos1 + 1][pos2 + step] = "m";

                    }
                    if (pos2+step!=16&&pos1==1){
                        shoatfield[pos1 + 1][pos2 + step] = "m";
                        myshoatfield[pos1 + 1][pos2 + step] = "m";
                        shoatfield[pos1 ][pos2 + step ] = "k";
                        myshoatfield[pos1 ][pos2 + step] = "k";
                        if(myshoatfield[pos1 ][pos2 + step + 1] != "w"){
                            shoatfield[pos1 ][pos2+ step + 1] = "m";
                            myshoatfield[pos1][pos2+ step + 1] = "m";
                            shoatfield[pos1  + 1][pos2+ step + 1] = "m";
                            myshoatfield[pos1 + 1][pos2+ step + 1] = "m";

                        }

                    }
                    if (pos2+step!=16&&pos1==16) {
                        shoatfield[pos1 -1][pos2 + step] = "m";
                        myshoatfield[pos1 -1][pos2 + step] = "m";
                        shoatfield[pos1][pos2+ step] = "k";
                        myshoatfield[pos1 ][pos2+ step] = "k";
                        if (myshoatfield[pos1 ][pos2+ step + 1] != "w") {
                            shoatfield[pos1 ][pos2+ step + 1] = "m";
                            myshoatfield[pos1][pos2+ step + 1] = "m";
                            shoatfield[pos1 - 1][pos2 + step + 1] = "m";
                            myshoatfield[pos1 -1][pos2 + step + 1] = "m";


                        }
                    }

                    step++;
                } else {
                    break;
                }
                x = x - 1;
            }
            if(pos1==1&&pos2==1) {
                if (shoatfield[pos1 + 1][pos2] == "k") {
                    shoatfield[pos1][pos2 + 1] = "m";
                    myshoatfield[pos1][pos2 + 1] = "m";

                } else {
                    shoatfield[pos1 + 1][pos2] = "m";
                    myshoatfield[pos1 + 1][pos2] = "m";

                }
            }
            if(pos1==16&&pos2==1){
                if (shoatfield[pos1 - 1 ][pos2] == "k") {
                    shoatfield[pos1][pos2 + 1] = "m";
                    myshoatfield[pos1][pos2 + 1] = "m";

                } else {
                    shoatfield[pos1 - 1][pos2] = "m";
                    myshoatfield[pos1 - 1][pos2] = "m";

                }
            }
            if(pos1==16&&pos2==16){
                if (shoatfield[pos1 - 1 ][pos2] == "k") {
                    shoatfield[pos1][pos2 - 1] = "m";
                    myshoatfield[pos1][pos2 - 1] = "m";

                } else {
                    shoatfield[pos1 - 1][pos2] = "m";
                    myshoatfield[pos1 - 1][pos2] = "m";

                }

            }
            if(pos1==1&&pos2==16){
                if (shoatfield[pos1 - 1 ][pos2] == "k") {
                    shoatfield[pos1][pos2 + 1] = "m";
                    myshoatfield[pos1][pos2 + 1] = "m";

                } else {
                    shoatfield[pos1 + 1][pos2] = "m";
                    myshoatfield[pos1 + 1][pos2] = "m";

                }

            }
            if(pos1==1&&pos2!=1&&pos2!=16) {
                shoatfield[pos1+1][pos2-1] = "m";
                myshoatfield[pos1+1][pos2-1] = "m";
                shoatfield[pos1+1][pos2+1] = "m";
                myshoatfield[pos1+1][pos2+1] = "m";

                if (shoatfield[pos1 + 1][pos2] != "k") {
                    shoatfield[pos1+1][pos2 ] = "m";
                    myshoatfield[pos1+1][pos2] = "m";

                }
                if (shoatfield[pos1 ][pos2-1] != "k") {
                    shoatfield[pos1][pos2-1 ] = "m";
                    myshoatfield[pos1][pos2-1] = "m";

                }
                if (shoatfield[pos1 ][pos2+1] != "k") {
                    shoatfield[pos1][pos2 +1] = "m";
                    myshoatfield[pos1][pos2+1] = "m";

                }

            }
            if(pos1==16&&pos2!=1&&pos2!=16) {
                shoatfield[pos1-1][pos2 +1] = "m";
                myshoatfield[pos1-1][pos2+1] = "m";
                shoatfield[pos1-1][pos2 -1] = "m";
                myshoatfield[pos1-1][pos2-1] = "m";
                if (shoatfield[pos1 - 1][pos2] != "k") {
                    shoatfield[pos1-1][pos2 ] = "m";
                    myshoatfield[pos1-1][pos2] = "m";

                }
                if (shoatfield[pos1 ][pos2-1] != "k") {
                    shoatfield[pos1][pos2-1 ] = "m";
                    myshoatfield[pos1][pos2-1] = "m";

                }
                if (shoatfield[pos1 ][pos2+1] != "k") {
                    shoatfield[pos1][pos2 +1] = "m";
                    myshoatfield[pos1][pos2+1] = "m";

                }

            }
            if(pos2==1&&pos1!=1&&pos1!=16) {
                shoatfield[pos1+1][pos2+1 ] = "m";
                myshoatfield[pos1+1][pos2+1] = "m";
                shoatfield[pos1-1][pos2+1 ] = "m";
                myshoatfield[pos1-1][pos2+1] = "m";
                if (shoatfield[pos1 ][pos2+1] != "k") {
                    shoatfield[pos1][pos2+1 ] = "m";
                    myshoatfield[pos1][pos2+1] = "m";

                }
                if (shoatfield[pos1 -1][pos2] != "k") {
                    shoatfield[pos1-1][pos2 ] = "m";
                    myshoatfield[pos1-1][pos2] = "m";

                }
                if (shoatfield[pos1+1 ][pos2] != "k") {
                    shoatfield[pos1+1][pos2 ] = "m";
                    myshoatfield[pos1+1][pos2] = "m";

                }

            }
            if(pos2==16&&pos1!=1&&pos1!=16) {
                shoatfield[pos1+1][pos2-1 ] = "m";
                myshoatfield[pos1+1][pos2-1] = "m";
                shoatfield[pos1-1][pos2-1 ] = "m";
                myshoatfield[pos1-1][pos2-1] = "m";
                if (shoatfield[pos1 ][pos2-1] != "k") {
                    shoatfield[pos1][pos2-1 ] = "m";
                    myshoatfield[pos1][pos2-1] = "m";

                }
                if (shoatfield[pos1 -1][pos2] != "k") {
                    shoatfield[pos1-1][pos2 ] = "m";
                    myshoatfield[pos1-1][pos2] = "m";

                }
                if (shoatfield[pos1+1 ][pos2] != "k") {
                    shoatfield[pos1+1][pos2 ] = "m";
                    myshoatfield[pos1+1][pos2] = "m";

                }

            }
            if (pos1!=16&&pos1!=1&&pos2!=1&&pos2!=16){
                if (shoatfield[pos1+1 ][pos2] != "k") {
                    shoatfield[pos1+1][pos2 ] = "m";
                    myshoatfield[pos1+1][pos2] = "m";

                }
                if (shoatfield[pos1-1 ][pos2] != "k") {
                    shoatfield[pos1-1][pos2 ] = "m";
                    myshoatfield[pos1-1][pos2] = "m";

                }
                if (shoatfield[pos1 ][pos2+1] != "k") {
                    shoatfield[pos1][pos2 +1] = "m";
                    myshoatfield[pos1][pos2+1] = "m";

                }
                if (shoatfield[pos1 ][pos2-1] != "k") {
                    shoatfield[pos1][pos2-1 ] = "m";
                    myshoatfield[pos1][pos2-1] = "m";

                }
                if (shoatfield[pos1+1 ][pos2+1] != "k") {
                    shoatfield[pos1+1][pos2+1 ] = "m";
                    myshoatfield[pos1+1][pos2+1] = "m";

                }
                if (shoatfield[pos1-1 ][pos2-1] != "k") {
                    shoatfield[pos1-1][pos2 -1] = "m";
                    myshoatfield[pos1-1][pos2-1] = "m";

                }
                if (shoatfield[pos1 -1][pos2+1] != "k") {
                    shoatfield[pos1-1][pos2 +1] = "m";
                    myshoatfield[pos1-1][pos2+1] = "m";

                }
                if (shoatfield[pos1 +1][pos2-1] != "k") {
                    shoatfield[pos1+1][pos2-1 ] = "m";
                    myshoatfield[pos1+1][pos2-1] = "m";

                }

            }





        }
    }








