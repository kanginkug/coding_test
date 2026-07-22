import java.util.ArrayList;
class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : citations) {
            arr.add(num);
        }

        arr.sort((a,b) -> Integer.compare(b,a));
        int answer = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) >= i + 1) {
                answer = i + 1;
            } else {
                break;
            }
        }

        return answer;
    }
}