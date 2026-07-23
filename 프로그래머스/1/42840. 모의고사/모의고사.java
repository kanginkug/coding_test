import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answerArr = {0,0,0};
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person1[i % person1.length]) {
                answerArr[0] += 1;
            }
            if(answers[i] == person2[i % person2.length]) {
                answerArr[1] += 1;
            }
            if(answers[i] == person3[i % person3.length]) {
                answerArr[2] += 1;
            }
        }
        int max = Math.max(answerArr[0], Math.max(answerArr[1], answerArr[2]));

        ArrayList<Integer> arrList = new ArrayList<>();
        if(answerArr[0] == max) arrList.add(1);
        if(answerArr[1] == max) arrList.add(2);
        if(answerArr[2] == max) arrList.add(3);

        int[] answer = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}