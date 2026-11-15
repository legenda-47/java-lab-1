import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Laboratory_Work_1 lab = new Laboratory_Work_1();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= МЕНЮ =========");
            System.out.println("1 - Дробная часть числа");
            System.out.println("2 - Есть ли позитив");
            System.out.println("3 - Двузначное число");
            System.out.println("4 - Делитель");
            System.out.println("5 - Равенство трёх чисел");
            System.out.println("0 - Выход");
            System.out.println("========================");

            int choice = readInt("Выберите пункт: ");

            switch (choice) {
                case 1: taskFraction();   break;
                case 2: taskIsPositive(); break;
                case 3: taskIs2Digits();  break;
                case 4: taskIsDivisor();  break;
                case 5: taskIsEqual();    break;
                case 0:
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Такого пункта нет. Повторите ввод.");
            }
        }
    }

    // Задание 1
    private static void taskFraction() {
        double x = readDouble("Введите вещественное число x: ");
        double result = lab.fraction(x);
        System.out.printf("Дробная часть числа %.4f = %.4f%n", x, result);
    }

    // Задание 2
    private static void taskIsPositive() {
        int x = readInt("Введите целое число x: ");
        System.out.println("Число " + x + " положительное? " + lab.isPositive(x));
    }

    // Задание 3
    private static void taskIs2Digits() {
        int x = readInt("Введите целое число x: ");
        System.out.println("Число " + x + " двузначное? " + lab.is2Digits(x));
    }

    // Задание 4
    private static void taskIsDivisor() {
        int a = readInt("Введите число a: ");
        int b = readInt("Введите число b: ");
        System.out.println("Одно из чисел делит другое нацело? " + lab.isDivisor(a, b));
    }

    //  Задание 5
    private static void taskIsEqual() {
        int a = readInt("Введите a: ");
        int b = readInt("Введите b: ");
        int c = readInt("Введите c: ");
        System.out.println("Все три числа равны? " + lab.isEqual(a, b, c));
    }

    // Вспомогательные функции, проверка при не корректном вводе

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное вещественное число.");
            }
        }
    }
}