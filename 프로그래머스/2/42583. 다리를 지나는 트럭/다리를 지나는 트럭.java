import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++){
            bridgeQueue.offer(0);
        }
        ArrayList<Integer> truckList = new ArrayList<>();
        for(int a : truck_weights) {
            truckList.add(a);
        }

        int totalWeight = 0;
        int answer = 0;
        while(!bridgeQueue.isEmpty()){
            answer++;
            int peek = bridgeQueue.poll();
            totalWeight = totalWeight - peek;
            if(!truckList.isEmpty()) {
                if(truckList.get(0) + totalWeight > weight) {
                    bridgeQueue.offer(0);
                } else {
                    bridgeQueue.offer(truckList.get(0));
                    totalWeight = totalWeight + truckList.get(0);
                    truckList.remove(0);
                }
            }
        }
        return answer;
    }
}