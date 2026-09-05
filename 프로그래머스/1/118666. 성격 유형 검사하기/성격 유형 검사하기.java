import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < survey.length; i++) {
            String fir = String.valueOf(survey[i].charAt(0));
            String sec = String.valueOf(survey[i].charAt(1));
            int score = choices[i];
            if(score == 1) map.put(fir,map.getOrDefault(fir,0)+3);
            else if(score == 2) map.put(fir,map.getOrDefault(fir,0)+2);
            else if(score == 3) map.put(fir,map.getOrDefault(fir,0)+1);
            else if(score == 4) {
                map.put(fir, map.getOrDefault(fir, 0));
                map.put(sec, map.getOrDefault(sec, 0));
            }
            else if(score == 5) map.put(sec, map.getOrDefault(sec, 0)+1);
            else if(score == 6) map.put(sec, map.getOrDefault(sec, 0)+2);
            else if(score == 7) map.put(sec, map.getOrDefault(sec, 0)+3);
        }
        String[] strArr = new String[]{"R,T","C,F","J,M","A,N"};

        for(String str : strArr) {
            String[] stringArr = str.split(",");
            String firStr = stringArr[0];
            String secStr = stringArr[1];
            if(map.get(firStr) == null && map.get(secStr) == null) {
                answer += firStr;
            } else if(map.get(firStr) == null && map.get(secStr) != null) {
                answer += secStr;
            } else if(map.get(firStr) != null && map.get(secStr) == null) {
                answer += firStr;
            } else {
                int fir = map.get(firStr);
                int sec = map.get(secStr);
                if(fir >= sec) {
                    answer += firStr;
                } else {
                    answer += secStr;
                }
            }
        }
        return answer;
    }
}