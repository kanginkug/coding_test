import java.util.*;
class Solution {
    TreeMap<String, Integer> hashMap = new TreeMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            StringBuilder str = new StringBuilder();
            for(int x = 0; x < ch.length; x++) {
                str.append(ch[x]);
            }
            orders[i] = str.toString();
        }

        TreeMap<Integer, Integer> maxMap = new TreeMap<>();
        for(int i = 0; i < course.length; i++) {
            maxMap.put(course[i], 0);
            for(int x = 0; x < orders.length; x++) {
                boolean[] visited = new boolean[orders[x].length()];
                DFS(0, "", orders[x], visited, course[i]);
            }
        }

        for(String key : hashMap.keySet()) {
            int cnt = hashMap.get(key);
            int max = Math.max(cnt, maxMap.get(key.length()));
            maxMap.put(key.length(),max);
        }
        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) > 1 && Objects.equals(maxMap.get(key.length()), hashMap.get(key))) {
                list.add(key);
            }
        }

        return list.toArray(new String[0]);
    }
    
    public void DFS(int start, String sum, String order, boolean[] visited, int course) {
        if(sum.length() == course) {
            hashMap.put(sum, hashMap.getOrDefault(sum,0)+1);
        }
        for(int i = start; i < order.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i, sum + order.charAt(i), order, visited, course);
                visited[i] = false;
            }
        }
    }
}