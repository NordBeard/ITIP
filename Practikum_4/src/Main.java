import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println();

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println();

        System.out.println(binarySystem(2));
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println();

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println();

        System.out.println(unnamedFunction("aaabbcdd"));
        System.out.println(unnamedFunction("vvvvaajaaaaa"));
        System.out.println();

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println();

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println();

        int[][] array1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(shortestWay(array1));
        int[][] array2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(array2));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println();

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }
    public static String nonRepeatable(String text) {
        if (!text.isEmpty()) {
            return text.charAt(0) + nonRepeatable(text.replace("" + text.charAt(0), ""));
        }
        return "";
    }

    public static ArrayList<String> generateBrackets(int n) {
        if (n <= 0) {
            return new ArrayList<>(List.of(""));
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String s: generateBrackets(n - 1)) {
            if (!answer.contains("()" + s)) {
                answer.add("()" + s);
            }
            if (!answer.contains("(" + s + ")")) {
                answer.add("(" + s + ")");
            }
            if (!answer.contains(s + "()")) {
                answer.add(s + "()");
            }
        }
        return answer;
    }

    public static ArrayList<String> binarySystem(int n) {
        if (n <= 0) {
            return new ArrayList<>(List.of(""));
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String s: binarySystem(n - 1)) {
            if (!("0" + s).contains("00")) {
                answer.add("0" + s);
            }
            answer.add("1" + s);
        }
        return answer;
    }

    public static String alphabeticRow(String string) {
        if (string.length() < 2) return string;
        StringBuilder maxSubString = new StringBuilder();
        StringBuilder nowSubString = new StringBuilder("" + string.charAt(0));
        boolean upper = string.charAt(0) < string.charAt(1);
        for (int i = 1; i < string.length(); i++) {
            char bef = string.charAt(i - 1);
            char now = string.charAt(i);

            if ((upper && bef == now - 1) || (!upper && bef == now + 1)) {
                nowSubString.append(now);
            }
            else {
                if (nowSubString.length() > maxSubString.length()) {
                    maxSubString = nowSubString;
                }
                if ((bef == now + 1) || (bef == now - 1)) {
                    nowSubString = new StringBuilder("" + bef + now);
                }
                else {
                    nowSubString = new StringBuilder("" + now);
                }
                upper = !upper;
            }
        }
        if (nowSubString.length() > maxSubString.length()) {
            maxSubString = nowSubString;
        }
        return maxSubString.toString();
    }

    public static String unnamedFunction(String string) {
        StringBuilder answer = new StringBuilder();
        String[] elements = new String[string.length() + 1];
        char nowSymbol = string.charAt(0);
        int nowNum = 0;
        for (char symbol: string.toCharArray()) {
            if (symbol == nowSymbol) {
                nowNum += 1;
            }
            else {
                if (elements[nowNum] == null) elements[nowNum] = "";
                elements[nowNum] += nowSymbol + Integer.toString(nowNum);
                nowSymbol = symbol;
                nowNum = 1;
            }
        }
        if (elements[nowNum] == null) elements[nowNum] = "";
        elements[nowNum] += nowSymbol + Integer.toString(nowNum);
        for (String str: elements) {
            if (str != null) answer.append(str);
        }
        return answer.toString();
    }

    public static int convertToNum(String string) {
        if (!string.isEmpty() && string.charAt(0) == ' ') string = string.substring(1);
        if (string.equals("one thousand")) {
            return 1000;
        }
        String[] words = string.split(" ");
        if (string.contains("hundred")) {
            return convertToNum(words[0]) * 100 +
                    convertToNum(string.substring(string.indexOf("hundred") + 8));
        }
        if (words[0].contains("ty")) {
            return convertToNum(words[0].substring(0, words[0].indexOf("ty"))) * 10 +
                    convertToNum(string.substring(string.indexOf("ty") + 2));
        }
        if (words[0].contains("teen")) {
            return convertToNum(words[0].substring(0, words[0].indexOf("teen"))) + 10 +
                    convertToNum(string.substring(string.indexOf("teen") + 4));
        }
        switch (words[0]) {
            case "zero" -> {
                return 0;
            }
            case "one" -> {
                return 1;
            }
            case "two", "twen" -> {
                return 2;
            }
            case "three", "thir" -> {
                return 3;
            }
            case "four", "for" -> {
                return 4;
            }
            case "five", "fif" -> {
                return 5;
            }
            case "six" -> {
                return 6;
            }
            case "seven" -> {
                return 7;
            }
            case "eight", "eigh" -> {
                return 8;
            }
            case "nine" -> {
                return 9;
            }
            case "ten" -> {
                return 10;
            }
            case "eleven" -> {
                return 11;
            }
            case "twelve" -> {
                return 12;
            }
        }
        return 0;
    }

    public static String uniqueSubstring(String string) {
        StringBuilder maxSubstring = new StringBuilder();
        StringBuilder nowSubstring = new StringBuilder();
        for (char symbol: string.toCharArray()) {
            if (!nowSubstring.toString().contains("" + symbol)){
                nowSubstring.append(symbol);
            }
            else {
                if (maxSubstring.length() < nowSubstring.length()) {
                    maxSubstring = nowSubstring;
                }
                nowSubstring = new StringBuilder(nowSubstring.substring(nowSubstring.indexOf("" + symbol)
                        + 1)).append(symbol);
            }
        }
        if (maxSubstring.length() < nowSubstring.length()) {
            maxSubstring = nowSubstring;
        }
        return maxSubstring.toString();
    }

    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        newMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            newMatrix[0][i] = newMatrix[0][i - 1] + matrix[0][i];
            newMatrix[i][0] = newMatrix[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                newMatrix[i][j] = matrix[i][j] + Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]);
            }
        }
        return newMatrix[n - 1][n - 1];
    }

    public static String numericOrder(String string) {
        String[] stringArray = string.split(" ");
        int n = stringArray.length;
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (String word: stringArray) {
                if (word.contains(Integer.toString(i))) {
                    answer.append(word.substring(0, word.indexOf(Integer.toString(i))) +
                            word.substring(word.indexOf(Integer.toString(i)) + 1) + " ");
                }
            }
        }
        return answer.toString();
    }

    public static int switchNums(int num1, int num2) {
        String[] stringNum1 = Integer.toString(num1).split("");
        String[] stringNum2 = Integer.toString(num2).split("");
        StringBuilder answer = new StringBuilder();
        Integer[] nums1 = new Integer[stringNum1.length];
        for (int i = 0; i < stringNum1.length; i++) {
            nums1[i] = Integer.parseInt(stringNum1[i]);
        }
        Arrays.sort(nums1, Collections.reverseOrder());
        for (String string : stringNum2) {
            if (Integer.parseInt(string) < nums1[0]) {
                answer.append(nums1[0]);
                nums1[0] = 0;
                Arrays.sort(nums1, Collections.reverseOrder());
            } else {
                answer.append(string);
            }
        }
        return Integer.parseInt(answer.toString());
    }
}