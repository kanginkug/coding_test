import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int y = 0; y < moves.length; y++){
            for (int x = 0; x < board.length; x++){
                int doll = 0;
                doll = board[x][moves[y]-1];
                if(doll != 0){
                    board[x][moves[y]-1] = 0;
                    if(!stack.isEmpty() && stack.peek().equals(doll)){
                        stack.pop();
                        cnt = cnt + 2;
                    }else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        return cnt;
    }
}