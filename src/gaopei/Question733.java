package gaopei;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 注意:
 * <p>
 * image 和 image[0] 的长度在范围 [1, 50] 内。
 * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question733 {

    /**
     * 深度
     */
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return null;
        }
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return;
        }
        int curr = image[sr][sc];
        image[sr][sc] = newColor;
        // 上
        if (sr > 0 && sc < image[sr - 1].length && image[sr - 1][sc] == curr) {
            dfs(image, sr - 1, sc, newColor);
        }
        // 下
        if (sr + 1 < image.length && sc < image[sr + 1].length && image[sr + 1][sc] == curr) {
            dfs(image, sr + 1, sc, newColor);
        }
        // 左
        if (sc > 0 && image[sr][sc - 1] == curr) {
            dfs(image, sr, sc - 1, newColor);
        }
        // 右
        if (sc + 1 < image[sr].length && image[sr][sc + 1] == curr) {
            dfs(image, sr, sc + 1, newColor);
        }
    }

    /**
     * 广度
     */
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] src = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Question733 question = new Question733();
        src = question.floodFill(src, 1, 1, 2);
        for (int[] a : src) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
