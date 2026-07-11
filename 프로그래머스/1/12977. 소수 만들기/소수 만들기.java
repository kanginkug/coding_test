class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int x = i+1; x < nums.length; x++) {
                for(int y = x+1; y < nums.length; y++) {
                    int sum = nums[i] + nums[x] + nums[y];
                    boolean decimal = true;
                    for(int num = 2; num < sum/2+1; num++) {
                        if(sum%num==0) {
                            decimal = false;
                            break;
                        }
                    }
                    if(decimal) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}