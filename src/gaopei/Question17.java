package gaopei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {
    private static Map<Character, String> indexMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        list.add("");
        for (Character c : digits.toCharArray()) {
            String index = indexMap.get(c);
            if (index == null) {
                continue;
            }

            List<String> res = new ArrayList<>();
            for (Character i : index.toCharArray()) {
                for (String s : list) {
                    res.add(s + i);
                }
            }
            list = res;
        }
        return list;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        append(digits, 0, stringBuilder, list);

        return list;
    }

    private void append(String digits, int index, StringBuilder builder, List<String> res) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        String str = indexMap.get(digits.charAt(index));
        for (char c : str.toCharArray()) {
            builder.append(c);
            append(digits, index + 1, builder, res);
            builder.deleteCharAt(index);
        }

    }

    public static void main(String[] args) {
        Question17 question = new Question17();
        System.out.println(question.letterCombinations("23"));
    }
}
