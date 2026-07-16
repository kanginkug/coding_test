import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int truck : truck_weights) {
            arrList.add(truck);
        }
        Queue<Integer> bridgeQueue = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }
        int answer = 0;
        int totalWeight = 0;
        while(!bridgeQueue.isEmpty()) {
            answer++;
            int peek = bridgeQueue.poll();
            totalWeight = totalWeight - peek;
            for(int i = 0; i < truck_weights.length; i++) {
                if(truck_weights[i] > 0){
                    if(totalWeight + truck_weights[i] > weight) {
                        bridgeQueue.offer(0);
                    } else {
                        totalWeight = totalWeight + truck_weights[i];
                        bridgeQueue.offer(truck_weights[i]);
                        truck_weights[i]=0;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}