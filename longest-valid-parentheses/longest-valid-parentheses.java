import java.util.Stack;

public class LongestValidParentheses {
  public static int findLength(String s) {
    int i = 0;
    int l = s.length();
    for (; i < l; i++) {
      if (s.charAt(i) == '(') {
        break;
      }
    }
    if (i == s.length()) {
      return 0;
    }

    Stack<Character> q1 = new Stack<>();
    Stack<Integer> q2 = new Stack<>();
    for (; i < l; i++) {
      if (s.charAt(i) == '(') {
        q1.add('(');
        q2.push(-1);
      } else {
        if (!q1.isEmpty() && q1.peek() == '(') {
          q1.pop();
          q2.push(2);
        } else {
          q2.push(-1);
        }
      }
    }

    int max = 0;
    int current = 0;
    int num = 0;
    while (!q2.isEmpty()) {
      int val = q2.pop();
      if (val > 0) {
        num++;
        current = current + val;
      } else {
        num = num - 1;
        if (num < 0) {
          current = 0;
          num = 0;
        }
      }
      max = Math.max(max, current);
    }
    return max;
  }
}
