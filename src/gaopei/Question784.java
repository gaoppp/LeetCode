package gaopei;

import java.util.ArrayList;
import java.util.List;

public class Question784 {
    public List<String> letterCasePermutation1(String s) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (char c : s.toCharArray()) {
            List<String> curr = new ArrayList<>();
            for (String str : result) {
                curr.add(str + c);
            }

            if (c >= 'a' && c <= 'z') {
                for (String str : result) {
                    curr.add(str + (char) (c - 32));
                }
            }
            if (c >= 'A' && c <= 'Z') {
                for (String str : result) {
                    curr.add(str + (char) (c + 32));
                }
            }
            result = curr;
        }
        return result;
    }

    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c : S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
                continue;
            }
            for (StringBuilder stringBuilder : ans) {
                stringBuilder.append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb : ans)
            finalans.add(sb.toString());
        return finalans;
    }

    public static void main(String[] args) {
        System.out.println((int) 'A' - (int) 'a');
        System.out.println((char) ('A' - 32));
        Question784 question = new Question784();
        System.out.println(question.letterCasePermutation("a1B"));
    }
}
