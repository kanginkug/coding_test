import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int[] solution(int[] numbers) {
        int cnt = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < numbers.length ; i++){
            for(int y = i+1; y < numbers.length; y++){
                int addNum = numbers[i] + numbers[y];
                hashSet.add(addNum);
            }
        }
        int[] answer = new int[hashSet.size()];
        for (int num : hashSet) {
            answer[cnt++] = num;
        }
        answer = Arrays.stream(answer).sorted().toArray();
        return answer;
    }
}