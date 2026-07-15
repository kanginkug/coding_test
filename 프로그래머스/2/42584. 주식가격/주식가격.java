class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for(int x = i + 1; x < prices.length; x++) {
                cnt++;
                if(prices[i] > prices[x]){
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}