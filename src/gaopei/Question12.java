package gaopei;

public class Question12 {
    private static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (num < values[i]) {
                continue;
            }
            int count = num / values[i];
            for (int j = 0; j < count; j++) {
                result.append(symbols[i]);
            }
            num = num % values[i];
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        System.out.println(question12.intToRoman(3));
        System.out.println(question12.intToRoman(4));
        System.out.println(question12.intToRoman(9));
        System.out.println(question12.intToRoman(58));
        System.out.println(question12.intToRoman(1994));

    }
}
