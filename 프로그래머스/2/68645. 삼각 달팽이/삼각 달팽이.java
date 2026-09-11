import java.util.Arrays;
class Solution {
   public int[] solution(int n) {
        int[][] matrix = new int[n][n];

        int r = -1; // 첫 이동에서 아래(r++)로 가므로 -1에서 시작
        int c = 0;
        int num = 1;

        // i는 회전 횟수이자 채울 칸 수의 감소를 결정
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // 한 턴마다 채우는 칸 수가 (n - i)개로 줄어듦
                if (i % 3 == 0) {
                    // 아래로 이동
                    r++;
                } else if (i % 3 == 1) {
                    // 오른쪽으로 이동
                    c++;
                } else if (i % 3 == 2) {
                    // 대각선 위로 이동
                    r--;
                    c--;
                }
                matrix[r][c] = num++;
            }
        }

        // 1차원 배열로 옮겨 담기 (총 숫자의 개수는 n * (n + 1) / 2)
        int[] answer = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = matrix[i][j];
            }
        }

        return answer;
    }
}