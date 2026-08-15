import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> hashMap = new HashMap<>();
        for(String str : record) {
            String[] senArr = str.split(" ");
            if(senArr[0].equals("Enter") || senArr[0].equals("Change")) {
                hashMap.put(senArr[1],senArr[2]);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for(String str : record) {
            String[] senArr = str.split(" ");
            String active = senArr[0];
            String nick = hashMap.get(senArr[1]);
            if(active.equals("Enter")) {
                list.add(nick+"님이 들어왔습니다.");
            } else if(active.equals("Leave")) {
                list.add(nick+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}