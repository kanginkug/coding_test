import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> proList = new ArrayList<>();
        List<Integer> speedList = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            queue.offer(progresses[i]);
            proList.add(progresses[i]);
            speedList.add(speeds[i]);
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            queue.clear();
            int cnt = 0;
            for (int i = 0; i < proList.size(); i++) {
                int sum = proList.get(i) + speedList.get(i);
                proList.remove(i);
                proList.add(i, sum);
                if(proList.get(0) >= 100){
                    proList.remove(0);
                    speedList.remove(0);
                    i--;
                }
                queue.offer(sum);
            }
            for (int i = 0; i < queue.size(); i++) {
                if (queue.peek() >= 100) {
                    queue.poll();
                    cnt++;
                    i--;
                } else {
                    break;
                }

            }
            if(cnt > 0){
                list.add(cnt);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);

        }

        return answer;
    }
}