package gaopei;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * <p>
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * <p>
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1496 {

    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(0);
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }
            int hash = hash(x, y);
            if (!set.add(hash)) {
                return true;
            }
        }
        return false;
    }

    private int hash(int x, int y) {
        return x * 20001 + y;
    }

    public static void main(String[] args) {
        Question1496 question = new Question1496();
        System.out.println(question.isPathCrossing("NES"));
        System.out.println(question.isPathCrossing("NNSWWEWSSESSWENNW"));

    }

}
