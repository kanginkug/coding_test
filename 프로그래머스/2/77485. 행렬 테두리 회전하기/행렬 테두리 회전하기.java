class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] query = new int[rows][columns];
        int[] answer = new int[queries.length];
        int cnt = 1;
        for(int x = 0; x < query.length; x++) {
            for(int y = 0; y < query[0].length; y++) {
                query[x][y] = cnt;
                cnt++;
            }
        }
        int inx = 0;
        for(int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0] - 1;
            int c1 = queries[i][1] - 1;
            int r2 = queries[i][2] - 1;
            int c2 = queries[i][3] - 1;

            int temp = query[r1][c1];
            int min = query[r1][c1];
            for(int x = r1; x < r2; x++) {
                min = Math.min(min, query[x+1][c1]);
                query[x][c1] = query[x+1][c1];
            }
            for(int x = c1; x < c2; x++) {
                min = Math.min(min, query[r2][x+1]);
                query[r2][x] = query[r2][x+1];
            }
            for(int x = r2; x > r1; x--) {
                min = Math.min(min, query[x-1][c2]);
                query[x][c2] = query[x-1][c2];
            }
            for(int x = c2; x > c1; x--) {
                min = Math.min(min, query[r1][x-1]);
                query[r1][x] = query[r1][x-1];
            }
            query[r1][c1+1] = temp;
            answer[inx] = min;
            inx++;
        }
        return answer;
    }
}