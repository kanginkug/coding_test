class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        // index = 0번째 숫자부터 시작, 현재 sum = 0
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int index, int sum) {
        // 1. [탈출 조건] 모든 숫자를 다 검사했을 때
        if (index == numbers.length) {
            // 타겟 넘버를 만들었다면 정답 추가!
            if (sum == target) {
                answer++;
            }
            return; // ★ 반드시 return으로 함수를 끝내줘야 함!
        }

        // 2. [두 갈림길 선택]
        // 현재 숫자(numbers[index])를 빼는 경우 (-)
        dfs(numbers, target, index + 1, sum - numbers[index]);

        // 현재 숫자(numbers[index])를 더하는 경우 (+)
        dfs(numbers, target, index + 1, sum + numbers[index]);
    }
}