import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int x = 0; x < moves.length; x++) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][moves[x]-1] != 0) {
                    Integer stackPeek = 0;
                    if(!stack.isEmpty()) {
                        stackPeek = stack.peek();
                    }
                    stack.push(board[i][moves[x]-1]);
                    board[i][moves[x]-1] = 0;
                    if(stack.size() > 1 && stackPeek.equals(stack.peek())) {
                        stack.pop();
                        stack.pop();
                        answer++;
                        answer++;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}