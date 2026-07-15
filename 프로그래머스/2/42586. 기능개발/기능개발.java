import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((double) (100 - progresses[i]) /speeds[i]));
        }

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            int cnt = 1;
            for(int next : queue) {
                if(poll >= next) {
                    queue.poll();
                    cnt++;
                } else {
                    break;
                }
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}