class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        // 커서 이동 횟수의 기본값 (오른쪽으로 끝까지 가는 경우)
        int minMove = len - 1;

        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);

            // 1. 상하 조작 횟수 (알파벳 변경)
            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            // 2. 연속된 'A'가 끝나는 위치(nextIndex) 찾기
            int nextIndex = i + 1;
            while (nextIndex < len && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 3. 좌우 이동 횟수 최솟값 갱신
            // - 그냥 오른쪽으로만 가기
            // - i까지 갔다가 돌아와서 뒤쪽부터 고치기 (i * 2 + len - nextIndex)
            // - 뒤쪽부터 고치고 다시 돌아와서 i 처리하기 ((len - nextIndex) * 2 + i)
            minMove = Math.min(minMove, i * 2 + (len - nextIndex));
            minMove = Math.min(minMove, (len - nextIndex) * 2 + i);
        }

        // 알파벳 변경 횟수 + 커서 이동 최솟값
        return answer + minMove;
    }
}