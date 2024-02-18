import java.util.Scanner;
import java.util.Random;

public class BotShip {

    //модуль создан для того чтобы бот мог добавлять корабли на своё игровое поле .
    /*так же благодаря этому можно сделать чтобы игроки авто добавляли корабли если им лень
    делается так же как и для пользователя только с использованием рандом и без текста корректно или нет в цикле
    мог даже не успеть  начать это делать )))* */
    public static String[][] addbotBattleship(Gamers gamer) { //Добавление 4-х палубного корабля
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[][] field = gamer.my_field;
        while (true) {

            int position1_1 = random.nextInt(16) + 1;;
            int position1_2=random.nextInt(16) + 1;;
            int direction = random.nextInt(2) + 1;;
            int prover = 0;

            // Проверка доступности клеток для корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 3 > 16) {

                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1][position1_2 + i] != "·" || // Проверка клеток на занятость
                            (position1_1 > 1 && field[position1_1 - 1][position1_2 + i] != "·") || // Проверка клетки сверху
                            (position1_1 < 16 && field[position1_1 + 1][position1_2 + i] != "·") || // Проверка клетки снизу
                            (i == 0 && position1_2 > 1 && field[position1_1][position1_2 - 1] != "·") || // Проверка клетки слева
                            (i == 3 && position1_2 < 13 && field[position1_1][position1_2 + 4] != "·") || // Проверка клетки справа
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·") || //4 след.проверки клеток по диагонали если они сущетсвуют
                            (position1_1 > 1 && position1_2 < 13 && field[position1_1 - 1][position1_2 + 4] != "·") ||
                            (position1_1 < 16 && position1_2 < 13 && field[position1_1 + 1][position1_2 + 4] != "·") ||
                            (position1_1 < 16 && position1_2 > 1 && field[position1_1 + 1][position1_2 - 1] != "·")) {

                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }else {
                    for (int i = 0; i < 4; i++){
                        field[position1_1][position1_2 + i] = "4"; //размещение
                    }

                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 3 > 16) {

                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1 + i][position1_2] != "·" || // Проверка клеток на занятость
                            (position1_2 > 1 && field[position1_1 + i][position1_2 - 1] != "·") || // Проверка клетки слева
                            (position1_2 < 16 && field[position1_1 + i][position1_2 + 1] != "·") || // Проверка клетки справа
                            (i == 0 && position1_1 > 1 && field[position1_1 - 1][position1_2] != "·") || // Проверка клетки сверху
                            (i == 3 && position1_1 < 13 && field[position1_1 + 4][position1_2] != "·") || // Проверка клетки снизу
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·") ||//4 след.проверки клеток по диагонали если они сущетсвуют
                            (position1_1 > 1 && position1_2 < 16 && field[position1_1 - 1][position1_2 + 1] != "·") ||
                            (position1_1 < 13 && position1_2 < 16 && field[position1_1 + 4][position1_2 + 1] != "·") ||
                            (position1_1 < 13 && position1_2 > 1 && field[position1_1 + 4][position1_2 - 1] != "·")) {

                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {//размещение
                    continue;
                }else{
                    for (int i = 0; i < 4; i++){
                        field[position1_1 + i][position1_2] = "4"; //
                    }
                }
            } else {

                continue;
            }

            break;
        }
        return field;
    }


    public static String[][] addbotCruiser(Gamers gamer) {//добавление 3-х палубного корабля
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        Random random=new Random();
        while (true) {
            int position1_1 = random.nextInt(16) + 1;;
            int position1_2=random.nextInt(16) + 1;;
            int direction = random.nextInt(2) + 1;;
            int prover=0;

            // Проверка доступности клеток для крейсера
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 2 > 16) {

                    continue;
                }
                for (int i = 0; i < 3; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1][position1_2 + i] != "·" || // Проверка клеток на занятость
                            (position1_1 > 1 && field[position1_1 - 1][position1_2 + i] != "·") || // Проверка клетки сверху
                            (position1_1 < 16 && field[position1_1 + 1][position1_2 + i] != "·") || // Проверка клетки снизу
                            (i == 0 && position1_2 > 1 && field[position1_1][position1_2 - 1] != "·") || // Проверка клетки слева
                            (i == 2 && position1_2 < 14 && field[position1_1][position1_2 + 3] != "·")|| // Проверка клетки справа
                            (position1_1> 1 && position1_2>1 && field[position1_1-1][position1_2-1] != "·")||//диагональные клетки
                            (position1_1>1 && position1_2<14 && field[position1_1-1][position1_2+3] != "·")||
                            (position1_1<16 && position1_2<14 && field[position1_1+1][position1_2+3] != "·")||
                            (position1_1<16 && position1_2>1 && field[position1_1+1][position1_2-1] != "·")) {

                        prover=1;
                        break;
                    }

                }

                if(prover==1){
                    continue;
                }
                else{
                    for (int i = 0; i < 3; i++){
                        field[position1_1][position1_2 + i] = "3";//размещение
                    }

                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 2 > 16) {

                    continue;
                }
                for (int i = 0; i < 3; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1 + i][position1_2] != "·" || // Проверка клеток на занятость
                            (position1_2 > 1 && field[position1_1 + i][position1_2 - 1] != "·") || // Проверка клетки слева
                            (position1_2 < 16 && field[position1_1 + i][position1_2 + 1] != "·") || // Проверка клетки справа
                            (i == 0 && position1_1 > 1 && field[position1_1 - 1][position1_2] != "·") || // Проверка клетки сверху
                            (i == 2 && position1_1 < 14 && field[position1_1 + 3][position1_2] != "·")|| // Проверка клетки снизу
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·")||//Клетки по диагонали если сущетсвуют
                            (position1_1 > 1 && position1_2 < 16 && field[position1_1 - 1][position1_2 + 1] != "·")||
                            (position1_1 < 14 && position1_2 < 16 && field[position1_1 + 3][position1_2 + 1] != "·")||
                            (position1_1 < 14 && position1_2 > 1 && field[position1_1 + 3][position1_2 - 1] != "·")) {

                        prover=1;
                        break;
                    }

                }

                if(prover==1){
                    continue;
                }
                else{
                    for (int i = 0; i < 3; i++){
                        field[position1_1 + i][position1_2] = "3";//размещение
                    }

                }
            } else {

                continue;
            }

            break; // Выходим из цикла
        }
        return field;
    }
    public static String[][] addbotDestroyer(Gamers gamer) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            int position1_1 = random.nextInt(16) + 1;;
            int position1_2=random.nextInt(16) + 1;;
            int direction = random.nextInt(2) + 1;;
            int prover = 0;

            // Проверка доступности клеток для двупалубного корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 1 > 16) {

                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1][position1_2 + i] != "·" || // Проверка клеток на занятость
                            (position1_1 > 1 && field[position1_1 - 1][position1_2 + i] != "·") || // Проверка клетки сверху
                            (position1_1 < 16 && field[position1_1 + 1][position1_2 + i] != "·") || // Проверка клетки снизу
                            (i == 0 && position1_2 > 1 && field[position1_1][position1_2 - 1] != "·") || // Проверка клетки слева
                            (i == 1 && position1_2 < 15 && field[position1_1][position1_2 + 2] != "·") || // Проверка клетки справа
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·") ||
                            (position1_1 > 1 && position1_2 < 15 && field[position1_1 - 1][position1_2 + 2] != "·") ||
                            (position1_1 < 16 && position1_2 < 15 && field[position1_1 + 1][position1_2 + 2] != "·") ||
                            (position1_1 < 16 && position1_2 > 1 && field[position1_1 + 1][position1_2 - 1] != "·")) {

                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }
                else {
                    for (int i = 0; i < 2; i++){
                        field[position1_1][position1_2 + i] = "2";
                    }

                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 1 > 16) {

                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1 + i][position1_2] != "·" || // Проверка клеток на занятость
                            (position1_2 > 1 && field[position1_1 + i][position1_2 - 1] != "·") || // Проверка клетки слева
                            (position1_2 < 16 && field[position1_1 + i][position1_2 + 1] != "·") || // Проверка клетки справа
                            (i == 0 && position1_1 > 1 && field[position1_1 - 1][position1_2] != "·") || // Проверка клетки сверху
                            (i == 1 && position1_1 < 15 && field[position1_1 + 2][position1_2] != "·") || // Проверка клетки снизу
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·") ||
                            (position1_1 > 1 && position1_2 < 16 && field[position1_1 - 1][position1_2 + 1] != "·") ||
                            (position1_1 < 15 && position1_2 < 16 && field[position1_1 + 2][position1_2 + 1] != "·") ||
                            (position1_1 < 15 && position1_2 > 1 && field[position1_1 + 2][position1_2 - 1] != "·")) {

                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }
                else {
                    for (int i = 0; i < 2; i++){
                        field[position1_1 + i][position1_2] = "2";

                    }

                }
            } else {

                continue;
            }

            break; // Выходим из цикла, когда двупалубный корабль успешно размещён
        }
        return field;
    }
    public static String[][] addbotSingleShip(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[][] field = gamer.my_field;
        while (true) {
            int position1_1 = random.nextInt(16) + 1;;
            int position1_2=random.nextInt(16) + 1;;

            // Проверка доступности клетки для однопалубного корабля и его окружения
            boolean hasNeighbours = false;
            for (int i = position1_1 - 1; i <= position1_1 + 1; i++) {
                for (int j = position1_2 - 1; j <= position1_2 + 1; j++) {
                    if (i >= 1 && i <= 16 && j >= 1 && j <= 16 && field[i][j] != "·") {
                        hasNeighbours = true;
                        break;
                    }
                }
                if (hasNeighbours) {
                    break;
                }
            }

            if (position1_1 < 1 || position1_1 > 16 || position1_2 < 1 || position1_2 > 16 || field[position1_1][position1_2] != "·" || hasNeighbours) {

                continue;
            }

            // Размещение однопалубного корабля
            field[position1_1][position1_2] = "1";
            break; // Выходим из цикла, когда корабль успешно размещён
        }
        return field;
    }
    public static String[][] addbotBattleship_6(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[][] field = gamer.my_field;
        while (true) {
            int position1_1 = random.nextInt(16) + 1;;
            int position1_2=random.nextInt(16) + 1;;
            int direction = random.nextInt(2) + 1;;

            // Размещение корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 5 > 16) {

                    continue;
                }
                for (int i = 0; i < 6; i++) {
                    field[position1_1][position1_2 + i] = "6"; // Здесь "6" означает 6-палубный корабль
                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 5 >16) {

                    continue;
                }
                for (int i = 0; i < 6; i++) {
                    field[position1_1 + i][position1_2] = "6"; // Здесь "6" означает 6-палубный корабль
                }
            } else {

                continue;
            }

            break; // Выходим из цикла, когда корабль успешно размещён
        }
        return field;
    }
    public static String[][] addbotCarrier(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[][] field1 = gamer.my_field;
        while (true) {
            String[][] field=field1;
            int position1_1 = random.nextInt(16) + 1;;
            int position1_2=random.nextInt(16) + 1;;
            int direction = random.nextInt(2) + 1;;
            int prover = 0;

            // Проверка доступности клеток для корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 4 > 16) {

                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1][position1_2 + i] != "·" || // Проверка клеток на занятость
                            (position1_1 > 1 && field[position1_1 - 1][position1_2 + i] != "·") || // Проверка клетки сверху
                            (position1_1 < 16 && field[position1_1 + 1][position1_2 + i] != "·") || // Проверка клетки снизу
                            (i == 0 && position1_2 > 1 && field[position1_1][position1_2 - 1] != "·") || // Проверка клетки слева
                            (i == 4 && position1_2 < 12 && field[position1_1][position1_2 + 5] != "·") || // Проверка клетки справа
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·") ||
                            (position1_1 > 1 && position1_2 < 12 && field[position1_1 - 1][position1_2 + 5] != "·") ||
                            (position1_1 < 16 && position1_2 < 12 && field[position1_1 + 1][position1_2 + 5] != "·") ||
                            (position1_1 < 16 && position1_2 > 1 && field[position1_1 + 1][position1_2 - 1] != "·")) {

                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }
                else{
                    for (int i = 0; i < 5; i++) {
                        field[position1_1][position1_2 + i] = "5"; // Здесь "5" означает 5-палубный корабль

                }
                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 4 >16) {

                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {

                        prover = 1;
                        break;
                    }
                    // Ваша проверка на занятость
                    if (field[position1_1 + i][position1_2] != "·" || // Проверка клеток на занятость
                            (position1_2 > 1 && field[position1_1 + i][position1_2 - 1] != "·") || // Проверка клетки слева
                            (position1_2 < 16 && field[position1_1 + i][position1_2 + 1] != "·") || // Проверка клетки справа
                            (i == 0 && position1_1 > 1 && field[position1_1 - 1][position1_2] != "·") || // Проверка клетки сверху
                            (i == 4 && position1_1 < 12 && field[position1_1 + 5][position1_2] != "·") || // Проверка клетки снизу
                            (position1_1 > 1 && position1_2 > 1 && field[position1_1 - 1][position1_2 - 1] != "·") ||
                            (position1_1 > 1 && position1_2 < 16 && field[position1_1 - 1][position1_2 + 1] != "·") ||
                            (position1_1 < 12 && position1_2 < 16 && field[position1_1 + 5][position1_2 + 1] != "·") ||
                            (position1_1 < 12 && position1_2 > 1 && field[position1_1 + 5][position1_2 - 1] != "·")) {

                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }
                else {
                    for (int i = 0; i < 5; i++){
                        field[position1_1 + i][position1_2] = "5"; // Здесь "5" означает 5-палубный корабль
                    }

                }
            }

            break; // Выходим из цикла, когда корабль успешно размещён
        }
        return field1;
    }

}
