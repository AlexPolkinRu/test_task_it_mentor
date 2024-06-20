import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Aleksandr Polochkin
 * 19.06.2024
 */

public class Main {
    public static void main(String[] args) {
        //Тесты
        String[] testStrings = {
                "1 + 1", // Тест 1: 2
                "1 / 1", // Тест 2: 1
                "10 * 10", // Тест 3: 100
                "1 - 1", // Тест 4: 0
                "1+ 1", // Тест 5: 2
                "1 +1", // Тест 6: 2
                "10+1", // Тест 7: 11
                "1 - 10", // Тест 8: -9
                "11+1", // Тест 9: Ошибка формата: первый аргумент больше 10
                "-1 - 1", // Тест 10: Ошибка формата: первый аргумент меньше 0
                "3", // Тест 11: Ошибка формата: только один аргумент и нет арифметического действия
                "3 3", // Тест 12: Ошибка формата: нет арифметического действия
                "3 + 2 + 3", // Тест 13: Ошибка формата: три аргумента
                "3 + 2 3" // Тест 14: Ошибка формата
        };
        for (int i = 0; i < testStrings.length; i++) {
            try {
                System.out.print("Тест " + (i + 1) + ": ");
                System.out.println(testStrings[i] + " = " + calc(testStrings[i]));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public static String calc(String input) throws Exception {
        String regexInputVerification = "^1?\\d\\s?[*/+-]\\s?1?\\d";
        String regexSign = "[*/+-]";

        if (Pattern.matches(regexInputVerification, input)) {
            String[] args = input.split(regexSign);
            int a = Integer.parseInt(args[0].trim());
            int b = Integer.parseInt(args[1].trim());

            if (a > 10 || b > 10) throw new Exception();

            Pattern patternSign = Pattern.compile(regexSign);
            Matcher matcher = patternSign.matcher(input);
            matcher.find();
            switch (matcher.group()) {
                case "+":
                    return "" + (a + b);
                case "-":
                    return "" + (a - b);
                case "*":
                    return "" + (a * b);
                case "/":
                    return "" + (a / b);
                default:
                    throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
}