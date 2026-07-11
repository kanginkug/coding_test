import java.util.*;
class Solution {
    // 1. 스테이지 번호와 실패율을 함께 묶을 클래스 생성
    class Stage implements Comparable<Stage> {
        int id;          // 스테이지 번호
        double rate;     // 실패율

        public Stage(int id, double rate) {
            this.id = id;
            this.rate = rate;
        }

        // 2. 정렬 기준 정의 (자바 정렬 문법)
        @Override
        public int compareTo(Stage o) {
            if (this.rate == o.rate) {
                return Integer.compare(this.id, o.id); // 실패율이 같으면 스테이지 번호 오름차순
            }
            return Double.compare(o.rate, this.rate); // 실패율 기준 내림차순 (o와 this의 위치를 바꾸면 내림차순이 됨)
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int stageLength = stages.length;
        List<Stage> stageList = new ArrayList<>();
        stages = Arrays.stream(stages).sorted().toArray();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int stage : stages) {
            hashMap.put(stage, hashMap.getOrDefault(stage, 0) +1);
        }

        for(int n =1; n <= N; n++) {
            int stageNum = hashMap.getOrDefault(n, 0);
            double rate = 0.0;
            if(stageLength > 0) {
                rate = (double) stageNum / stageLength;
            }
            Stage stage = new Stage(n, rate);
            stageList.add(stage);
            stageLength = stageLength - stageNum;
        }

        Collections.sort(stageList);
        for(int i = 0; i < stageList.size(); i++) {
            answer[i] = stageList.get(i).id;
        }
        return answer;
    }
}