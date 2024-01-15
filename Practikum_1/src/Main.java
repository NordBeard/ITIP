public class Main {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println();

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println();

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println();

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 6));
        System.out.println(triangleType(5, 1, 1));
        System.out.println();

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println();

        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println();

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println();

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println();

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println();

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static float convert(int x) {
        return x * 3.785f;
    }

    public static int fitCalc(int x, int y) {
        return x * y;
    }

    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }

    public static String triangleType(float x, float y, float z) {
        if ((x < y + z) & (y < x + z) & (z < x + y)) {
            if ((x == y) & (y == z)) return "equilateral";
            else if ((x == y) | (y == z) | (x == z)) return "isosceles";
            else return "different-sided";
        }
        else return "not a triangle";
    }

    public static float ternaryEvaluation(float x, float y) {
        return x > y ? x : y;
    }

    public static int howManyItems(int x, float w, float h) {
        //    float n = x / 2f;
        //    return (int)(n / (w * h));
        return (int)(ternaryEvaluation((int)(x / w) * (int)(2 / h), (int)(x / h) * (int)(2 / w)) / 2);
    }

    public static int factorial(int x) {
        int answer = 1;
        while (x != 1) {
            answer *= x;
            x -= 1;
        }
        return answer;
    }

    public static int gcd(int x, int y) {
        while (x != y) {
            if (x > y) x -= y;
            else y -= x;
        }
        return x;
    }

    public static float ticketSaler(int x, int y) {
        return x * y * 0.72f;
    }

    public static int tables(int x, int y) {
        if (y * 2 >= x) return 0;
        return (int)(x - y * 2 + 1) / 2;
    }

    public static String newfirst() {
        return "NewFirst";
    }

    public static String second() {
        return "Second";
    }

    public static String masterthird() {
        return "MasterThird";
    }
}