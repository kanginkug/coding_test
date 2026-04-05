import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Map<Integer,Integer> hashMap = new LinkedHashMap<>();
        ArrayList<Integer> person1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> person2 = new ArrayList<>(Arrays.asList(2,1,2,3,2,4,2,5));
        ArrayList<Integer> person3 = new ArrayList<>(Arrays.asList(3,3,1,1,2,2,4,4,5,5));
        int person1Cnt = 0;
        int person2Cnt = 0;
        int person3Cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(person1.get(i % person1.size()).equals(arr[i])){  // % 로 순환
                person1Cnt++;
            }
            if(person2.get(i % person2.size()).equals(arr[i])){
                person2Cnt++;
            }
            if(person3.get(i % person3.size()).equals(arr[i])){
                person3Cnt++;
            }
        }
        hashMap.put(1,person1Cnt);
        hashMap.put(2,person2Cnt);
        hashMap.put(3,person3Cnt);

        // 최댓값 찾기
        int maxVal = Collections.max(hashMap.values());

        // 최댓값인 key만 리스트에 담기
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
            if (e.getValue() == maxVal) {
                list.add(e.getKey());
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}