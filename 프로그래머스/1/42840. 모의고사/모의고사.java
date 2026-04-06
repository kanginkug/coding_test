import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int person1Cnt = 0;
        int person2Cnt = 0;
        int person3Cnt = 0;

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == person1[i % person1.length]) person1Cnt++;
            if(answers[i] == person2[i % person2.length]) person2Cnt++;
            if(answers[i] == person3[i % person3.length]) person3Cnt++;
        }

        int maxCnt = Math.max(person1Cnt, Math.max(person2Cnt,person3Cnt));
        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(person1Cnt);
        answerList.add(person2Cnt);
        answerList.add(person3Cnt);


        int cnt = 0;
        for(int i = 0; i < answerList.size(); i++){
            if(answerList.get(i) == maxCnt) cnt++;
        }
        int[] answer = new int[cnt];
        int answerCnt = 0;
        for(int i = 0; i < answerList.size(); i++){
            if(answerList.get(i) == maxCnt) answer[answerCnt++] = (i+1);
        }

        return answer;
    }
}