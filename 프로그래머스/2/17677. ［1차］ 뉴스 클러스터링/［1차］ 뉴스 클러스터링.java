import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        str1Map = tranceMap(str1, str1Map);
        str2Map = tranceMap(str2, str2Map);
        if(str1Map.isEmpty() && str2Map.isEmpty()) {
            return 65536;
        }

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(str1Map.keySet());
        hashSet.addAll(str2Map.keySet());

        int min = 0;
        int max = 0;
        for(String key : hashSet) {
            if(str1Map.get(key) != null && str2Map.get(key) != null) {
                min += Math.min(str1Map.get(key), str2Map.get(key));
                max += Math.max(str1Map.get(key), str2Map.get(key));
            } else if(str1Map.get(key) == null) {
                max += str2Map.get(key);
            } else if(str2Map.get(key) == null) {
                max += str1Map.get(key);
            }
        }
        double share = (double) min /max;
        return (int) (share*65536);
    }
    public HashMap<String, Integer> tranceMap(String str, HashMap<String, Integer> strMap) {
        for(int i = 0; i < str.length(); i++) {
            if(i+1 < str.length()) {
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && str.charAt(i+1) >= 'A' && str.charAt(i+1) <= 'Z') {
                    String sumStr = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1));
                    strMap.put(sumStr, strMap.getOrDefault(sumStr,0)+1);
                }
            }
        }
        return strMap;
    }
}