import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList();
        int prefix = 10;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != prefix) {
                list.add(arr[i]);
            }
            prefix = arr[i];
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}