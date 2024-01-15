public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(" Это палиндром? " + isPalindrome(s));
        }
    }
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static boolean isPalindrome(String s){
        return s.equalsIgnoreCase(reverseString(s));
    }
}