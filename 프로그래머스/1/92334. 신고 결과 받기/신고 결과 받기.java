import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for(String reportStr : report) {
            String[] reportArr = reportStr.split(" ");
            String from = reportArr[0];
            String to = reportArr[1];
            HashSet<String> hashSet;
            if(hashMap.get(to) != null) {
                hashSet = hashMap.get(to);
            }else {
                hashSet = new HashSet<>();
            }
            hashSet.add(from);
            hashMap.put(to, hashSet);
        }

        for(String reportStr : hashMap.keySet()) {
            if(hashMap.get(reportStr).size() >= k) {
                for(String from : hashMap.get(reportStr)) {
                    countMap.put(from, countMap.getOrDefault(from,0) +1);
                }
            }
        }

        for(int i = 0; i < id_list.length; i++) {
            if(countMap.get(id_list[i]) != null) {
                answer[i] = countMap.get(id_list[i]);
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}