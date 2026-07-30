import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int[] cntArr = new int[words.length];
        HashMap<String, Integer> map = new HashMap<>();
        map.put(begin,0);
        Queue<HashMap<String,Integer>> queue = new ArrayDeque<>();
        queue.offer(map);

        while (!queue.isEmpty()) {
            HashMap<String,Integer> queueMap = queue.poll();
            String str = "";
            int num = 0;

            for (String queueStr : queueMap.keySet()) {
                str = queueStr;
                num = queueMap.get(str);
            }
            if(str.equals(target)) {
                return num;
            }

            for(int x = 0; x < words.length; x++ ){
                if(!visited[x]) {
                    int cnt = 0;
                    for(int i = 0; i < str.length(); i++) {
                        if(str.charAt(i) != words[x].charAt(i)){
                            cnt++;
                        }
                    }
                    if(cnt == 1) {
                        visited[x] = true;
                        HashMap<String, Integer> offerMap = new HashMap<>();
                        offerMap.put(words[x], num+1);
                        queue.offer(offerMap);
                    }
                }
            }

        }
        return 0;
    }
}