import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner calculator = new Scanner(System.in);
        String number = calculator.nextLine(); // сканер строки
        String name = number.trim(); //  удаляет пробелы в конце строки
        System.out.println(calc(name));
    }

    public static String calc(String name) throws Exception {
        int a;
        int b;
        String sign;
        String result;
        String[] operands = name.split("[+\\-*/]"); // создеам массив чисел. взяв строку name и поделив ее знаками ( +, -,*, /)
        if (operands.length != 2) {
            throw new Exception("throws  Exception");
        }// если строка массива не равна 2, то выдаем исключение
        sign = poiskSign(name); // возращаем знак, полученный из метода poiskZnaka
        if (sign == null) throw new Exception("throws  Exception");  // если знак не +-*/, то выдаем иключение
        a = Integer.parseInt(operands[0]); // Берем String из массива под индексом 0 и переводим его в Integer
        b = Integer.parseInt(operands[1]);
        if (!(a >= 1 && a <= 10 && b >= 1 && b <= 10))
            throw new Exception("throws  Exception"); //  если числа меньше 1 и больше 10, выдаем исключение
        int resulInt = calcInt(a, b, sign); // возвращаем интовый результат вычеслениея из метода calcInt
        result = String.valueOf(resulInt);
        return result;
    }

    private static String poiskSign(String name) {
        if (name.contains("+")) return "+"; // если встроке name знак"+", то возвращем знак +
        if (name.contains("-")) return "-";
        if (name.contains("*")) return "*";
        if (name.contains("/")) return "/";
        else return null;
    }

    static int calcInt(int a, int b, String sign) {
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}