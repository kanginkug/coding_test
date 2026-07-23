import java.util.Arrays;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = new int[2];
        for(int i = 3; i < sum; i++) {
            if(sum%i==0) {
                int width = i;
                int height = sum/i;
                if(height > width) {
                    int space = height;
                    height = width;
                    width = space;
                }
                if((width-2) * (height-2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
}