import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int width = maps.length;
        int height = maps[0].length;
        int[][] visited = new int[width][height];
        boolean[][] booVisit = new boolean[width][height];
        visited[0][0] = 1;
        booVisit[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()) {
            int[] location = queue.poll();
            int x = location[0];
            int y = location[1];
            if(x == width -1 && y == height -1) {
                return visited[x][y];
            }

            for(int i = 0; i < 4; i++) {
                int sumX = x + dx[i];
                int sumY = y + dy[i];
                if(sumX >= 0 && sumX < width && sumY >= 0 && sumY < height) {
                    if(maps[sumX][sumY] == 1 && !booVisit[sumX][sumY]) {
                        visited[sumX][sumY] = visited[x][y] +1;
                        booVisit[sumX][sumY] = true;
                        queue.offer(new int[]{sumX,sumY});
                    }
                }
            }
        }

        return  -1;
    }
}