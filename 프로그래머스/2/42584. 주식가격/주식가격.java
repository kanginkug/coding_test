import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new ArrayDeque<>();
        int max = 0;
        for(int price : prices) {
            if(price > max) {
                max = price;
            }
            queue.offer(price);
        }
        int[] answer = new int[prices.length];
        if(max == 0) {
            for(int i = 0; i < prices.length; i++) {
                answer[i] = 0;
            }
            return answer;
        }
        int inx = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int cnt = -1;
            for(int i = inx; i < prices.length; i++) {
                cnt++;
                if(poll > prices[i]) {
                    break;
                }
            }
            answer[inx] = cnt;
            inx++;
        }
        return answer;
    }
}