import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList list = new ArrayList();
        int answer = 0;
        for(int i = 0; i < moves.length; i++) {
            for(int x = 0; x < board.length; x++) {
                if(board[x][moves[i]-1] != 0) {
                    list.add(board[x][moves[i]-1]);
                    board[x][moves[i]-1] = 0;
                    if(list.size() > 1) {
                        if(list.get(list.size()-1) == list.get(list.size()-2)) {
                            list.remove(list.size()-1);
                            list.remove(list.size()-1);
                            answer= answer +2;
                        }
                    }
                    break;
                }
                
            }
        }
        return answer;
    }
}