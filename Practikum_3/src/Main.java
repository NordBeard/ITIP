import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    //1 задача
    public static String replaceVovels(String str)
    {
        str = str.toLowerCase();
        char[] arr = {'a','e','i','o','u','y'};
        char[] arr2 = str.toCharArray();
        for(int i = 0; i < arr.length; i ++)
        {
            for(int j = 0;j<arr2.length;j++)
            {
                if(arr[i] == arr2[j])
                {
                    str = str.replace(arr2[j], '*');
                }
            }
        }
        return str;
    }
    //2 задача
    public static String stringTransform(String str)
    {
        char[] arr = str.toLowerCase().toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1 < arr.length) && (arr[i] == arr[i + 1])) {
                res += "Double" + str.substring(i, i + 1).toUpperCase();

            } else {
                res += arr[i];
            }
        }
        return res;
    }
    //3 Задача
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        boolean res = false;
        int[] arr1 = {a, b, c};
        int[] arr2 = {w, h};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if ((arr1[0] <= arr2[0]) && (arr1[1] <= arr2[1]))
            res = true;
        return res;
    }
    //4 задача
    public static boolean numCheck(int num) {
        int temp = num, sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp > 0) {
            arr.add(temp%10);
            temp /= 10;
        }
        Arrays.sort(new ArrayList[]{arr});
        for (int i = 0; i < arr.toArray().length; i++) {
            sum = sum + arr.get(i) * arr.get(i);
        }
        return num % 2 == sum % 2;
    }

    //5 задача
    public static int countRoots(int[] arr)
    {
        int kol = 0;
        int a = arr[0], b = arr[1], c = arr[2];
        int D = b*b - (4 * a * c);
        if (D > 0){
            if (((b * (-1) + Math.sqrt(D)) / (2 * a)) % 1 == 0)
                kol += 1;
            if (((b * (-1) - Math.sqrt(D)) / (2 * a)) % 1 == 0)
                kol += 1;
        }
        else if ((D == 0) && ((b * (-1) / (2 * a)) % 1 == 0))
            kol += 1;
        return kol;
    }
    //6 Задача
    public static ArrayList<String> salesData(String[][] mass_arr) {
        ArrayList<String> goods = new ArrayList<>();
        int[] col = new int[mass_arr.length];
        for (int i = 0; i < mass_arr.length; i++) {
            col[i] = mass_arr[i].length;
        }
        Arrays.sort(col);
        for (int i = 0; i < mass_arr.length; i++) {
            if (mass_arr[i].length == col[col.length - 1])
                goods.add(mass_arr[i][0]);
        }
        return goods;
    }
    //7 задача
    public static boolean validSplit(String str)
    {
        char[] arr = str.toLowerCase().toCharArray();
        int num1 = 0, num2 = 0;
        for (int i = 1; i < (arr.length - 1); i++) {
            if (arr[i] == ' ')
                num1 += 1;
            if (arr[i] == ' ' && arr[i-1] == arr[i+1])
                num2 += 1;
        }
        return num1 == num2;
    }
    //8 Задача
    public static boolean waveForm(int[] numbers)
    {
        boolean isUp = numbers[0] < numbers[1];
        for(int i = 0; i < numbers.length - 1;i++)
        {
            if(numbers[i] == numbers[i + 1])
            {
                return false;
            }
        }
        for (int i = 2; i < numbers.length; i++) {
            if (!((isUp && numbers[i - 1] > numbers[i]) || (!isUp && numbers[i] > numbers[i - 1]))) {
                return false;
            }
            isUp = !isUp;
        }
        return true;
    }
    //9 задача
    public static char commonVovel(String str)
    {
        int Max_vovels;
        int vovels_a = 0;
        int vovels_e = 0;
        int vovels_i = 0;
        int vovels_o = 0;
        int vovels_u = 0;
        int vovels_y = 0;
        str = str.toLowerCase();
        char[] vovels = {'a','e','i','o','u','y'};
        char[] ch = str.toCharArray();
        for(int i = 0;i<ch.length;i++)
        {
            if(ch[i] == vovels[0]){ vovels_a ++;}
            if(ch[i] == vovels[1]){vovels_e ++;}
            if(ch[i] == vovels[2]){vovels_i ++;}
            if(ch[i] == vovels[3]){vovels_o ++;}
            if(ch[i] == vovels[4]){vovels_u ++;}
            if(ch[i] == vovels[5]){vovels_y ++;}
        }
        Max_vovels = Math.max(vovels_a,Math.max(vovels_e,Math.max(vovels_i,
                Math.max(vovels_o,Math.max(vovels_u, vovels_y)))));
        if(Max_vovels == vovels_a) {return vovels[0];}
        if(Max_vovels == vovels_e) {return vovels[1];}
        if(Max_vovels == vovels_i) {return vovels[2];}
        if(Max_vovels == vovels_o) {return vovels[3];}
        if(Max_vovels == vovels_u) {return vovels[4];}

        return vovels[5];
    }
    //10 Задача
    public static int[][] dataScience(int[][] mass_arr) {
        int[][] arr = new int[mass_arr.length][mass_arr.length];
        int[] sum = new int[mass_arr.length];
        for (int k = 0; k < mass_arr.length; k++) {
            for (int l = 0; l < mass_arr[k].length; l++) {
                if (k != l)
                    sum[l] += mass_arr[k][l];
            }
        }
        for (int i = 0; i < mass_arr.length; i++) {
            for (int j = 0; j < mass_arr[i].length; j++) {
                arr[i][j] = mass_arr[i][j];
                if (i == j)
                    arr[i][j] = Math.round((float) sum[i] / (mass_arr.length - 1));
            }
        }
        return arr;
    }


    public static void main(String[] args) {
            //1 задача
            System.out.println(replaceVovels("apple"));
            System.out.println(replaceVovels("Even if you did this task not yourself, you have" +
                "to understand every single line of code"));
            System.out.println();
            //2 задача
            System.out.println(stringTransform("hello"));
            System.out.println(stringTransform("bookkeeper"));
            System.out.println();
            //3 Задача
            System.out.println(doesBlockFit(1,3,5,4,5));
            System.out.println(doesBlockFit(1,8,1,1,1));
            System.out.println(doesBlockFit(1,2,2,1,1));
            System.out.println();
            //4 Задача
            System.out.println(numCheck(243));
            System.out.println(numCheck(52));
            System.out.println();
            //5 задача
            int[] arr = {1,-3,2};
            int[] arr2 = {2,5,2};
            int[] arr3 = {1,-6,9};
            System.out.println(countRoots(arr));
            System.out.println(countRoots(arr2));
            System.out.println(countRoots(arr3));
            System.out.println();
            //6 Задача
            System.out.println(salesData(new String[][] {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Banana", "Shop2", "Shop3", "Shop4"}, {"Orange", "Shop1", "Shop3", "Shop4"}, {"Pear", "Shop2", "Shop4"}}));
            System.out.println(salesData(new String[][] {{"Fridge", "Shop2", "Shop3"}, {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Laptop", "Shop3", "Shop4"}, {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
            System.out.println();
            //7 задача
            System.out.println(validSplit("apple eagle egg goat"));
            System.out.println(validSplit("cat dog goose fish"));
            System.out.println();
            //8 Задача
            int[] arr4 = {1,2,3,4,5};
            int[] arr5 = {1,2,-6,10,3};
        int[] arr6 = {3,1,12,-6,10,3};

        System.out.println(waveForm(arr4));
            System.out.println(waveForm(arr5));
        System.out.println(waveForm(arr6));

        System.out.println();
            //9 Задача
            System.out.println(commonVovel("Hello World!"));
            System.out.println(commonVovel("Actions speak louder than words"));
            //10 Задача
            System.out.println(Arrays.deepToString(dataScience(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {5, 5, 5, 5, 5}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}})));
            System.out.println(Arrays.deepToString(dataScience(new int[][]{{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}})));


    }
}