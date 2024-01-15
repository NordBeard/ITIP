import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    //1 задача
    public static boolean duplicateChars(String str)
    {
        str = str.toLowerCase();
        char a;
        char b;
        for (int i = 0; i < str.length(); i++)
        {
            a = str.charAt(i);
            for (int j = i + 1; j<str.length();j++)
            {
                b = str.charAt(j);
                if (a == b)
                {
                    return true;
                }
            }
        }
        return false;
    }

    //2 задача
    public static String getInitials(String str)
    {
        String[] arr = str.split(" ");
        return arr[0].charAt(0) + "" + arr[1].charAt(0);
    }
    //3 задача
    public static int differenceEvenOdd(int[] arr)
    {
        int sumchet = 0;
        int sumnechet = 0;
        for (int i = 0; i < arr.length;i++)
        {
            if (arr[i] % 2 == 0)
            {
                sumchet += arr[i];
            }
            else {
                sumnechet += arr[i];
            }
        }

        return Math.abs(sumchet - sumnechet);
    }


    //4 задача
    public static boolean equalToAvg(int[] arr)
    {
        double sum = 0;
        for (int i = 0; i < arr.length;i++)
        {
            sum += arr[i];
        }
        sum = sum/arr.length;
        for(int i = 0; i<arr.length;i ++)
        {
            if(arr[i] == sum){
                return true;
            }
        }
        return false;
    }
    // 5 задача
    public static int[] indexMultiplier(int[] x){
        for (int i = 0; i < x.length;i++) {
            x[i] = x[i] * i;
        }
        return x;
    }
    //6 задача
    public static String reverse(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    //7 задача
    public static int Tribonacci(int x)
    {
        int j = 0; int a = 0; int b = 0; int c = 1; int timer = x;
        if (x == 0|| x== 1|| x==2){return 0;} else if (x == 3) {return 1;} else {
            for (int i = 3; i < timer;i++) {
                if (j == 0){ j = 1; a = a+b+c; x = a;}
                else if (j == 1){j = 2; b = a+b+c; x = b;}
                else if (j == 2){ j = 0; c = a+b+c; x = c;}
            }
        }
        return x;
    }
    //8 задача
    public static String generateQuasiHash(int length) {
        String characters = "abcdef0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
    //9 задача
    public static String botHelper(String str)
    {
        if(str.contains("help"))
        {
            if (str.equals("help"))
            {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }
    //10 задача
    public static boolean IsAnagram(String str1, String str2)
    {
        if(str1.length() != str2.length())
        {
            return false;
        }
        char[] charr1 = str1.toCharArray();
        char[] charr2 = str2.toCharArray();
        Arrays.sort(charr1);
        Arrays.sort(charr2);

        return Arrays.equals(charr1, charr2);
    }


    public static void main (String[] args){
        //1 задача
        System.out.println(duplicateChars("orange"));
        System.out.println(duplicateChars("Donald"));
        //2 задача
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        //3 задача
        int[] array = {44, 32, 86, 19};
        int[] array2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(array));
        System.out.println(differenceEvenOdd(array2));
        //4 задача
        int[] array_3 = {1,2,3,4,5};
        int[] array_4 = {1,2,3,4,6};
        System.out.println(equalToAvg(array_3));
        System.out.println(equalToAvg(array_4));
        //5 задача
        int[] array_1 = {1,2,3};
        int[] array_2 = {3,3,-2,408,3,31};
        System.out.println(Arrays.toString(indexMultiplier(array_1)));
        System.out.println(Arrays.toString(indexMultiplier(array_2)));
        //6 задача
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        //7 задача
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        //8 задача
        System.out.println(generateQuasiHash(5));
        System.out.println(generateQuasiHash(10));
        System.out.println(generateQuasiHash(0));
        //9 задача
        System.out.println(botHelper("Hello, I am under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        //10 задача
        System.out.println(IsAnagram("listen", "silent"));
        System.out.println(IsAnagram("eleven plus two", "twelve plus one"));
        System.out.println(IsAnagram("hello", "world"));

    }
}