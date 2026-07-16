import java.util.*;
class Solution {
    class Stage{
        int priority = 0;
        int location = 0;
        public Stage(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    public int solution(int[] priorities, int location) {
        LinkedList<Stage> list = new LinkedList<>();
        LinkedList<Integer> maxList = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            Stage stage = new Stage(priorities[i], i);
            list.addLast(stage);
            maxList.addLast(priorities[i]);
            queue.offer(priorities[i]);
        }
        maxList.sort((a,b) -> Integer.compare(b,a));
        while(!queue.isEmpty()){
            int poll = queue.poll();
            Stage first = list.getFirst();
            list.removeFirst();
            if(maxList.get(0) > poll) {
                list.addLast(first);
                queue.offer(poll);
            } else if(maxList.get(0) == poll){
                answerList.add(first.location);
                maxList.removeFirst();
            }
        }
        for(int i = 0; i < answerList.size(); i++) {
            if(location == answerList.get(i)) {
                System.out.println(i+1);
                return i+1;
            }
        }
        return 0;
    }
}