import java.util.ArrayList;
class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : citations) {
            list.add(i);
        }
        list.sort((a,b) -> Integer.compare(b,a));
        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) >= i+1) {
                answer = i+1;
            } else {
                break;
            }
        }
        return answer;
    }
}