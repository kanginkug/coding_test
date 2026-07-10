import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> partiMap = new HashMap<>();
        HashMap<String, Integer> compMap = new HashMap<>();
        for(String parti : participant) {
            partiMap.put(parti, partiMap.getOrDefault(parti, 0) +1);
        }

        for(String comp : completion) {
            compMap.put(comp, compMap.getOrDefault(comp, 0) +1);
        }

        String[] answer = new String[1];
        for(String partiKey : partiMap.keySet()) {
            if(compMap.get(partiKey) == null || !partiMap.get(partiKey).equals(compMap.get(partiKey))){
                answer[0] = partiKey;
            }
        }
        return answer[0];
    }
}