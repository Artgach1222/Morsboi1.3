import java.util.concurrent.TimeUnit;
//действия с консолью.Для того чтобы игра на одном устройстве 2х игроков была без подглядывания.
public class Console {
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            System.out.println("Ошибка при попытке очистить консоль: " + e.getMessage());
        }
    }

    public static void clear() {
        int count = 3;
        System.out.println("Консоль скоро будет через 3 секунд,передайте устройство другом игроку после очистки");

        while (count > 0) {
            System.out.println(count);
            count--;
            try {
                TimeUnit.SECONDS.sleep(1); // Остановка выполнения на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        clearConsole();
    }
    public static void start() {
        int count = 7;
        System.out.println("Если вам передали устройство,то скоро начнётся ваш ход");

        while (count > 0) {
            System.out.println(count);
            count--;
            try {
                TimeUnit.SECONDS.sleep(1); // Остановка выполнения на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Начнём!!!");


    }

}
