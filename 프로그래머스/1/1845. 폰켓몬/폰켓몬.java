import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int getNum = nums.length / 2;
        int answer = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            hashSet.add(num);
        }
        if(hashSet.size() >= getNum) {
            answer = getNum;
        }else {
            answer = hashSet.size();
        }
        return answer;
    }
}