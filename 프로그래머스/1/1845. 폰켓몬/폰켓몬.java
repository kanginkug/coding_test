import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            hashSet.add(i);
        }
        int length = nums.length/2;
        int hashSetLength = hashSet.toArray().length;
        int answer = Math.min(length, hashSetLength);
        return answer;
    }
}