import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

    private static final List<String> romans = new ArrayList<>(
            Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"));

    public static void main(String[] args) throws Exception {
        //Test
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            System.out.println("Result: " + calc(input));
        }
    }

    public static String calc(String input) throws Exception {

        //Проверка: строка соответсвует нужному формату
        String[] elems = processInputFormat(input);

        String elem1 = elems[0].strip();
        String elem2 = elems[1].strip();
        char operation = getOperation(input);

        boolean isRoman;

        //Проверка: числа одной системы счисления
        if ((isRoman = isRoman(elem1)) == isRoman(elem2)) {
            int num1, num2;
            // Если римские:
            if (isRoman) {
                num1 = romanToNumber(elem1);
                num2 = romanToNumber(elem2);
            }
            // Если арабские:
            else {
                num1 = Integer.parseInt(elem1);
                num2 = Integer.parseInt(elem2);
            }
            //Проверка: переданные числа от 1 до 10 включительно
            checkBounds(num1, num2);

            int result = makeOperation(num1, num2, operation);

            if (isRoman) {
                if (result < 0)
                    throw new Exception("В римской системе нет отрицательных чисел");
                return romans.get(result);
            } else
                return String.valueOf(result);

        } else
            throw new Exception("Используются одновременно разные системы счисления");
    }

    public static String[] processInputFormat(String input) throws Exception {
        String[] elems = input.split("[+-/*]");
        if (elems.length != 2)
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        return elems;
    }

    public static char getOperation(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c == '+') {
                return '+';
            }
            if (c == '-') {
                return '-';
            }
            if (c == '*') {
                return '*';
            }
            if (c == '/') {
                return '/';
            }
        }
        return 'n';
    }

    public static boolean isRoman(String number) {
        return romans.contains(number);
    }

    public static int romanToNumber(String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static void checkBounds(int a, int b) throws Exception {
        if ((a >= 1 && a <= 10) && (b >= 1 && b <= 10))
            return;
        throw new Exception("Введенные числа выходят за пределы");
    }

    public static int makeOperation(int a, int b, char operation) {
        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> a / b;
        };
    }
}
