public class Laboratory_Work_1 {

    /** Задание 1. Дробная часть числа. */
    public double fraction(double x) {
        return x - (int) x;
    }

    /** Задание 2. Является ли число положительным. */
    public boolean isPositive(int x) {
        return x > 0;
    }

    /** Задание 3. Является ли число двузначным. */
    public boolean is2Digits(int x) {
        int abs = Math.abs(x);
        return abs >= 10 && abs <= 99;
    }

    /** Задание 4. Делит ли одно из чисел другое нацело. */
    public boolean isDivisor(int a, int b) {
        if (a == 0 && b == 0) return false;   // оба нуля
        if (a == 0 || b == 0) return true;    // 0 делится на ненулевое
        return a % b == 0 || b % a == 0;
    }

    /** Задание 5. Равны ли все три числа. */
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }
}