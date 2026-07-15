import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    class Process {
        int num;
        int priority;

        public Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> processQueue = new ArrayDeque<>();
        LinkedList<Integer> maxList = new LinkedList<>();
        ArrayList<Integer> answerArr = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++) {
            maxList.add(priorities[i]);
            Process process = new Process(i, priorities[i]);
            processQueue.offer(process);
        }
        maxList.sort((a,b) -> Integer.compare(b,a));

        while(!processQueue.isEmpty()) {
            Process pollProcess = processQueue.poll();
            if(maxList.get(0) == pollProcess.priority) {
                answerArr.add(pollProcess.num);
                maxList.remove(0);
            } else {
                processQueue.offer(pollProcess);
            }
        }
        int answer = 0;
        for(int i = 0; i < answerArr.size(); i++) {
            if(answerArr.get(i) == location) {
                answer = i +1;
                break;
            }
        }
        return answer;
    }
}