import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        s = s.replace("{","");
        s = s.replace("}","");
        String[] arr = s.split(",");
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(Integer.parseInt(arr[i]), map.getOrDefault(Integer.parseInt(arr[i]),0)+1);
        }
        int[] answer = new int[map.size()];
        for(int num : map.keySet()) {
            int value = map.get(num);
            answer[(value-map.size())*-1] = num;
        }
        return answer;
    }
}