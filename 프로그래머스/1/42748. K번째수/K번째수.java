import java.util.ArrayList;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] -1;
            int end = commands[i][1] -1;
            int location = commands[i][2] -1;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int x = start; x <= end; x++) {
                arr.add(array[x]);
            }
            arr.sort(Integer::compare);
            answer[i] = arr.get(location);
        }
        return answer;
    }
}