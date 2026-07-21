import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    class Student {
        int cnt;
        int name;

        public Student(int cnt, int name) {
            this.cnt = cnt;
            this.name = name;
        }
    }
    public int[] solution(int[] answers) {
        ArrayList<Student> answerList = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int oneAns = 0;
        int twoAns = 0;
        int threeAns = 0;

        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                oneAns++;
            } if (answers[i] == two[i % 8]) {
                twoAns++;
            } if (answers[i] == three[i % 10]) {
                threeAns++;
            }
        }

        Student oneStu = new Student(oneAns, 1);
        Student twoStu = new Student(twoAns, 2);
        Student threeStu = new Student(threeAns, 3);
        answerList.add(oneStu);
        answerList.add(twoStu);
        answerList.add(threeStu);
        answerList.sort((a,b) -> Integer.compare(b.cnt, a.cnt));

        ArrayList<Integer> list = new ArrayList<>();
        if(answerList.get(0).cnt > answerList.get(1).cnt) {
            list.add(answerList.get(0).name);
        } else if(answerList.get(0).cnt == answerList.get(1).cnt && answerList.get(1).cnt > answerList.get(2).cnt) {
            list.add(answerList.get(0).name);
            list.add(answerList.get(1).name);
        } else if(answerList.get(0).cnt == answerList.get(1).cnt && answerList.get(1).cnt == answerList.get(2).cnt) {
            list.add(answerList.get(0).name);
            list.add(answerList.get(1).name);
            list.add(answerList.get(2).name);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}