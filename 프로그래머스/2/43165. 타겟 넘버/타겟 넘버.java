class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        int inx = 0;
        int sum = 0;
        DFS(inx, numbers, target, sum);
        return cnt;
    }
    public void DFS(int inx, int[] numbers, int target, int sum) {
        if(inx == numbers.length && sum == target) {
            cnt ++;
        }
        if(inx == numbers.length) {
            return;
        }
        DFS(inx+1, numbers, target, sum - numbers[inx]);
        DFS(inx+1, numbers, target, sum + numbers[inx]);
    }
}