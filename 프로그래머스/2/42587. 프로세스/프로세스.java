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
        ArrayList<Integer> maxList = new ArrayList<>();
        LinkedList<Integer> answerArr = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            maxList.add(priorities[i]);
            Process process = new Process(i, priorities[i]);
            processQueue.offer(process);
        }
        maxList.sort((a,b) -> Integer.compare(b,a));

        while(!processQueue.isEmpty()) {
            for(Process process : processQueue) {
                int priority = process.priority;
                if(maxList.get(0) == priority) {
                    answerArr.add(process.num);
                    maxList.remove(0);
                    processQueue.poll();
                } else {
                    processQueue.poll();
                    Process newProcess = new Process(process.num, process.priority);
                    processQueue.offer(newProcess);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < answerArr.size(); i++) {
            if(answerArr.get(i) == location) {
                answer = i+1;
                break;
            }
        }

        return answer;
    }
}