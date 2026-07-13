import java.util.*;
class Solution {
    class Stage {
        int id;
        double rate;

        public Stage(int id, double rate) {
            this.id = id;
            this.rate = rate;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double personTotal = stages.length;
        ArrayList<Integer> stageList = new ArrayList();
        HashMap<Integer, Integer> stageMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Stage> list = new ArrayList<>();
        for(int stage : stages) {
            map.put(stage, map.getOrDefault(stage,0) +1);
        }
        for(int i = 1; i <= N; i++) {
            if(map.containsKey(i)) {
                stageMap.put(i, map.get(i));
            } else if(!map.containsKey(i)) {
                stageMap.put(i, 0);
            }
        }

        for(int stage : stageMap.keySet()) {
            int stagePerson = stageMap.get(stage);
            if(personTotal != 0.0) {
                Stage stage1 = new Stage(stage, stagePerson / personTotal);
                personTotal = personTotal - stagePerson;
                list.add(stage1);
            } else {
                Stage stage1 = new Stage(stage, 0);
                list.add(stage1);
            }
        }

        list.sort((a,b) -> {
            if (a.rate == b.rate) return Integer.compare(a.id, b.id);
            return Double.compare(b.rate, a.rate);
        });

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).id;
        }
        return answer;
    }
}