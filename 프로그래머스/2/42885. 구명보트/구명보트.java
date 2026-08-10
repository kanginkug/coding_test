import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int right = people.length-1;
        int left = 0;
        int answer = 0;
        while(left<=right) {
            if(people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}