import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.util.regex.PatternSyntaxException;
import java.util.List;

public class Main {
    //2 Задание
    public static boolean isPasswordValid(String password) {
        boolean regex = password.matches("^(?=.*[A-Z])(?=.*\\d).{8,16}$");
        try {
            if (!regex) {
                throw new Exception("Пароль должен состоять из латинских букв и цифр, быть\n" +
                        "длиной от 8 до 16 символов и содержать хотя бы одну заглавную букву и\n" +
                        "одну цифру");
            }

            return true;

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }
    //4 Задание
    public static String validateIP(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            return "Ip адрес должен содержать 4 числа";
        }

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return "Числа должны быть в диапазоне от 0 до 255";
                }
            } catch (NumberFormatException e) {
                return "Обнаружено не число";
            }

        }

        String ipPattern = ("^([01]?\\d{1,2}|2[0-4]\\d|25[0-5])" +
                "(\\.([01]?\\d{1,2}|2[0-4]\\d|25[0-5])){3}$");

        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ipAddress);

        if (!matcher.matches()) {
            return "Строка не соответсвует регулярному выражению";
        }

        return "Корректный Ip адрес";
    }

    public static void main(String[] args) {
        //
        // 1 Задание
        String text = "This price is -21$, but for sale that will be 15.9$";
        try {
            Pattern pattern = Pattern.compile("\\d+\\.\\d+");
            Matcher matcher = pattern.matcher(text);
            boolean found = false;

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("Нет чисел в строке");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Синтаксическая ошибка в шаблоне" + e.getMessage());
        }
        //2 Задание
        String password = "Yourpassword123";

        if (isPasswordValid(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
        //3 Задание
        try {
            String inputText = "Мой сайт: http://www.examplekhaya.ru Мой e-mail: contact@example.com, также" +
                    " можете перейти на эти странциы  https://www.example.org" +
                    " или https://www.example.com/page?param=value. ";

            String regex = "\\bhttps?://([A-Za-z0-9.-]+\\.[A-Za-z]{2,}" +
                    "|localhost|\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})(:[0-9]+)?(/\\S*)?";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputText);
            List<String> validUrls = new ArrayList<>();
            while (matcher.find()) {
                validUrls.add(matcher.group());
            }
            System.out.println(inputText);
        }
        catch (PatternSyntaxException e) {
            System.err.println("Pattern syntax exception: " + e.getMessage());
        }
        //4 Задание


        String ipAddress;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ip адрес: ");
        ipAddress = sc.next();


        String result = validateIP(ipAddress);

        System.out.println(ipAddress + " " + result);
        //5 Задание
        try {
            String sentence = "The text in which the word search will be performed";
            char searchLetter = 'T';
            if (!Character.isLetter(searchLetter)) {
                System.err.println("Не существует такой буквы, с которого должно начинаться слово в тексте");
                return;
            }
            String regex = "\\b" + searchLetter + "\\w*";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sentence);

            System.out.println("Слово, которое начинается с буквы '" + searchLetter + "':");

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
        catch (PatternSyntaxException e) {
            System.err.println("Синтаксическая ошибка в шаблоне: " + e.getMessage());
        }
    }
}