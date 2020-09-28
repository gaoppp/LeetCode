package gaopei;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class Question155 {
    public static class MinStack {

        private Stack<Integer> data;
        private Stack<Integer> min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        public void pop() {
            if (data.pop().equals(min.peek())) {
                min.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }


    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-2);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());  //     --> 返回 0.
        System.out.println(minStack.getMin());  //  --> 返回 -2.

    }
}
