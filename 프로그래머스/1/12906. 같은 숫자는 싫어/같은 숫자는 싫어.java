import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 1; i < arr.length; i++) {
            int prefix = arr[i-1];
            if(i == 1) {
                list.add(prefix);
            }
            if(arr[i] != prefix) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}