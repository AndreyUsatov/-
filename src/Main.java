import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner calculator = new Scanner(System.in);
        String number = calculator.nextLine();
        String name = number.trim();
        System.out.println(calc(name));
    }

    public static String calc(String name) throws Exception {
        int a;
        int b;
        String sign;
        String result;
        String[] operands = name.split("[+\\-*/]");
        if (operands.length != 2) {
            throw new Exception("throws  Exception");
        }
        sign = poiskSign(name);
        if (sign == null) throw new Exception("throws  Exception");
        a = Integer.parseInt(operands[0]);
        b = Integer.parseInt(operands[1]);
        if (!(a >= 1 && a <= 10 && b >= 1 && b <= 10))
            throw new Exception("throws  Exception");
        int resulInt = calcInt(a, b, sign);
        result = String.valueOf(resulInt);
        return result;
    }

    private static String poiskSign(String name) {
        if (name.contains("+")) return "+";
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