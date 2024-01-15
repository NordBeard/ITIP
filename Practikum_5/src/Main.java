
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //1 Задача
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println();

        //2 Задача
        System.out.println(spiderVsFly("G2", "A2"));
        System.out.println(spiderVsFly("G2", "H4"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println();

        //3 Задача
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println();

        //4 Задача
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"},
                "tossed"));
        System.out.println();

        //5 Задача
        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println();

        //6 Задача
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println();

        //7 Задача
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println();

        //8 Задача
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println();

        //9 Задача
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println();

        //10 Задача
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
        System.out.println(isNew(1203));
    }

    //1 Задача
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        ArrayList<char[]> symbols = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            for (char[] chars : symbols) {
                if (str1.charAt(i) == chars[0]) {
                    if (str2.charAt(i) != chars[1]) {
                        return false;
                    }
                }
            }
            symbols.add(new char[]{str1.charAt(i), str2.charAt(i)});
        }
        return true;
    }

    //2 Задача
    public static String spiderVsFly(String spiderCord, String flyCord) {
        int spiderSymbol = spiderCord.charAt(0) - 65;
        int spiderNumber = Integer.parseInt(spiderCord.substring(1, 2));
        int flySymbol = flyCord.charAt(0) - 65;
        int flyNumber = Integer.parseInt(flyCord.substring(1, 2));
        if (flyNumber == 0) flySymbol = 0;


        double straightWay = 1;
        double[] ways = new double[5];
        for (int i = 0; i < 5; i++) ways[i] = i * Math.sqrt(2 - Math.sqrt(2));

        StringBuilder strWay1 = new StringBuilder(spiderCord);
        double intWay1 = 0;
        int nowSpiderSymbol1 = spiderSymbol;
        int nowSpiderNumber1 = spiderNumber;
        while (nowSpiderSymbol1 != flySymbol || nowSpiderNumber1 != flyNumber) {
            if (nowSpiderNumber1 == 0) {
                nowSpiderSymbol1 = flySymbol;
                nowSpiderNumber1 = 1;
            } else if (nowSpiderSymbol1 == spiderSymbol) {
                nowSpiderNumber1 -= 1;
                if (nowSpiderNumber1 == 0) nowSpiderSymbol1 = 0;
            } else {
                nowSpiderNumber1 += 1;
            }
            strWay1.append("-").append((char) (nowSpiderSymbol1 + 65)).append(nowSpiderNumber1);
            intWay1 += straightWay;
        }

        StringBuilder strWay2 = new StringBuilder(spiderCord);
        double intWay2 = 0;
        int nowSpiderSymbol2 = spiderSymbol;
        int nowSpiderNumber2 = spiderNumber;
        if (nowSpiderNumber2 > flyNumber) {
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 -= 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
        }
        else {
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 += 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
        }
        if (intWay1 <= intWay2) {
            return strWay1.toString();
        }
        return strWay2.toString();
    }

    //3 Задача
    public static int digitsCount(long numb) {
        if (numb < 10) {
            return 1;
        }
        return digitsCount(numb / 10) + 1;
    }

    //4 Задача
    public static int totalPoints(String[] words, String scrambledWord) {
        int answer = 0;
        ArrayList<String> uniqueWords = new ArrayList<>();
        uniqueWordList:
        for (String word: words) {
            for (String uniqueWord: uniqueWords) {
                if (uniqueWord.equals(word)) {
                    continue uniqueWordList;
                }
            }
            uniqueWords.add(word);
        }
        wordCheck:
        for (String word: uniqueWords) {
            if (word.length() > 2) {
                for (char symbol : word.toCharArray()) {
                    int symbolCount1 = word.length() - word.replace(String.valueOf(symbol), "").length();
                    int symbolCount2 = scrambledWord.length() - scrambledWord.replace(
                            String.valueOf(symbol), "").length();
                    if (symbolCount1 > symbolCount2) continue wordCheck;
                }
                answer += word.length() - 2;
                if (word.length() == 6) {
                    answer += 50;
                }
            }
        }
        return answer;
    }

    //5 Задача
    public static String sumsUp(int[] nums) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Integer> numsBefore = new ArrayList<>();
        check:
        for (int num: nums) {
            for(int i = 0; i < numsBefore.size(); i++) {
                int numBefore = numsBefore.get(i);
                if (num + numBefore == 8) {
                    answer.add(Arrays.toString(new int[] {Math.min(num, numBefore), Math.max(num, numBefore)}));
                    numsBefore.remove(i);
                    continue check;
                }
            }
            numsBefore.add(num);
        }
        return Arrays.toString(answer.toArray());
    }

    //6 Задача
    public static String takeDownAverage(String[] percentages) {
        int sumNum = 0;
        int n = percentages.length;
        for (String percentage : percentages) {
            int num = Integer.parseInt(percentage.replace("%", ""));
            sumNum += num;
        }
        double average = (double) sumNum / n;
        int myPercentage = (int) ((average - 5) * (n + 1) - sumNum);
        return myPercentage + "%";
    }

    //7 Задача
    public static String caesarCipher(String mode, String str, int rot) {
        StringBuilder answer = new StringBuilder();
        switch (mode) {
            case "encode" -> {
                for (char symbol : str.toCharArray()) {
                    if ('a' <= symbol && symbol <= 'z') {
                        char newSymbol = (char) (symbol - 32 + rot);
                        if (newSymbol > 'Z') newSymbol = (char) (newSymbol - 26);
                        answer.append(newSymbol);
                    } else {
                        answer.append(symbol);
                    }
                }
            }
            case "decode" -> {
                for (char symbol : str.toCharArray()) {
                    if ('a' <= symbol && symbol <= 'z') {
                        char newSymbol = (char) (symbol - 32 - rot);
                        if (newSymbol < 'A') newSymbol = (char) (newSymbol + 26);
                        answer.append(newSymbol);
                    } else {
                        answer.append(symbol);
                    }
                }
            }
        }
        return answer.toString();
    }

    //8 Задача
    public static int setSetup(int n, int k) {
        if (k == 1) {
            return n;
        }
        return n * setSetup(n - 1, k - 1);
    }

    //9 Задача
    public static String timeDifference(String city1, String firstDate, String city2) {
        String answer = "";

        int time1 = timeZone(city1);
        int time2 = timeZone(city2);
        int deltaTime = time2 - time1;
        int deltaHour = deltaTime / 60;
        int deltaMinute = deltaTime % 60;

        String[] words = firstDate.split(" ");
        int month = monthIndex(words[0]);
        int day = Integer.parseInt(words[1].replace(",", ""));
        int year = Integer.parseInt(words[2]);
        String[] time = words[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int newYear = year;
        int newMonth = month;
        int newDay = day;
        int newHour = hour + deltaHour;
        int newMinute = minute + deltaMinute;

        if (newMinute < 0) {
            newMinute += 60;
            newHour -= 1;
        }
        else if (newMinute >= 60) {
            newMinute -= 60;
            newHour += 1;
        }

        if (newHour < 0) {
            newHour += 24;
            newDay -= 1;
        }
        else if (newHour >= 24) {
            newHour -= 24;
            newDay += 1;
        }

        if (newDay == 0) {
            newMonth -= 1;
            if (newMonth == 0) {
                newMonth = 12;
                newYear -= 1;
            }
            newDay = dayInMonth(newMonth, newYear);
        }
        else if (newDay > dayInMonth(newMonth, newYear)) {
            newMonth += 1;
            if (newMonth == 13) {
                newMonth = 1;
                newYear += 1;
            }
            newDay = 1;
        }

        String strMinute;
        if (newMinute < 10) {
            strMinute = "0" + newMinute;
        }
        else {
            strMinute = Integer.toString(newMinute);
        }

        String strHour;
        if (newHour < 10) {
            strHour = "0" + newHour;
        }
        else {
            strHour = Integer.toString(newHour);
        }
        answer = newYear + "-" + newMonth + "-" + newDay + " " + strHour + ":" + strMinute;
        return answer;
    }
    public static int timeZone(String city) {
        int time = 0;
        switch (city) {
            case "Los Angeles" -> time = -8 * 60;
            case "New York" -> time = -5 * 60;
            case "Caracas" -> time = -(4 * 60 + 30);
            case "Buenos Aires" -> time = -3 * 60;
            case "London" -> time = 0;
            case "Rome" -> time = 60;
            case "Moscow" -> time = 3 * 60;
            case "Tehran" -> time = 3 * 60 + 30;
            case "New Delhi" -> time = 5 * 60 + 30;
            case "Beijing" -> time = 8 * 60;
            case "Canberra" -> time = 10 * 60;
        }
        return time;
    }

    public static int monthIndex(String month) {
        int index = 0;
        switch (month) {
            case "January" -> index = 1;
            case "February" -> index = 2;
            case "March" -> index = 3;
            case "April" -> index = 4;
            case "May" -> index = 5;
            case "June" -> index = 6;
            case "July" -> index = 7;
            case "August" -> index = 8;
            case "September" -> index = 9;
            case "October" -> index = 10;
            case "November" -> index = 11;
            case "December" -> index = 12;
        }
        return index;
    }

    public static int dayInMonth(int monthIndex, int year) {
        int days = 0;
        switch (monthIndex) {
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 4, 6, 9, 11 -> days = 30;
            case 2 -> {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29;
                }
                else {
                    days = 28;
                }
            }
        }
        return days;
    }

    //10 Задача
    public static boolean isNew(int numb) {
        String strNumb = Integer.toString(numb);
        int[] numbs = new int[strNumb.length()];
        String numbWithoutZeros = strNumb.replace("0", "");
        int[] numbsWithoutZeros = new int[numbWithoutZeros.length()];
        int j = 0;
        for (int i = 0; i < strNumb.length(); i++) {
            int nowNumb = Integer.parseInt(strNumb.substring(i, i + 1));
            if (nowNumb != 0) {
                numbsWithoutZeros[j] = nowNumb;
                j += 1;
            }
            numbs[i] = nowNumb;
        }
        Arrays.sort(numbs);
        Arrays.sort(numbsWithoutZeros);
        StringBuilder minNumb = new StringBuilder(Integer.toString(numbsWithoutZeros[0]));
        int index = numbs.length - numbsWithoutZeros.length;
        for (int i = 0; i < numbs.length; i++) {
            if (i != index) minNumb.append(numbs[i]);
        }
        return strNumb.contentEquals(minNumb);
    }
}