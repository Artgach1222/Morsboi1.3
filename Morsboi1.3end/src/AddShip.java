import java.util.Scanner;
/*Модуль с функциями которые добавляют корабли
Также идёт проверка есть ли корабли по краям,корректно ли введены значения и хватает ли места.
Все корабли обозначаются цифрами в зависимости от клеток которые они занимают*/

public class AddShip {


    public static String[][] addBattleship(Gamers gamer) { //Добавление 4-х палубного корабля
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            System.out.println("Введите строку, в которую хотите поставить начало 4-x палубного  корабля");
            String string = sc.next().toUpperCase();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int position1_1 = -1;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(string)) {
                    position1_1 = i + 1;
                    break;
                }
            }
            if (position1_1 == -1) {
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;
            }

            int position1_2=Position.givepos();

            System.out.println("Выберите направление корабля: (1 - горизонтальное, 2 - вертикальное)");
            int direction = sc.nextInt();
            int prover = 0;

            // Проверка доступности клеток для корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 3 > 16) {
                    System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }
                else{
                    for (int i = 0; i < 4; i++){
                        field[position1_1][position1_2 + i] = "4"; //размещение
                    }
                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 3 > 16) {
                    System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {//размещение
                    continue;
                }
                else{
                    for (int i = 0; i < 4; i++){
                        field[position1_1 + i][position1_2] = "4"; //
                    }
                }
            } else {
                System.out.println("Вы ввели некорректное значение для направления корабля. Попробуйте ещё раз.");
                continue;
            }

            break;
        }
        return field;
    }


    public static String[][] addCruiser(Gamers gamer) {//добавление 3-х палубного корабля
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            System.out.println("Введите строку, в которую хотите поставить начало 3-х палубного корабля");
            String string = sc.next().toUpperCase();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int position1_1 = -1;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(string)) {
                    position1_1 = i+1;
                    break;
                }
            }
            if (position1_1 == -1) {
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;
            }

            int position1_2=Position.givepos();


            System.out.println("Выберите направление 3-х палубного корабля: (1 - горизонтальное, 2 - вертикальное)");
            int direction = sc.nextInt();
            int prover=0;

            // Проверка доступности клеток для крейсера
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 2 > 16) {
                    System.out.println("Невозможно разместить 3-х палубный корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 3; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить Невозможно разместить 3-х палубный корабль в выбранной позиции. Попробуйте ещё раз.");
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
                    System.out.println("Невозможно разместить Невозможно разместить 3-х палубный корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 3; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить 3-х палубный корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover=1;
                        break;
                    }

                }

                if(prover==1){
                    continue;
                }else{
                    for (int i = 0; i < 3; i++){
                        field[position1_1 + i][position1_2] = "3";//размещение
                    }

                }
            } else {
                System.out.println("Вы ввели некорректное значение для направления. Невозможно разместить 3-х палубного корабля. Попробуйте ещё раз.");
                continue;
            }

            break; // Выходим из цикла
        }
        return field;
    }
    public static String[][] addDestroyer(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            System.out.println("Введите строку, в которую хотите поставить начало двупалубного корабля");
            String string = sc.next().toUpperCase();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int position1_1 = -1;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(string)) {
                    position1_1 = i + 1;
                    break;
                }
            }
            if (position1_1 == -1) {
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;
            }


            int position1_2=Position.givepos();

            System.out.println("Выберите направление двупалубного корабля: (1 - горизонтальное, 2 - вертикальное)");
            int direction = sc.nextInt();
            int prover = 0;

            // Проверка доступности клеток для двупалубного корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 1 > 16) {
                    System.out.println("Невозможно разместить двупалубный корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить двупалубный корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }else{
                    for (int i = 0; i < 2; i++){
                        field[position1_1][position1_2 + i] = "2";
                    }

                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 1 > 16) {
                    System.out.println("Невозможно разместить двупалубный корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить двупалубный корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }else{
                    for (int i = 0; i < 2; i++){
                        field[position1_1 + i][position1_2] = "2";
                    }

                }
            } else {
                System.out.println("Вы ввели некорректное значение для направления двупалубного корабля. Попробуйте ещё раз.");
                continue;
            }

            break; // Выходим из цикла, когда двупалубный корабль успешно размещён
        }
        return field;
    }
    public static String[][] addSingleShip(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            System.out.println("Введите строку, в которую хотите поставить однопалубный корабль:");
            String string = sc.next().toUpperCase();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int position1_1 = -1;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(string)) {
                    position1_1 = i + 1;
                    break;
                }
            }
            if (position1_1 == -1) {
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;
            }


            int position1_2=Position.givepos();

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
                System.out.println("Невозможно разместить однопалубный корабль в выбранной позиции. Попробуйте ещё раз.");
                continue;
            }

            // Размещение однопалубного корабля
            field[position1_1][position1_2] = "1";
            break; // Выходим из цикла, когда корабль успешно размещён
        }
        return field;
    }
    public static String[][] addBattleship_6(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            System.out.println("Введите строку, в которую хотите поставить начало 6 палубного корабля");
            String string = sc.next().toUpperCase();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int position1_1 = 660;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(string)) {
                    position1_1 = i + 1;
                    break;
                }
            }
            if (position1_1 == 660) {
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;
            }

            int position1_2;
            position1_2= Position.givepos();



            int direction = Position.givedirection();

            // Размещение корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 5 > 16) {
                    System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 6; i++) {
                    field[position1_1][position1_2 + i] = "6"; // Здесь "6" означает 6-палубный корабль
                }
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 5 >16) {
                    System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 6; i++) {
                    field[position1_1 + i][position1_2] = "6"; // Здесь "6" означает 6-палубный корабль
                }
            } else {
                System.out.println("Вы ввели некорректное значение для направления корабля. Попробуйте ещё раз.");
                continue;
            }

            break; // Выходим из цикла, когда корабль успешно размещён
        }
        return field;
    }
    public static String[][] addCarrier(Gamers gamer) {
        Scanner sc = new Scanner(System.in);
        String[][] field = gamer.my_field;
        while (true) {
            System.out.println("Введите строку, в которую хотите поставить начало 5 ти палубного корабля");
            String string = sc.next().toUpperCase();
            String[] firststring = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int position1_1 = -1;
            for (int i = 0; i < 16; i++) {
                if (firststring[i].equals(string)) {
                    position1_1 = i + 1;
                    break;
                }
            }
            if (position1_1 == -1) {
                System.out.println("Вы ввели некорректное значение для строки. Попробуйте ещё раз.");
                continue;
            }

            int position1_2=Position.givepos();



            int direction = Position.givedirection();
            int prover = 0;

            // Проверка доступности клеток для корабля
            if (direction == 1) { // Горизонтальное размещение
                if (position1_2 + 4 > 16) {
                    System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    if (position1_2 + i >= field[0].length || position1_1 >= field.length || position1_1 < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    field = gamer.my_field;
                    continue;
                }
                else{for (int i = 0; i < 5; i++){
                    field[position1_1][position1_2 + i] = "5"; // Здесь "5" означает 5-палубный корабль
                }}
            } else if (direction == 2) { // Вертикальное размещение
                if (position1_1 + 4 >16) {
                    System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    if (position1_1 + i >= field.length || position1_2 >= field[0].length || position1_1 + i < 0 || position1_2 < 0) {
                        System.out.println("Неверные координаты!");
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
                        System.out.println("Невозможно разместить корабль в выбранной позиции. Попробуйте ещё раз.");
                        prover = 1;
                        break;
                    }

                }

                if (prover == 1) {
                    continue;
                }
                else{for (int i = 0; i < 5; i++){
                    field[position1_1 + i][position1_2] = "5"; // Здесь "5" означает 5-палубный корабль
                }

                }
            }

            break; // Выходим из цикла, когда корабль успешно размещён
        }
        return field;
    }


}










