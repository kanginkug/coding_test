import java.util.ArrayDeque;
class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            stack.push(str);
            int nextInx = i+1;
            if(nextInx <= s.length()) {
                while(!stack.isEmpty() && nextInx+1 <= s.length() && stack.peek() == s.charAt(nextInx)) {
                    stack.pop();
                    i = nextInx;
                    nextInx++;
                }
            }
        }

        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}