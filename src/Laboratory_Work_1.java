import java.util.Random;
import java.util.Scanner;

public class Laboratory_Work_1 {

    /** Общий Scanner для Main и guessGame — исключает конфликт буферов. */
    private static final Scanner SCANNER = new Scanner(System.in);
    public static Scanner getScanner() { return SCANNER; }

    // Задание 1

    /** 1.1. Дробная часть числа x. */
    public double fraction(double x) { return x - (int) x; }

    /** 1.2. true, если x положительное. */
    public boolean isPositive(int x) { return x > 0; }

    /** 1.3. true, если x двузначное (учитывая знак). */
    public boolean is2Digits(int x) {
        int abs = Math.abs(x);
        return abs >= 10 && abs <= 99;
    }

    /** 1.4. true, если одно из чисел делит другое нацело. */
    public boolean isDivisor(int a, int b) {
        if (a == 0 && b == 0) return false;
        if (a == 0 || b == 0) return true;
        return a % b == 0 || b % a == 0;
    }

    /** 1.5. true, если все три числа равны. */
    public boolean isEqual(int a, int b, int c) { return a == b && b == c; }

    // Задание 2

    /** 2.1. true, если x делится на 3 или 5, но не на оба сразу. */
    public boolean is35(int x) {
        boolean d3 = x % 3 == 0, d5 = x % 5 == 0;
        if (d3 && d5) return false;
        return d3 || d5;
    }

    /** 2.2. Максимум из трёх чисел (две if, без вложенности). */
    public int max3(int x, int y, int z) {
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }

    /** 2.3. Сумма x + y; если попадает в [10, 19] — вернуть 20. */
    public int sum2(int x, int y) {
        int s = x + y;
        if (s >= 10 && s <= 19) return 20;
        return s;
    }

    /** 2.4. Строка "<x> год/года/лет" по правилам русского языка. */
    public String age(int x) {
        int abs = Math.abs(x) % 100, last = abs % 10;
        if (abs >= 11 && abs <= 14) return x + " лет";
        if (last == 1)              return x + " год";
        if (last >= 2 && last <= 4) return x + " года";
        return x + " лет";
    }

    /** 2.5. Печать дня недели и всех последующих до воскресенья (switch с fall-through). */
    public void printDays(String x) {
        switch (x) {
            case "понедельник": System.out.println("понедельник");
            case "вторник":     System.out.println("вторник");
            case "среда":       System.out.println("среда");
            case "четверг":     System.out.println("четверг");
            case "пятница":     System.out.println("пятница");
            case "суббота":     System.out.println("суббота");
            case "воскресенье": System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    // Задание 3

    /** 3.1. Строка со всеми числами от x до 0 через пробел. */
    public String reverseListNums(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = x; i >= 0; i--) {
                sb.append(i);
                if (i > 0) sb.append(" ");
            }
        } else {
            for (int i = x; i <= 0; i++) {
                sb.append(i);
                if (i < 0) sb.append(" ");
            }
        }
        return sb.toString();
    }

    /** 3.2. x в степени y (при y < 0 возвращает 0). */
    public int pow(int x, int y) {
        if (y < 0) return 0;
        int result = 1;
        for (int i = 0; i < y; i++) result *= x;
        return result;
    }

    /** 3.3. true, если все цифры числа одинаковы. */
    public boolean equalNum(int x) {
        int abs = Math.abs(x);
        if (abs < 10) return true;
        int first = abs % 10;
        abs /= 10;
        while (abs > 0) {
            if (abs % 10 != first) return false;
            abs /= 10;
        }
        return true;
    }

    /** 3.4. Треугольник из '*' высотой x, выровненный по правому краю. */
    public void rightTriangle(int x) {
        for (int row = 1; row <= x; row++) {
            for (int s = 0; s < x - row; s++) System.out.print(" ");
            for (int s = 0; s < row; s++)     System.out.print("*");
            System.out.println();
        }
    }

    /** 3.5. Угадайка: загадать число 0..9 и читать попытки до угадывания. */
    public void guessGame() {
        int secret = new Random().nextInt(10);
        int attempts = 0;
        while (true) {
            String prompt = attempts == 0
                    ? "Введите число от 0 до 9: "
                    : "Вы не угадали, введите число от 0 до 9: ";
            int guess = readGuess(prompt);
            attempts++;
            if (guess == secret) {
                System.out.println("Вы угадали!");
                System.out.println("Вы отгадали число за " + attempts + " " + attemptsWord(attempts));
                return;
            }
        }
    }

    // Задание 4

    /** 4.1. Индекс первого вхождения x в arr, либо -1. */
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    /** 4.2. Наибольшее по модулю значение (возвращается само значение со знаком). */
    public int maxAbs(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(best)) {
                best = arr[i];
            }
        }
        return best;
    }

    /** 4.3. Реверс массива на месте (метод изменяет переданный массив). */
    public void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    /** 4.4. Возвращает НОВЫЙ массив - перевёрнутую копию исходного. */
    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    /** 4.5. Новый массив: сначала arr1, затем arr2. */
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) result[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++) result[arr1.length + i] = arr2[i];
        return result;
    }

    // Вспомогательные

    /** Ввод числа 0..9 с валидацией (используется в guessGame). */
    private int readGuess(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                int g = Integer.parseInt(line);
                if (g < 0 || g > 9) {
                    System.out.println("Число должно быть от 0 до 9.");
                    continue;
                }
                return g;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число от 0 до 9.");
            }
        }
    }

    /** Согласование слова «попытка» с числом (1 попытку, 2 попытки, 5 попыток). */
    private static String attemptsWord(int n) {
        int last = n % 10, lastTwo = n % 100;
        if (lastTwo >= 11 && lastTwo <= 14) return "попыток";
        if (last == 1)              return "попытку";
        if (last >= 2 && last <= 4) return "попытки";
        return "попыток";
    }
}