import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] nums = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i%person1.length]) {
                nums[0] = nums[0]+1;
            }
            if(answers[i] == person2[i%person2.length]) {
                nums[1] = nums[1]+1;
            }
            if(answers[i] == person3[i%person3.length]) {
                nums[2] = nums[2]+1;
            }
        }
        int max = Math.max(nums[0], Math.max(nums[1],nums[2]));
        ArrayList<Integer> arr = new ArrayList<>();
        if(nums[0] == max) arr.add(1);
        if(nums[1] == max) arr.add(2);
        if(nums[2] == max) arr.add(3);
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}