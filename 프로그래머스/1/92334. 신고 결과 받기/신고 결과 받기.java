import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> idMap = new HashMap<>();
        HashMap<String,Integer> countMap = new HashMap<>();
        HashMap<String, HashSet<String>> veriMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        for (String id : id_list) {
            idMap.put(id, idMap.getOrDefault(id,0));
            countMap.put(id, countMap.getOrDefault(id,0));
        }

        for(String id : report) {

            String[] reportSplit = id.split(" ");
            String from = reportSplit[0];
            String to = reportSplit[1];
            HashSet<String> set;
            if(veriMap.get(to) != null) {
                set = veriMap.get(to);
            } else {
                set = new HashSet<>();
            }
            if(veriMap.get(to) == null || !veriMap.get(to).contains(from)){
                idMap.put(to, idMap.get(to) + 1);
            }
            set.add(from);
            veriMap.put(to, set);
        }

        for(String from : idMap.keySet()) {
            for(String to : veriMap.keySet()) {
                if(veriMap.get(to).contains(from) && idMap.get(to) >= k) {
                    countMap.put(from, countMap.getOrDefault(from, 0) +1);
                }
            }
        }
        for(int i = 0; i < id_list.length; i++){
            String name = id_list[i]; // 순서대로 이름을 꺼낸다
            answer[i] = countMap.getOrDefault(name, 0);
        }
        return answer;
    }
}